/**
 * 
 */

function login() {
	
	
	var memId = jQuery("#memId").val();
	var memPass = jQuery("#memPass").val();
	alert(memId);
	alert(memPass);
	var param = {
			'memId' : memId
			,'memPass' : memPass
			,'flag' : 'LOGIN'
	};
	jQuery.ajax({
		url : "/HW_BHK/MemberServlet"
		,type : "post"
		,data : param
		,dataType: "json"
		,success : function(data){
			console.log("오호:"+data.membervo);
			console.log("오호:"+data.resultCnt);
			if(data.resultCnt==1){
			alert("로그인 완료");
			//페이지 교체
			
			changePage(data.membervo);
			console.log(data.membervo);
			}else {
				alert("입력한 정보가 틀립니다.다시입력해주세요");
			}
		}
		,error : function(xhr){
			console.log(xhr);
			alert("로그인이 실패하였습니다.관리자에게 문의 하세요");
		}
		
	});
	
}


function changePage(val) {
	
	window.location.href = "mainlogin.do?memName="+val;
}











