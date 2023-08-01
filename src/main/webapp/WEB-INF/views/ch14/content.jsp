<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		AOP(관점 지향 프로그래밍)		
	</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">
				Advice 테스트	
			</div>
			<div class="card-body">
				<a href="before" class="btn btn-info btn-sm">@Before 테스트</a>
				<a href="after" class="btn btn-info btn-sm">@After 테스트</a>
				<a href="afterReturning" class="btn btn-info btn-sm">@AfterReturning 테스트</a>
				<a href="afterThrowing" class="btn btn-info btn-sm">@AfterThrowing 테스트</a>
				<a href="around" class="btn btn-info btn-sm">@Around 테스트</a>
			</div>
		</div>
		
		<div class="card">
			<div class="card-header">
				AOP 예제1
			</div>
			<div class="card-body">
				<p><a href="runtimeCheck" class="btn btn-info btn-sm">요청 처리 시간 측정</a></p>
				<div>실행시간: ${methodName} - ${runTime}ns</div>
			</div>
		</div>
		
		<div class="card">
			<div class="card-header">
				AOP 예제2
			</div>
			<div class="card-body">
				<p><a href="loginCheck" class="btn btn-info btn-sm">인증 여부 확인</a></p>
			</div>
		</div>		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>