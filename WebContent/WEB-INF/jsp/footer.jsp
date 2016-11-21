</section>

<script src="<c:url value ="/resources/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value ="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value ="/resources/js/datatables.min.js" />"></script>
<script>
    $(document).ready(function() {
        var table = $('#myTable').DataTable({
            "bLengthChange": false,
            "bFilter": true,
            "bSortable": false,
            "bInfo": false,
            "bAutoWidth": false,
            "order": [[ 2, "desc" ]],
        	"language": {
        		"sEmptyTable": "Nenhum registro encontrado"
       		 }});
        $('#myTable tbody').on( 'click', 'tr', function () {
            $(this).toggleClass('selected');
        } );

        $('#button').click( function () {
            alert( table.rows('.selected').data()[0][0] +' row(s) selected' );
        } );
        
        
    } );
    // side-menu
    jQuery('#sidebar .sub-menu > a').click(function () {
        var last = jQuery('.sub-menu.open', jQuery('#sidebar'));
        jQuery('.sub', last).slideUp(200);
        var sub = jQuery(this).next();
        if (sub.is(":visible")) {
            sub.slideUp(200);
        } else {
            sub.slideDown(200);
        }
        var o = (jQuery(this).offset());
        diff = 200 - o.top;
        if(diff>0)
            jQuery("#sidebar").scrollTo("-="+Math.abs(diff),500);
        else
            jQuery("#sidebar").scrollTo("+="+Math.abs(diff),500);
    });

</script>

<script>
    $(function() {
        $('.tog').click(function() {
            $('p').toggle;
			$(this).parents(".input-group").children("input").toggle(50);
        });
    });
</script>
</body>
</html>