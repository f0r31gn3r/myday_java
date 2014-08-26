<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.error {
	width: auto;
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
	<h1>Registration</h1>

	<form name="input" action="registration" method="post">
		<table>
			<tr>
				<c:if test="${not empty AccAlreadyExist}">
					<div class="error">${AccAlreadyExist}</div>
				</c:if>
				<c:if test="${not empty emptyL}">
					<div class="error">${emptyL}</div>
				</c:if>
				<c:if test="${not empty lengthL}">
					<div class="error">${lengthL}</div>
				</c:if>
				<c:if test="${not empty pswrdMatch}">
					<div class="error">${pswrdMatch}</div>
				</c:if>
				<c:if test="${not empty emptyP}">
					<div class="error">${emptyP}</div>
				</c:if>
				<c:if test="${not empty lengthP}">
					<div class="error">${lengthP}</div>
				</c:if>
				<c:if test="${not empty emptyFN}">
					<div class="error">${emptyFN}</div>
				</c:if>
				<c:if test="${not empty emptyLN}">
					<div class="error">${emptyLN}</div>
				</c:if>
				
				<td>User Name:</td>
				<td><input type="text" name="login" value=""></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>Password confirmation:</td>
				<td><input type="password" name="passwordCheck" value=""></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value=""></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value=""></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
		</table>
		<input type="submit" value="Register"> | <a href="/MyDay/">Go
			Home</a><br>
	</form>
