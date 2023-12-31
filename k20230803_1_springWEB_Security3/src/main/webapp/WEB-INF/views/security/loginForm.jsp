<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>

<h1>loginForm.jsp</h1>

<c:url var="loginUrl" value="j_spring_security_check" />
<form action="${loginUrl}" method="post">

	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>Log-Out</p>
	</c:if>

	<!-- 로그인 실패 메시지를 출력한다.  -->
	<c:if test="${param.ng != null}">
		<p>
			Login NG!

			<!-- exception이 발생되지 않았을 때 메시지를 출력한다. -->
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
			message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
		</p>
	</c:if>
	ID : <input type="text" name="j_username" /><br /> PW : <input
		type="password" name="j_password" /><br /> <input type="submit"
		value="LOGIN" />
</form>


</body>
</html>