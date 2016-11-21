<%@ include file="header.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<!--overview start-->
		<div class="row">
			<div class="col-lg-12 crumb">
				<h3 class="page-header">
					<i class="fa fa-laptop"></i> Home
				</h3>
				<ol class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="<c:url value="/home" />">Home</a></li>
					<li><i class="fa fa-laptop"></i>Salas</li>
				</ol>
			</div>

			<c:forEach var="sala" items="${salas}">
				<div class="blocks-3" >

					<a href="sala/${sala.key}/list" class="info-box blue-bg"> <i
						class="fa fa-users"></i>
						<div class="count">${sala.nome}</div>
						<div class="title">${sala.sizeParticipacoes} Alunos</div>
						<%-- Guga --%>
				
					</a>
						<div class="btn-group">
							<div class="input-group">
								
						      <span class="input-group-btn">
						      	<a class="btn btn-danger" href="<c:url value="/sala/${sala.key}/remover" />"><i class="fa fa-trash-o"></i> Remover</a>
						        <button class="btn btn-info tog" type="button">Link!</button>
						        
						      </span>
						      <c:url var="url" value="/aluno/${sala.key}/form"/>
						      <input style="display: none;" readonly="readonly" type="text" class="form-control inp" value="<c:out value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${url}" />">
						    </div>
					
						</div>
				
				</div>
			</c:forEach>



			<!-- <div class="blocks-3">
				<a href="sala/form" class="info-box blue-bg"> <i
					class="fa fa-plus"></i>
					<div class="count sala">Criar Sala</div>
				</a>
				/.info-box
			</div> -->
			<!--/.col-->

		</div>
		<!--/.row-->

	</section>
</section>

<%@ include file="footer.jsp"%>