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
			console.log("��ȣ:"+data.membervo);
			console.log("��ȣ:"+data.resultCnt);
			if(data.resultCnt==1){
			alert("�α��� �Ϸ�");
			
			<% 
			String memId = request.getParameter("memId");
			 String redirectUrl = request.getContextPath()+"/HW/main/mainlogin.do";
			  
			 session.setAttribute("signedUser", memId); // �����Ǿ��� ���ǿ� ����
			  
			  response.sendRedirect(redirectUrl); 
	            %>
			
			}else {
				alert("�Է��� ������ Ʋ���ϴ�.�ٽ��Է����ּ���");
				
				<% 
				  redirectUrl = request.getContextPath()+"/HW/main/login.do";
				
				response.sendRedirect(redirectUrl); 
				%>
				
			}
		}
		,error : function(xhr){
			console.log(xhr);
			alert("�α����� �����Ͽ����ϴ�.�����ڿ��� ���� �ϼ���");
		}
		
	});
});

</script>

</head>
<body>

</body>
</html>