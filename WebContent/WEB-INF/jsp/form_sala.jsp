<%@ include file="header.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<!--overview start-->
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">
					<i class="fa fa-files-o"></i> Form Validation
				</h3>
				<ol class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
					<li><i class="icon_document_alt"></i>Forms</li>
					<li><i class="fa fa-files-o"></i>Salas</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> Form validations </header>
					<div class="panel-body">
						<div class="form">
							<c:url var="url" value="/sala/salvar" />
							<form:form class="form-validate form-horizontal" action="${url}" method="post" modelAttribute="sala">
								<div class="form-group ">
									<label for="cname" class="control-label col-lg-2">Nome
										da Sala <span class="required">*</span>
									</label>
									<div class="col-lg-10">
										<form:input path="nome" class="form-control" type="text" required="required" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<button class="btn btn-primary" type="submit">Salvar</button>
										<a href="<c:url value ="/home"/>" class="btn btn-default" type="button">Voltar</a>
									</div>
								</div>
							</form:form>
						</div>

					</div>
				</section>
			</div>
		</div>

	</section>
</section>
<%@ include file="footer.jsp"%>