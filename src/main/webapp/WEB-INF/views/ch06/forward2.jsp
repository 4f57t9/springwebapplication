<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- header.jsp로 이동해서 실행하고, 그 결과를 삽입 --%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="card m-2">
	<div class="card-header">
		forward2
	</div>
	<div class="card-body">
		<p><%= request.getAttribute("userName") %></p>
		<p>${userName}</p>
	</div>
</div>

<%-- footer.jsp로 이동해서 실행하고, 그 결과를 삽입 --%>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />