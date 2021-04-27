var code;
var che;

jQuery(document).ready(function(jQuery){
	//hide the subtle gradient layer (.cd-pricing-list > li::after) when pricing table has been scrolled to the end (mobile version only)
	checkScrolling(jQuery('.cd-pricing-body'));
	jQuery(window).on('resize', function(){
		window.requestAnimationFrame(function(){checkScrolling(jQuery('.cd-pricing-body'))});
	});
	jQuery('.cd-pricing-body').on('scroll', function(){ 
		var selected = jQuery(this);
		window.requestAnimationFrame(function(){checkScrolling(selected)});
	});

	function checkScrolling(tables){
		tables.each(function(){
			var table= jQuery(this),
				totalTableWidth = parseInt(table.children('.cd-pricing-features').width()),
		 		tableViewport = parseInt(table.width());
			if( table.scrollLeft() >= totalTableWidth - tableViewport -1 ) {
				table.parent('li').addClass('is-ended');
			} else {
				table.parent('li').removeClass('is-ended');
			}
		});
	}

	//switch from monthly to annual pricing tables
	bouncy_filter(jQuery('.cd-pricing-container'));

	function bouncy_filter(container) {
		container.each(function(){
			var pricing_table = jQuery(this);
			var filter_list_container = pricing_table.children('.cd-pricing-switcher'),
				filter_radios = filter_list_container.find('input[type="radio"]'),
				pricing_table_wrapper = pricing_table.find('.cd-pricing-wrapper');

			//store pricing table items
			var table_elements = {};
			filter_radios.each(function(){
				var filter_type = jQuery(this).val();
				table_elements[filter_type] = pricing_table_wrapper.find('li[data-type="'+filter_type+'"]');
			});

			//detect input change event
			filter_radios.on('change', function(event){
				event.preventDefault();
				//detect which radio input item was checked
				var selected_filter = jQuery(event.target).val();

				//give higher z-index to the pricing table items selected by the radio input
				show_selected_items(table_elements[selected_filter]);

				//rotate each cd-pricing-wrapper 
				//at the end of the animation hide the not-selected pricing tables and rotate back the .cd-pricing-wrapper
				
				if( !Modernizr.cssanimations ) {
					hide_not_selected_items(table_elements, selected_filter);
					pricing_table_wrapper.removeClass('is-switched');
				} else {
					pricing_table_wrapper.addClass('is-switched').eq(0).one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function() {		
						hide_not_selected_items(table_elements, selected_filter);
						pricing_table_wrapper.removeClass('is-switched');
						//change rotation direction if .cd-pricing-list has the .cd-bounce-invert class
						if(pricing_table.find('.cd-pricing-list').hasClass('cd-bounce-invert')) pricing_table_wrapper.toggleClass('reverse-animation');
					});
				}
			});
		});
	}
	function show_selected_items(selected_elements) {
		selected_elements.addClass('is-selected');
	}

	function hide_not_selected_items(table_containers, filter) {
		jQuery.each(table_containers, function(key, value){
	  		if ( key != filter ) {	
				jQuery(this).removeClass('is-visible is-selected').addClass('is-hidden');

			} else {
				jQuery(this).addClass('is-visible').removeClass('is-hidden is-selected');
			}
		});
	}
	
	
	
	
	
	// 5. '우편번호찾기 화면-시' 세팅
	initCitySelect();
	
	jQuery("#tbZipResult").on("dblclick","tbody tr",function(){
		//this ==> tr
		
		var zipcode = jQuery(this).children("td:eq(0)").text();
		var addr = jQuery(this).children("td:eq(1)").text();
		
		//메인화면(부모창)의 우편번호,주소 input에 데이터 세팅
		jQuery("#memZip").val(zipcode);
		jQuery("#memAdd").val(addr);
		
		jQuery("#zipModal").modal("hide");
		
	});
	
	
/*	jQuery("#btnZip").on("click","#btnZip",function(){
		//this ==> tr
		searchZipCode2();
		
	});
	*/
	
	
	
});



function initCitySelect(){
	var param = {
			'flag' : 'SI'
	};
	
	jQuery.ajax({
		url : "/HW_realmain/ZipServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeCitySelect(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
}


function makeCitySelect(data){
	// 방법1)
	var strHtml = '<option value="">선택하세요</option>';
//	var strHtml = '';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].sido +'">' + data[i].sido + '</option>';
	}
	jQuery("#city").html(strHtml);
	
	setGu();
	
	// 방법2)
	//setGu();
	
	// 방법3)
	//trigger로 change 이벤트 호출
}


function setGu(){
	var param = {
			'sido' : jQuery("#city").val()
			,'flag' : 'GU'
	};
	
	jQuery.ajax({
		url : "/HW_realmain/ZipServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeGugunSelect(data);
			
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});	
}

function makeGugunSelect(data){
	var strHtml = '<option value="">선택하세요</option>';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].gugun +'">' + data[i].gugun + '</option>';
	}
	jQuery("#gu").html(strHtml);
	jQuery("#gu").prop("disabled", false);
	
	 setDong();
}


