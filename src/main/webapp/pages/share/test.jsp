<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description"
	content="最代码  www.zuidaima.com 提供最全面，最专业的代码分享站，近万名用户分享超过1万份高质量的代码" />
<meta name="keywords"
	content="代码,代码分享,代码例子,源码,java代码，javascript代码,最代码,程序" />
<link href="http://www.zuidaima.com/favicon.ico" rel="shortcut icon"
	type="image/x-icon" />
<link type="text/css" rel="stylesheet"
	href="http://static.zuidaima.com/resource/js/syntaxhighlighter2/shCore-min.css" />
<script
	src="http://static.zuidaima.com/resource/js/ckeditor/ckeditor.js"></script>
<script
	src="http://static.zuidaima.com/resource/js/jquery.1.10.2.min.js"></script>
<link
	href="http://static.zuidaima.com/resource/css/bootstrap.min.css?v=20140118"
	rel="stylesheet" />
<link
	href="http://static.zuidaima.com/resource/css/common.css?v=20170811"
	rel="stylesheet" />
<link href="http://static.zuidaima.com/resource/css/zuidaima.css"
	rel="stylesheet" />
<title>登录-最代码</title>
</head>
<body>
	<div class="header navbar">
		<div class="navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="row-fluid nav_wrap">
					<div class="pull-left nav_link">
						<ul>
							<li class="logo"><a href="http://www.zuidaima.com/"
								title="最代码网站"><img
									src="http://static.zuidaima.com/resource/img/logo.png"
									alt="最代码网站" /></a></li>
							<li id="nav_index" class="nav_url"><a href="/">首页</a></li>
							<li id="nav_share" class="nav_url"><a href="/share.htm">分享</a></li>
							<li id="nav_question" class="nav_url"><a
								href="/question.htm">问答</a></li>
							<li id="nav_blog" class="nav_url"><a href="/blog.htm">博客</a></li>
							<li id="nav_buy2" class="nav_url"><a target="_blank"
								href='/taobao.htm' style="color: #FFFF00" rel="nofollow"
								title="在淘宝购买牛币">购买</a></li>
							<li class="nav_search"><input type="text" id="search"
								placeholder="搜索您要的分享、问答" value="搜索您要的分享、问答" /><i
								class="icon-search"></i></li>
						</ul>
					</div>
					<div class="pull-right user">
						<ul>
							<li><a href="javascript:create()" rel="nofollow">注册</a></li>
							<li><a href="javascript:login()" rel="nofollow">登录</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="google_adsense_all_site" class="main container margin_top10"
		style="height: 90px">
		<!-- 全站广告位 -->
		<ins class="adsbygoogle" style="display: block"
			data-ad-client="ca-pub-2303958443489176" data-ad-slot="5873812444"
			data-ad-format="auto"></ins>
		<script>
			(adsbygoogle = window.adsbygoogle || []).push({});
		</script>
	</div>
	<div class="main container margin_top10">
		<div class="data_list user">
			<div class="data_list_title">欢迎登录最代码</div>
			<form method="post" id="user">
				<div class="margin_top10">
					<span class="error"></span>
				</div>
				<div class="margin_top10">
					邮&nbsp;&nbsp;&nbsp;箱:<input type="text" name="account" id="account"
						data_name="邮箱" placeholder="邮箱" />
				</div>
				<div class="margin_top10">
					密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"
						id="password" data_name="密码" placeholder="密码" value="" />
				</div>
				<div class="margin_top10">
					<input type="checkbox" id="rememberme" name="rememberme"
						checked="checked" /><label for="rememberme">记住我</label>
				</div>
				<div class="margin_top10 post" id="login">
					<a class="span2" href="javascript:void(0)">登录</a>
				</div>
				<a class="span2" href="/user/find.htm">忘记密码？</a>
			</form>
			<br clear="all" />
		</div>
	</div>
	<div id="floatPanel">
		<div class="ctrolPanel">
			<a class="arrow" href="#"><span>顶部</span></a><a rel="nofollow"
				class="contact" href="/user/message.htm?uuid=1550463811307520"
				target="_blank"><span>客服</span></a><a class="qrcode" href="#"><span>微信二维码</span></a><a
				class="arrow" href="#"><span>底部</span></a>
		</div>
		<div class="popPanel">
			<div class="popPanel-inner">
				<div class="qrcodePanel">
					<img src="http://static.zuidaima.com/resource/img/weixin.jpg"
						alt=">扫描二维码关注最代码为好友" /><span>扫描二维码关注最代码为好友</span>
				</div>
				<div class="arrowPanel">
					<div class="arrow01"></div>
					<div class="arrow02"></div>
				</div>
			</div>
		</div>
	</div>
	<div id="ajax-modal" class="modal fade" style="display: none;"></div>
	<script src="http://static.zuidaima.com/resource/js/bootstrap.min.js"></script>
	<script src="http://static.zuidaima.com/resource/js/ajaxupload.js"></script>
	<script src="http://static.zuidaima.com/resource/js/mustache.js"></script>
	<script
		src="http://static.zuidaima.com/resource/js/syntaxhighlighter2/shBrushs-min.js"></script>
	<script
		src="http://static.zuidaima.com/resource/js/jquery.lazyload.min.js?v=201706062242"></script>
	<script>
		var uri = window.location.pathname + window.location.search;
		var redirect_url = "";
		if (uri.indexOf("redirect_url") == -1) {
			redirect_url = "?redirect_url=" + encodeURIComponent(uri);
		} else {
			redirect_url = window.location.search;
		}
		function login() {
			window.location = '/user/login.htm' + redirect_url;
		}
		function create() {
			window.location = '/user/create.htm' + redirect_url;
		}
		function logout() {
			window.location = '/user/logout.htm' + redirect_url;
		}
		$(function() {
			$("img.lazy").lazyload();
			SyntaxHighlighter.all();
			Zuidaima.initizal();
			$('.gifs').gifplayer();
		});
	</script>
	<script
		src="http://static.zuidaima.com/resource/js/javaniu.js?v=201707311854"></script>
	<script
		src="http://static.zuidaima.com/resource/js/jquery.gifplayer.js"></script>
	<script async
		src="http://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
	<div class="footer margin_top10">
		<div class="container">
			<div>
				<a href="/help.htm" rel="nofollow">帮助</a><span>|</span><a
					href="/contact.htm" rel="nofollow">联系我</a><span>|</span><a
					href="/partner.htm">友情链接</a><span>|</span><a href="/sitemap.xml"
					target="_blank">网站地图</a><span>|</span><a href="/share/rss.htm"
					target="_blank">RSS订阅分享源代码</a><span>|</span><a
					href="/question/rss.htm" target="_blank">RSS订阅问答</a><span>|</span><a
					href="/share.htm">最新分享源代码</a><span>|</span><a href="/question.htm">最新问答</a><span>|</span>
				<!--			<a rel="nofollow" target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=727c073145e93bd3ca3f3cf26fb0da62b6c92376bf4dafbb03accc738c1d017e"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="最代码官方群1" title="最代码官方群1"></a>-->
				<a rel="nofollow" target="_blank"
					href="http://shang.qq.com/wpa/qunwpa?idkey=d3ef6d04eaad4a3ca96a76511b63e64914965b7d88fb05c3be81ce9d670b20e4"><img
					border="0" src="http://pub.idqqimg.com/wpa/images/group.png"
					alt="最代码官方群9" title="最代码官方群9"></a><span class="pull-right">北京最代码科技有限公司
					Copyright © 2012-2017 All Rights Reserved 京ICP备12032064号</span>
			</div>
		</div>
	</div>
	<script>var _hmt = _hmt || [];(function() {  var hm = document.createElement("script");  hm.src = "//hm.baidu.com/hm.js?500f123d596f6dae47e36a9a36fed240";  var s = document.getElementsByTagName("script")[0];   s.parentNode.insertBefore(hm, s);})();</script>
</body>
</html>