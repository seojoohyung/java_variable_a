<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
Integer resultCnt = (Integer)request.getAttribute("resultCnt");

String membervo = (String)request.getAttribute("memberVo");
%>

{
"resultCnt" : "<%=resultCnt%>"
,"membervo" : "<%=membervo%>"
}

