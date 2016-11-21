$().ready(function(){
	$(".form-login").validate({
		rules: {
			nome : "required",
			telefone : {
				minlength: 2
			}
		}
	})
})