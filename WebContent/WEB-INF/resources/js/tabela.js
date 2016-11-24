$(document).ready(function() {
		        var table = $('#myTable').DataTable({
		            "bLengthChange": true,
		            "bFilter": true,
		            "bSortable": false,
		            "bInfo": false,
		            "bAutoWidth": false,
		            "processing": true,
		            "order": [[ 3, "desc" ]],
		            "columnDefs": [
		                {
		                    "targets": [ 0 ],
		                    "visible": false,
		                },
		                {
		                    "targets": [ 4 ],
		                    "searchable" : false
		                }],
		        	"language": {
		        		"sEmptyTable": "Nenhum registro encontrado",
		        		"sSearch": "Pesquisar",
		        		"sLengthMenu":     "Mostrar _MENU_ alunos",
		        		"paginate": {
		        	        "first":      "Primeiro",
		        	        "last":       "Ultimo",
		        	        "next":       "Proximo",
		        	        "previous":   "Anterior"
		        	    },
		       	}});
		        
		        $('#myTable tbody').on( 'click', 'tr', function () {
		            $(this).toggleClass('selected');
		        });
		        
		        
});