function setDong(){
	var param = {
			'sido' : jQuery("#city").val()
			,'gugun' : jQuery("#gu").val()
			,'flag' : 'DONG'
	};
	
	jQuery.ajax({
		url : "/HW_realmain/ZipServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeDongSelect(data);
			
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
	
}

function makeDongSelect(data){
	var strHtml = '<option value="">선택하세요</option>';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].dong +'">' + data[i].dong + '</option>';
	}
	jQuery("#dong").html(strHtml);
	jQuery("#dong").prop("disabled", false);
}

function searchZipCode(){
	var sido = jQuery("#city").val();
	var gu = jQuery("#gu").val();
	var dong= jQuery("#dong").val();
	
	if(isEmpty(sido) || isEmpty(gu) || isEmpty(dong)) {
		alert("시, 구, 동을 선택하고 검색 버튼을 누르세요.");
		return;
	}
	
	var param = {
			'sido' : sido
			,'gugun' : gu
			,'dong' : dong
	};
	
	jQuery.ajax({
		url : "/HW_realmain/ZipServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeZipTable(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
}

function makeZipTable(data){
	jQuery("#divZipResult").show();
	jQuery("#tbZipResult tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
					//<tr onclick='alert("300-801","대전","중구","문화1동","1번지");'>
		//strHtml += "<tr onclick='fntest(\""+ data[i].zipcode+"\",\""+ data[i].sido+"\"" +
		//",\""+data[i].gugun +"\",\""+data[i].dong +"\",\""+changeEmptyVal(data[i].bunji) +"\");'>"
		//strHtml += "<tr onclick='fntest(\""+ data[i].zipcode+"\");'>"
		strHtml += "<tr onclick='fntest("+ data[i]+");'>"
				+ "<td>" + data[i].zipcode + "</td>"
				+ "<td>" + data[i].sido + " "
				+ data[i].gugun + " "
				+ data[i].dong + " " 
				+ changeEmptyVal(data[i].bunji) + "</td>"
				+ "</tr>";
	}
	
	jQuery("#tbZipResult tbody").html(strHtml);
}


function isEmpty(val) {
	if(val == undefined) return true;
	if(val == null) return true;
	if(val == "null") return true;
	val = jQuery.trim(val);
	if(val.length == 0) return true;
	return false;
}


function changeEmptyVal(val) {
	if(isEmpty(val)) return "";
	else return val;
}


function fntest(obj){
	
	console.log(obj);
	
}

/*// [중복검사] 버튼에 클릭 이벤트
function chkId1(){
	var memId = jQuery("#memId").val();
	
	// 빈 값 확인     
	if(isEmpty(memId)) {
		alert("ID 값이 입력되지 않았습니다.");
		jQuery("#memId").focus();
		jQuery("#spMemId").show();
		return;
	}
	
	// 유효성 검사 - 영어소문자와 숫자로 구성. 3글자 이상 10글자 이하 
	var regExp = /^[a-z0-9]{3,10}jQuery/;
	if(!regExp.test(memId)) {
		alert("ID 값이 유효하지 않습니다.");
		jQuery("#memId").focus();
		jQuery("#spMemId").show();
		return;
	}
	
	
	// DB에서 중복검사 수행
	jQuery.ajax({
		url : "/HW_BHK/MemberServlet"
		,type : "post"
		,data : {"memId" : memId, "flag" : "CHKID"}
		,dataType : "json"
		,success : function(data){
//			console.log(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("ID 중복 검사 중 오류가 발생했습니다.");
		}
	});
}

*/

function openZip() {
	//셀렉트 박스를 조회해서 초기화
	initCitySelect();
	
	//테이블 초기화
	jQuery("#tbZipResult tbody").empty();
	jQuery("#divZipResult").hide();
	
	
	//주소창(모달창 열기)열기-부트스트랩의 모달 메서드를 호출한것
	jQuery("#zipModal").modal();
}



/*
//회원정보 저장하기
function save(){
	//회원정보 유효성 체크
	var result = validate();
	
	if(!result){
		
		return;//false일때 리턴
	}
	
	//사용자 컨펌
	if(!confirm("저장하시겠습니까?")){
		return; //false일때 리턴
	}
	
	//DB에 저장하는 ajax 호출
	
	jQuery("#formFlag").val("C");
	
	jQuery.ajax({
		url : "/HW_BHK/MemberServlet"
			,type : "post"
			,data : jQuery("#fm").serialize() //폼형태로 값을 가져오는 메서드,파라미터에 일일이 값을 저장하지 않아도 된다
			,dataType : "json"
			,success : function(data){
				console.log(data);
				alert("저장되었습니다.");
				//페이지 이동 
				//changePage();
			}
			,error : function(xhr){
				console.log(xhr);
				alert("실패하였습니다.\n관리자에게 문의하세요");
			}
	});
	
}
*/


function searchZipCode2(){
	var param = {
			'dong' : jQuery("#dong").val()
			,'flag' : 'REDONG'
	};
	
	jQuery.ajax({
		url : "/HW_realmain/ZipServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeZipTable2(data);
						
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});	
}


function makeZipTable2(data){
	jQuery("#divZipResult").show();
	jQuery("#tbZipResult tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		//<tr onclick='alert("300-801","대전","중구","문화1동","1번지");'>
		//strHtml += "<tr onclick='fntest(\""+ data[i].zipcode+"\",\""+ data[i].sido+"\"" +
		//",\""+data[i].gugun +"\",\""+data[i].dong +"\",\""+changeEmptyVal(data[i].bunji) +"\");'>"
		//strHtml += "<tr onclick='fntest(\""+ data[i].zipcode+"\");'>"
		strHtml += "<tr onclick='fntest("+ data[i]+");'>"
		+ "<td>" + data[i].zipcode + "</td>"
		+ "<td>" + data[i].sido + " "
		+ data[i].gugun + " "
		+ data[i].dong + " " 
		+ changeEmptyVal(data[i].bunji) + "</td>"
		+ "</tr>";
	}
	
	
	jQuery("#tbZipResult tbody").html(strHtml);
}


function emailCheck() {
	var email1 = jQuery("#userEmail1").val();
	alert(email1+"에 이메일을 보냅니다.확인을 누르시면 진행합니다.");
	alert("잠시만 기다려주세요");
	var param = {
			'email' : email1
			,'flag' : 'REDONG'
	};
	
	jQuery.ajax({
		url : "/HW_realmain/user"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			if(data.resultCnt == 1){
				alert("이메일 인증을 보냈습니다 확인해주세요");
				code=data.code;
			}
		}
		,error : function(xhr){
			console.log(xhr);
			alert("이메일인증을 실패하였습니다.다시 이메일을 입력해주세요");
		}
	});
	
}


function emailCheck2() {
	
	var email = jQuery("#EmailC").val();
	alert("회원께서 입력하신 인증번호는 "+email);
	
	
	if(email != code){
		alert("이메일 인증번호가 같지 않습니다, 다시 확인해주세요");
		
	}else {
		alert("인증되었습니다!");
		che=1;
		
	}
}




function save(){
	
	if(!validate())
		return;
	
	if(!confirm("저장하시겠습니까?")) return;
	
	jQuery("#formFlag").val("C");
	
	
	jQuery.ajax({
		url : "/HW_realmain/MemberServlet"
			,type : "post"
			,data :jQuery("#fm").serialize() //폼형태로 값을 가져오는 메서드,파라미터에 일일이 값을 저장하지 않아도 된다
			,dataType : "json"
			,success : function(data){
				console.log(data);
				alert("저장되었습니다.");
				//페이지 이동 
				changePage();
			}
			,error : function(xhr){
				console.log(xhr);
				alert("실패하였습니다.\n관리자에게 문의하세요");
			}
	});
	
}

function changePage() {
	window.location.href = "login.do";
}

function chkRegExp(val, type){
	if(isEmpty(val)) return false;
	var tmp = val;
	var regExp = "";
	if(type == "MEMBERID") {
		//영어소문자와 숫자로 구성. 3글자 이상 10글자 이하 
		regExp = /^[a-z0-9]{3,10}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "MEMBERNAME") {
		//영어대문자, 한글. 2글자 이상 20글자 이하
		regExp = /^[A-Z가-힣]{2,20}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "MEMBERPASSWORD") {
		//영어소문자 또는 대문자를 1개 이상 포함. 숫자 1개이상 포함. 8~15자리 
		regExp = /(?=.*\d)(?=.*[a-zA-Z]).{8,15}/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "EMAIL") {
		regExp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "ZIPCODE") {
		regExp = /^\d{5,6}$/;
		if(regExp.test(tmp.replaceAll("-", ""))) {
			return true;
		} else {
			return false;
		}
	} else if(type == "DATE") {
		regExp = /^\d{8}$/;
		if(regExp.test(tmp.replaceAll("-", "").replaceAll("/", "").replaceAll(".", ""))) {
			return true;
		} else {
			return false;
		}
	} else if(type == "HP") {
		//영어소문자 또는 대문자를 1개 이상 포함. 숫자 1개이상 포함. 8~15자리 
		regExp = /^\d{3}\d{3,4}\d{4}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "TEL") {
		//영어소문자 또는 대문자를 1개 이상 포함. 숫자 1개이상 포함. 8~15자리 
		regExp = /^\d{2,3}\d{3,4}\d{4}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	}
}


function validate(){
	
	//ID검사
	var memId = jQuery("#userId").val();
	if(isEmpty(memId)) {
		alert("ID는 필수 입력 입니다.");
		jQuery("#userId").focus();
		return false;
	}
	
	if( !chkRegExp(memId, "MEMBERID") ) {
		alert("ID의 형식이 잘못됐습니다.다시입력해주세요");
		jQuery("#userId").focus();
		return false;
	} else {
		
	}
	
	/*// DB에서 중복검사 수행
	jQuery.ajax({
		url: "/MemberCheckServlet"
		,type: "post"
		,data: data
		,dataType: "json"
		,success: function(data) {
			console.log(data);
			if(data.resultCnt == 0) {
				jQuery("#checkedMemId").val(memId);
			} else {
				jQuery("#spMemId").text("중복된 ID가 존재합니다.");
			}
		}
		,error: function(xhr) {
			console.log(xhr);
			jQuery("#spMemId").text("서버오류");
		}
	});*/
	
	
	
	
	//비밀번호검사
	var memPass = jQuery("#userPass").val();
	if(isEmpty(memPass)) {
		alert("비밀번호는 필수 입력 입니다.");
		jQuery("#userPass").focus();
		return false;
	}
	
	if( !chkRegExp(memPass, "MEMBERPASSWORD") ) {
		alert("비밀번호 형식이 잘못됐습니다.다시입력해주세요");
		jQuery("#userPass").focus();
		return false;
	} else {
	}
	
	//비밀번호확인 검사
	var memPass1 = jQuery("#userPass2").val();
	if(isEmpty(memPass1)) {
		alert("비밀번호 확인은 필수 입력 입니다.");
		jQuery("#userPass2").focus();
		return false;
	}
	
	if( memPass != memPass1 ) {
		alert("비밀번호 재입력이 잘못됐습니다.다시입력해주세요");
		jQuery("#userPass2").focus();
		return false;
	} else {
	}
	
	
	//이름검사
	var memName = jQuery("#userName").val();
	if(isEmpty(memName)) {
		alert("이름은 필수 입력 입니다.");
		jQuery("#userName").focus();
		return false;
	}
	
	if( !chkRegExp(memName, "MEMBERNAME") ) {
		alert("이름 형식이 잘못됐습니다.다시입력해주세요");
		jQuery("#userName").focus();
		return false;
	} else {
	}
	
	
	if(che != 1){
		alert("이메일 인증을 진행 하셔야 합니다.");
		return false;
	}
	
	
	//핸드폰번호검사
	var userPh = jQuery("#userPh").val();
	if(isEmpty(userPh)) {
		alert("핸드폰번호는 필수 입력 입니다.");
		jQuery("#userPh").focus();
		return false;
	}
	if( !chkRegExp(userPh, "HP") ) {
		alert("핸드폰번호 형식이 바르지 않습니다.");
		jQuery("#userPh").focus();
		return false;
	}
	
	
	
	
	//memAdd2
	if(isEmpty(jQuery("#memAdd2").val())) {
		alert("상세 주소는 필수 입력 입니다.");
		jQuery("#memAdd2").focus();
		return false;
	}
	
	
	//키
	var userHeight = jQuery("#userHeight").val();
	if(isEmpty(userHeight)) {
		alert("회원 키는 필수 입력 입니다.");
		jQuery("#userHeight").focus();
		return false;
	}
	
	//몸무게
	var userWeight = jQuery("#userWeight").val();
	if(isEmpty(userWeight)) {
		alert("회원몸무게는 필수 입력 입니다.");
		jQuery("#userWeight").focus();
		return false;
	}
	
	//장애여부
	var userOb = jQuery("#userOb").val();
	if(isEmpty(userOb)) {
		alert("회원장애여부는 필수 입력 입니다.");
		jQuery("#userOb").focus();
		return false;
	}
	
	
	//병결여부
	var userSick = jQuery("#userSick").val();
	if(isEmpty(userSick)) {
		alert("회원병결여부는  필수 입력 입니다.");
		jQuery("#userSick").focus();
		return false;
	}
	
	
	
	if(!jQuery("#emailckeck").is(":checked")){
		alert("이메일 동의는 필수입니다.");
		return false;
	}
	
	
	//체크가 끝나면
	return true;
}



























