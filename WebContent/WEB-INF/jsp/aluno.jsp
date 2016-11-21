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

	<c:url var="url" value="salvar" />
	<form:form class="form-horizontal form-login" action="${url}" method="post"
		modelAttribute="aluno" id="form-cadastro">
		<spring:bind path="nome">
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
					<h2>Cadastro de aluno</h2>
				</div>

				<div class="form-group" style="margin-top: 20px;">

					<div class="col-sm-offset-1 col-sm-10">
						<form:input path="nome" type="text" class="form-control"
							placeholder="Nome" required="required" autocomplete="off" />
					</div>
				</div>
				<div class="form-group" style="margin-top: 15px;">

					<div class="col-sm-offset-1 col-sm-10">
						<form:input path="telefone" class="form-control"
							placeholder="Celular" required="required" autocomplete="off" />
					</div>
				</div>
				<div class="form-group">

					<div class="col-sm-offset-1 col-sm-10">
						<button type="submit" class="btn btn-info green">Cadastrar</button>

						</div>

					</div>


				</div>
			</div>
			

	</form:form>

	


	<div>
		<c:if test="${mensagem != null}">
			<div class="alert alert-danger" role="alert"
				style="margin: auto; width: 50%;">${mensagem}</div>
		</c:if>
	</div>
	<script src="<c:url value ="/resources/js/jquery-3.1.1.min.js" />"></script>
	<script src="<c:url value ="/resources/js/jquery.validate.min.js" />"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		    $("#form-cadastro").validate({
		    rules :{
		    	nome : "required",
				telefone : {
					minlength: 10
				}
		    },
		    messages :{
		    	telefone : {
		    		minlength : 'Numero invalido'
		        }
		    }
		    });
		});
	</script>

</body>
</html>