<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${base}/resources/css/login.css" rel="stylesheet">
<div class="main container margin_top10">
	<div class="data_list user">
		<div class="data_list_title">欢迎加入最代码</div>
		<form method="post" id="user">
			<div class="alert margin_top10">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>请勿用gmail或hotmail等国外邮箱,否则被墙无法激活!</strong>
			</div>
			<div class="margin_top10">
				<span class="error"></span>
			</div>
			<div class="control-group">
				<label class="control-label" for="name">用户名:</label><input
					type="text" name="name" id="name" data_name="用户名" placeholder="用户名">
			</div>
			<div class="margin_top10">
				<label class="control-label" for="email">邮箱:</label><input
					type="text" name="email" id="email" data_name="邮箱" placeholder="邮箱">
			</div>
			<div class="margin_top10">
				<label class="control-label" for="password">密码:</label><input
					type="password" name="password" id="password" data_name="密码"
					placeholder="密码">
			</div>
			<div class="margin_top10">
				<label class="control-label" for="password_chk">密码确认:</label><input
					type="password" name="password_chk" id="password_chk"
					data_name="密码确认" placeholder="密码确认">
			</div>
			<div class="margin_top10">
				<img
					src="data:image/png;base64,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">
				<div>
					<input type="text" name="captcha" id="captcha_chk"
						placeholder="请输入上图验证码">
				</div>
			</div>
			<div class="margin_top10 post" id="create">
				<a class="span2" href="javascript:void(0)" id="send_mail">发送验证邮件</a>
			</div>
		</form>
		<br clear="all">
	</div>
</div>