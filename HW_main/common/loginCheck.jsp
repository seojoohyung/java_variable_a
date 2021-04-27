<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src='<%=request.getContextPath() %>/HW_main/js/jquery.js'></script>
<script type="text/javascript" src="https://yourwebsite.com/script.js"></script>
<script type="text/javascript" src="https://codepen.io/username/pen/aBcDef"></script>
<script type="text/javascript">
$(document).ready(function(){
	var memId = <%=request.getParameter("memId") %>
	var memPass = <%=request.getParameter("memPass") %>
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
			
			<% 
			String memId = request.getParameter("memId");
			 String redirectUrl = request.getContextPath()+"/HW/main/mainlogin.do";
			  
			 session.setAttribute("signedUser", memId); // 인증되었음 세션에 남김
			  
			  response.sendRedirect(redirectUrl); 
	            %>
			
			}else {
				alert("입력한 정보가 틀립니다.다시입력해주세요");
				
				<% 
				  redirectUrl = request.getContextPath()+"/HW/main/login.do";
				
				response.sendRedirect(redirectUrl); 
				%>
				
			}
		}
		,error : function(xhr){
			console.log(xhr);
			alert("로그인이 실패하였습니다.관리자에게 문의 하세요");
		}
		
	});
});

</script>

</head>
<body>

</body>
</html>