
<script src="<c:url value ="/resources/js/bootstrap.min.js" />"></script>

<script>
    $('#sidebar .sub-menu > a').click(function () {
        var last = jQuery('.sub-menu.open', jQuery('#sidebar'));
        $('.sub', last).slideUp(200);
        var sub = jQuery(this).next();
        if (sub.is(":visible")) {
            sub.slideUp(200);
        } else {
            sub.slideDown(200);
        }
    });


</script>

<script>
    $('.tog').click(function() {
        $('p').toggle;
		$(this).parents(".input-group").children("input").toggle(50);
    });
</script>
</body>
</html>