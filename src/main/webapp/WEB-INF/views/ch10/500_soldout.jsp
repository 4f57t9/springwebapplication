<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- include : 소스 복사 붙여넣기의 개념 --%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		예외 처리 내용(Ch10SoldOutException 처리)
	</div>
	<div class="card-body">		
		사유: ${message} 이유로 주문할 수 없습니다.
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>