<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Tela Login</title>
<link rel="stylesheet" href="<c:url value ="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value ="/resources/css/index.css" />">
</head>
<body>

	<c:url var="url" value="/cliente/salvar" />
	<form:form class="form-horizontal form-login" action="${url}" method="post"
		modelAttribute="cliente">
		<spring:bind path="login.login">
			<c:if test="${status.error}">
				<div class="alert alert-danger col-sm-12"
					role="alert">

					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>
					<form:errors></form:errors>

				</div>
			</c:if>
		</spring:bind>
		<div id="login-box">

			<div id="login-box-interno">
				<div id="login-box-interno-label">
					<h2>Cadastro de Professor</h2>
				</div>

				<div class="form-group" style="margin-top: 20px;">

					<div class="col-sm-offset-1 col-sm-10">
						<form:input path="login.login" type="text" class="form-control"
							placeholder="Login" required="required" autocomplete="off" />
					</div>
				</div>
				<div class="form-group" style="margin-top: 15px;">

					<div class="col-sm-offset-1 col-sm-10">
						<form:password path="login.senha" class="form-control"
							placeholder="Senha" required="required" autocomplete="off" />
					</div>
				</div>
				<div class="form-group">

					<div class="col-sm-offset-1 col-sm-10">
						<button type="submit" class="btn btn-info blue">Cadastrar</button>

						<h5 style="color: #ffffff; text-align: center; margin-top:13px;"><a href="<c:url value="/home" />">Se logue!</a></h5>
						</div>

					</div>


				</div>
			</div>
			

	</form:form>

	


	<div>
		<c:if test="${message != null}">
			<div class="alert alert-danger" role="alert"
				style="margin: auto; width: 50%;">${message}</div>
		</c:if>
	</div>
	

</body>
</html>