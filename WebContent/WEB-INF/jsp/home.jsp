<%@ include file="header.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<!--overview start-->
		<div class="row">
			<div class="col-lg-12 crumb">
				<h3 class="page-header">
					<i class="fa fa-laptop"></i> Dashboard
				</h3>
				<ol class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
					<li><i class="fa fa-laptop"></i>Salas</li>
				</ol>
			</div>

			<c:forEach var="sala" items="${salas}">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<a href="#" class="info-box blue-bg"> <i
						class="fa fa-users"></i>
						<div class="count">${sala.nome}</div>
						<div class="title">${sala.sizeParticipacoes} Alunos</div>
					</a>

				</div>
			</c:forEach>



			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<a href="sala/form" class="info-box blue-bg"> <i
					class="fa fa-plus"></i>
					<div class="count sala">Criar Sala</div>
				</a>
				<!--/.info-box-->
			</div>
			<!--/.col-->

		</div>
		<!--/.row-->

	</section>
</section>
<%@ include file="footer.jsp"%>