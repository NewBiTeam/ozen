<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="${base}/resources/css/index.css" rel="stylesheet">

<article>
	<div class="banner">
		<section class="box">
			<ul class="texts">
				<p>打了死结的青春，捆死一颗苍白绝望的灵魂。</p>
				<p>为自己掘一个坟墓来葬心，红尘一梦，不再追寻。</p>
				<p>加了锁的青春，不会再因谁而推开心门。</p>
			</ul>
			<div class="avatar">
				<a href="#"><span>SERLIN</span></a>
			</div>
		</section>
	</div>
	<h2 class="title_tj">
		<p>
			文章<span>推荐</span>
		</p>
	</h2>


	<div class="bloglist left">

		<!-- <div class="data row-fluid">
			<div class="span1">
				<a class="name" href="/user/1550463811307520.htm">
				<img content_id="1550463811307520_18" alt="最代码官方的gravatar头像"class="profile img-rounded"
					src="http://static.zuidaima.com//uploads/1/201703/20170312181519534.png"></a>
			</div>
			<div class="span11">
				<div class="hovercard_1550463811307520_18 hovercard">
					<div class="hovercontent">
						<div class="right_bar">
							<div class="user">
								<div class="row-fluid margin_top10">
									<div class="span6">
										<img width="90px" height="90px" alt="最代码官方的gravatar头像" src="http://static.zuidaima.com//uploads/1/201703/20170312181519534.png">
									</div>
									<div class="span6">
										<p>ID：1</p>
										<p>牛币：13287</p>
										<p>
											<a href="/faq.htm#rank_rule" target="_blank" rel="nofollow"><img
												src="http://static.zuidaima.com/resource/img/s_cap_2.gif"
												alt="最代码贡献等级说明" title="贡献值23551,距离下次升级还差26450贡献值"></a>
										</p>
									</div>
								</div>
								<div class="margin_top10">简介：我是一个java老牛,www.zuidaima.com</div>
								<div class="margin_top10">最近登录：2017-08-25 11:07:47</div>
								<div class="row-fluid margin_top10 show-grid">
									<a content_id="1550463811307520" href="javascript:void(0)"
										class="offset1 span4 follow" id="follow_1550463811307520">关注</a><a
										content_id="1550463811307520"
										href="/user/message.htm?uuid=1550463811307520"
										class="offset2 span4 message" id="message">私信</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="data_title">
					<span>
					<a class="name" href="/user/1550463811307520.htm">最代码官方</a>&nbsp;<span
						title="4级精英" class="badge level4">LV4</span></span><span
						class="time pull-right">7月31日
						</span>
				</div>
				<div class="margin_top5">
					<span title="最代码官方认证分享代码" class="validated">证</span><a
						target="_blank" href="/share/3484038112594944.htm" class="title">android
						PopupWindow封装类实现点击View的上方显示和下方显示弹窗</a>
				</div>
				<div class="content margin_top5"
					id="project_content_3484038112594944">
					项目截图gif动图...
					<div class="clear">
						<a
							href="http://static.zuidaima.com/images/1/201707/20170731144556609.png"
							target="_blank"><img
							alt="android PopupWindow封装类实现点击View的上方显示和下方显示弹窗"
							data-rawwidth="1331" data-rawheight="662"
							src="http://static.zuidaima.com/images/1/201707/20170731144556609_120x59.png"
							class="lazy img-rounded"
							data-original="http://static.zuidaima.com/images/1/201707/20170731144556609_120x59.png"></a>&nbsp;&nbsp;
					</div>
				</div>
				<div class="clear margin_top5 data_ops">
					<span class="code">浏览19</span><span class="code">下载0</span><span
						class="code">评论0</span><span class="niubi">牛币3</span><span><a
						class="post_tag" href="/share/kandroid-p1-s1.htm">android</a><a
						class="post_tag" href="/share/kandroid弹窗PopupWindow封装类-p1-s1.htm">android弹窗PopupWindow封装类</a></span><span
						class="pull-right"><a class="post_topic"
						href="/share_topic/k手机客户端开发-p1-s1.htm">手机客户端开发</a></span>
				</div>
			</div>
		</div> -->


		<c:forEach items="${recomBlogList}" var="radBlog">
			<h3>${radBlog.title}</h3>
			<figure>
				<img src="images/001.png">
			</figure>
			<ul>
				<p>${radBlog.content}</p>
				<a title="/" href="/" target="_blank" class="readmore">阅读全文>></a>
			</ul>
			<p class="dateview">
				<span>${radBlog.createTime}</span><span>作者：${radBlog.nickName}</span>
				<span>标签：[XX]</span>
			</p>
		</c:forEach>

		<div class="page">
			<font size="2">共${page.totalPageCount}页</font>
			<c:choose>
				<c:when test="${page.pageNow - 1 > 0}">
					<a href="${base}/index?pageNow=1" title="首页"><<</a>
					<a href="${base}/index?pageNow=${page.pageNow - 1}" title="上一页"><</a>
				</c:when>
				<c:when test="${page.pageNow - 1 <= 0}"></c:when>
			</c:choose>
			<b>${page.pageNow}</b>
			<c:choose>
				<c:when test="${page.pageNow + 1 <= page.totalPageCount}">
					<a href="${base}/index?pageNow=${page.pageNow + 1}" title="下一页">></a>
					<a href="${base}/index?pageNow=${page.totalPageCount}" title="尾页">>></a>
				</c:when>
				<c:when test="${page.pageNow + 1 > page.totalPageCount}"></c:when>
			</c:choose>
		</div>

	</div>

	<aside class="right">
		<div class="weather">
			<iframe width="250" scrolling="no" height="60" frameborder="0"
				allowtransparency="true"
				src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe>
		</div>
		<div class="news">
			<h3>
				<p>
					最新<span>文章</span>
				</p>
			</h3>
			<ul class="rank">
				<li><a href="/" title="Column 三栏布局 个人网站模板" target="_blank">Column
						三栏布局 个人网站模板</a></li>
				<li><a href="/" title="with love for you 个人网站模板"
					target="_blank">with love for you 个人网站模板</a></li>
				<li><a href="/" title="免费收录网站搜索引擎登录口大全" target="_blank">免费收录网站搜索引擎登录口大全</a></li>
				<li><a href="/" title="做网站到底需要什么?" target="_blank">做网站到底需要什么?</a></li>
				<li><a href="/" title="企业做网站具体流程步骤" target="_blank">企业做网站具体流程步骤</a></li>
				<li><a href="/" title="建站流程篇——教你如何快速学会做网站" target="_blank">建站流程篇——教你如何快速学会做网站</a></li>
				<li><a href="/" title="box-shadow 阴影右下脚折边效果" target="_blank">box-shadow阴影右下脚折边效果</a></li>
				<li><a href="/" title="打雷时室内、户外应该需要注意什么" target="_blank">打雷时室内、户外应该需要注意什么</a></li>
			</ul>
			<h3 class="ph">
				<p>
					点击<span>排行</span>
				</p>
			</h3>
			<ul class="paih">
				<li><a href="/" title="Column 三栏布局 个人网站模板" target="_blank">Column
						三栏布局 个人网站模板</a></li>
				<li><a href="/" title="withlove for you 个人网站模板" target="_blank">with
						love for you 个人网站模板</a></li>
				<li><a href="/" title="免费收录网站搜索引擎登录口大全" target="_blank">免费收录网站搜索引擎登录口大全</a></li>
				<li><a href="/" title="做网站到底需要什么?" target="_blank">做网站到底需要什么?</a></li>
				<li><a href="/" title="企业做网站具体流程步骤" target="_blank">企业做网站具体流程步骤</a></li>
			</ul>
			<h3 class="links">
				<p>
					友情<span>链接</span>
				</p>
			</h3>
			<ul class="website">
				<li><a href="/">个人博客</a></li>
				<li><a href="/">谢泽文个人博客</a></li>
				<li><a href="/">3DST技术网</a></li>
				<li><a href="/">思衡网络</a></li>
			</ul>
		</div>
		<!-- Baidu Button BEGIN -->
		<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare">
			<a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a
				class="bds_renren"></a><span class="bds_more"></span><a
				class="shareCount"></a>
		</div>
		<script type="text/javascript" id="bdshare_js"
			data="type=tools&amp;uid=6574585"></script>
		<script type="text/javascript" id="bdshell_js"></script>
		<script type="text/javascript">
			document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion="
					+ Math.ceil(new Date() / 3600000)
		</script>
		<!-- Baidu Button END -->
		<a href="/" class="weixin"> </a>
	</aside>
</article>
