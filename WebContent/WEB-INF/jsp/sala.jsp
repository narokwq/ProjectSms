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
					<header class="panel-heading"> 
						Alunos da Sala - <a href="<c:out value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${url}" />">LINK CADASTRO</a>
					</header>
					

					<table id="myTable" class="table table-striped table-advance table-hover">
						<thead>
							<tr>
								<th><i class="fa fa-user" aria-hidden="true"></i> Nome</th>
								<th><i class="fa fa-mobile" aria-hidden="true"></i> Telefone</th>
								<th><i class="fa fa-trophy" aria-hidden="true"></i> Pontos</th>
								<th><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Ação</th>
								<!-- <th><i class="icon_pin_alt"></i> Ação</th> -->

							</tr>
						</thead>
						<tbody>
							<c:forEach var="participacao" items="${sala.participacaos}">
							<tr>
								<td>${participacao.aluno.nome}</td>
								<td>${participacao.aluno.telefone}</td>
								<td>${participacao.pontuacao}</td>
 								<td>
									<div class="btn-group">
										<a class="btn btn-success" href="<c:url value="/participacao/${keyhash}/${participacao.id}/pontuar" />"><i class="fa fa-trash-o"></i> Pontuar</a>
										<a class="btn btn-danger" href="<c:url value="/aluno/${keyhash}/${participacao.aluno.id}/remover" />"><i class="fa fa-trash-o"></i> Remover</a>
									</div>
								</td> 
							</tr>
							</c:forEach>

						</tbody>
					</table>
				</section>
				
			</div>
		</div>
<div>

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist" id="myTabs">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
                    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
                    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home"><a id="button" class="btn btn-primary" href="#" role="button">select</a></div>
                    <div role="tabpanel" class="tab-pane" id="profile">Teste profile</div>
                    <div role="tabpanel" class="tab-pane" id="messages">Teste Messages</div>
                </div>

            </div>
	</section>
</section>



<%@ include file="footer.jsp"%>