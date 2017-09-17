<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="${base}/resources/css/login.css" rel="stylesheet">
<object style="border:0px;margin-top: 30px; type="text/x-scriptlet" data="../pages/dateTime.html" width="100%" height=500px></object>
 <div class="main-login">
	<div class="data_list user">
		<div class="data_list_title">欢迎登录Ozen</div>
			<div class="margin_top10">
				<span class="error">密码不能为空</span>
			</div>
			<div class="margin_top10">
				邮&nbsp;&nbsp;&nbsp;箱:<input type="text" name="account" id="account"
					data_name="邮箱" placeholder="邮箱">
			</div>
			<div class="margin_top10">
				密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"
					id="password" data_name="密码" placeholder="密码" value="">
			</div>
			<div class="margin_top10">
				<input type="checkbox" id="rememberme" name="rememberme"
					checked="checked"><label for="rememberme">记住我</label>
			</div>
				<button class="btn btn-default btn-xs" id="login">登录</button>
			<a class="forgetpa" href="/user/find.htm">忘记密码？</a>
		<br clear="all">
	</div>
</div>
<script type="text/javascript">
$("#login").click(function(){
			var username = $("#account").val();
			var password = $("#password").val();
			$.ajax({
				type : "POST",  
                url : "${base}/login",
                dataType : 'json',
                data : {
                	username : username,
                	password : password
                },
                success : function(msg) {
                	localStorage.clear();
                	location.href = "index.jsp";
                },
                error:function(){
                	alert("登录失败，账号或密码错误");
                }
                
			})
		});
</script>
