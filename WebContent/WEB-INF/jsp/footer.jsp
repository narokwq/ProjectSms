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
            "bAutoWidth": false });
        $('#myTable tbody').on( 'click', 'tr', function () {
            $(this).toggleClass('selected');
        } );

        $('#button').click( function () {
            alert( table.rows('.selected').data()[0][0] +' row(s) selected' );
        } );
    } );
</script>
</body>
</html>