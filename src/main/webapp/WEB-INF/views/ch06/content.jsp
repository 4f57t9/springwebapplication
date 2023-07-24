<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%-- include : 소스 복사 붙여넣기의 개념 --%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Forward와 Redirect
	</div>
	<div class="card-body">
		<div class="m-2">
			<a href="forward" class="btn btn-info btn-sm">Forward</a>		
		</div>
		<div class="m-2">
			<a href="redirect" class="btn btn-info btn-sm">Redirect</a>		
		</div>	
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>