<%@ include file="header.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-6">
						<h3 class="page-header"><i class="fa fa-files-o" aria-hidden="true"></i> Sala </h3 >
					</div>
					<div class="col-lg-6">
						<c:url var="url" value="/aluno/${keyhash}/form"/>
						<span class="link-right">
							<a href="<c:out value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${url}" />"><i class="fa fa-link" aria-hidden="true"></i> LINK CADASTRO </a>
						</span>
					</div>
				</div>
				
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
					<header class="panel-heading"> Alunos da Sala </header>

					<table id="myTable" class="table table-striped table-advance table-hover">
						<thead>
							<tr>
								<th>Codigo</th>
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
								<td>${participacao.aluno.id}</td>
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
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Alunos Sorteados</h4>
		      </div>
		      <div class="modal-body">
		       <table id="sorteado" class="table table-striped table-advance table-hover">
						
					</table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>

		      </div>
		    </div>
		  </div>
		</div>
		<div>
            <ul class="nav nav-tabs" role="tablist" id="myTabs">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Sorteio</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Grupo</a></li>
            </ul>

            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
	                <div class="col-lg-12">
	                	<div class="row">
		                	<div class="col-lg-7">
		                		<div class="form-group">
										<label for="quantidade" class="control-label col-lg-2">Quantidade</label>
										<div class="col-lg-3">
											<input id="quantidade" name="cqnt" class="form-control" type="number" required="required" value="1" />
										</div>
										<a id="button" class="btn btn-primary col-lg-2" href="#" role="button">Sortear</a>
								</div>
		                	</div>
	                	</div>
	                	
	                </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
					<div class="col-lg-12">
	                	<div class="row">
		                	<div class="col-lg-7">
		                		<div class="form-group ">
										<label for="gde" class="control-label col-sm-3">Quantidade de grupos</label>
										<div class="col-lg-2">
											<input id="gde" name="cqnt" class="form-control" type="number" required="required" value="1" />
										</div>
										<a id="gbutton" class="btn btn-primary col-lg-2" href="#" role="button">Criar</a>
								</div>
		                	</div>
	                	</div>
	                	
	                </div>
				</div>
            </div>
		</div>
	</section>
</section>

</section>
<script>    
	$('#button').click( function () {
		var alunos = Array();
		var quantidade = $('#quantidade').val();
		$('#myTable').DataTable().rows('.selected').data().each(function( value ) {
			alunos.push(value[0]);
			  
		}); 
		if(quantidade <= alunos.length && alunos.length > 0 && quantidade > 0){
			$.post('<c:url value="/sala/${keyhash}/selecao" />', {'myArray[]': alunos, 'qnt':quantidade}, function (data) {
				var result = "";
				result += "<thead><tr>";
				result += "<th>Codigo</th>";
				result += "<th><i class=\"fa fa-user\" aria-hidden=\"true\"></i> Nome</th>";
				result += "<th><i class=\"fa fa-trophy\" aria-hidden=\"true\"></i> Pontos</th>";
				result += "</tr></thead><tbody>";
				$.each(data, function(index, value ) {
					console.log(value);
					result += "<tr><td>"+value.id+"</td><td>"+value.nome+"</td><td>"+value.pontuacao+"</td></tr>";
				}); 
				result += "</tbody>";
				$('#sorteado').html(result);
				$('#myModal').modal(); 
				
			}); 
			
			console.log(quantidade);
		}
	});
	
	$('#gbutton').click( function () {
		var alunos = Array();
		var quantidade = $('#gde').val();
		$('#myTable').DataTable().rows('.selected').data().each(function( value ) {
			alunos.push(value[0]);
		}); 
		
		if(quantidade <= alunos.length && quantidade > 0 || alunos.length == 0){
			if(alunos.length == 0){
				alunos.push("");
			}
			$.post('<c:url value="/sala/${keyhash}/grupo" />', {'myArray[]': alunos, 'qnt':quantidade}, function (data) {
				var result = "";
				result += "<thead><tr>";
				result += "<th>Grupo</th>";
				result += "<th><i class=\"fa fa-user\" aria-hidden=\"true\"></i> Nome</th>";
				result += "</tr></thead><tbody>";
				$.each(data, function(index, value ) {
					console.log(value);
					result += "<tr><td>"+value.grupo+"</td><td>"+value.nome+"</td></tr>";
				}); 
				result += "</tbody>";
				$('#sorteado').html(result);
				$('#myModal').modal(); 
				
			}); 
			
			console.log(quantidade);
		}
	});
	
</script>
<%@ include file="footer.jsp"%>