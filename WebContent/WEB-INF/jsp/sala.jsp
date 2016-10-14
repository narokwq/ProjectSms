<%@ include file="header.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">
					
					<i class="fa fa-files-o"></i> Sala 
				</h3>
				<ol class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="<c:url value="/home" />">Home</a></li>
					<li><i class="icon_document_alt"></i>Tabela</li>
					<li>Sala</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<c:url var="url" value="/aluno/${keyhash}/form"/>
					<header class="panel-heading"> Alunos da Sala - <a href="<c:out value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${url}" />">LINK CADASTRO</a></header>
					

					<table class="table table-striped table-advance table-hover">
						<tbody>
							<tr>
								<th><i class="icon_profile"></i> Nome</th>
								<th><i class="icon_calendar"></i> Telefone</th>
								<th><i class="icon_mail_alt"></i> Pontos</th>
								<!-- <th><i class="icon_pin_alt"></i> Ação</th> -->

							</tr>
							<c:forEach var="participacao" items="${sala.participacaos}">
							<tr>
								<td>${participacao.aluno.nome}</td>
								<td>${participacao.aluno.telefone}</td>
								<td>${participacao.pontuacao}</td>
<%-- 								<td>
									<div class="btn-group">
										<a class="btn btn-danger" href="<c:url value="/aluno/${participacao.id}/remover" />"><i class="fa fa-trash-o"></i></a>
									</div>
								</td> --%>
							</tr>
							</c:forEach>

						</tbody>
					</table>
				</section>
			</div>
		</div>

	</section>
</section>

<%@ include file="footer.jsp"%>