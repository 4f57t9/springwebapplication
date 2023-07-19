<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=2.0">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/tomcat.png">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
	
	<div class="d-flex flex-column vh-100">
        <nav class="navbar navbar-dark bg-dark text-white font-weight-bold">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"> 
               <img src="${pageContext.request.contextPath}/resources/logo-spring.png" width="30" height="30" class="d-inline-block align-top">
               	전자정부프레임워크(Spring Framework)
            </a>
            <div>
               <div>
                  <c:if test="${loginId == null}">
                     <a href="${pageContext.request.contextPath}/exam07/SaveSessionController" class="btn btn-success btn-sm">로그인</a>
                  </c:if>
                  <c:if test="${loginId != null}">
                     <span class="mr-2">${loginId}</span>
                     <a href="${pageContext.request.contextPath}/exam07/RemoveSessionController" class="btn btn-success btn-sm">로그아웃</a>
                  </c:if>
               </div>
            </div>
         </nav>
   
         <div class="flex-grow-1 container-fluid">
            <div class="row h-100">
               <div class="col-md-4 p-3 bg-dark">
                  <div class="h-100 d-flex flex-column">
                     <div class="flex-grow-1" style="height: 0px; overflow-y: auto; overflow-x: hidden;">
                        <%@ include file="/WEB-INF/views/common/menu.jsp" %>
                     </div>
                  </div>
               </div>
   
               <div class="col-md-8 p-3">
                  <div class=" h-100 d-flex flex-column">
                     <div class="flex-grow-1 overflow-auto pr-3" style="height: 0px">