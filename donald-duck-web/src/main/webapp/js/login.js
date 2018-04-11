$(function() {
	$("#login").click(
			function() {
				$.ajax({
					type : "post",
					url : "/login.do",
					data : "userName=" + $("#username").val() + "&password="
							+ $("#userpwd").val(),
					success : function(result) {
						if (result == null) {
							alert("null");
						} else {
							if (result.code === "2") {
								window.location.replace("./loginError.do");
							} else {
								window.location.replace("./loginSuccess.do");
							}
						}
					},
					error : function() {
						alert("系统异常,请稍后重试!");
					}
				});
			});
});
