<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="X-实验室 | XYZ'S L" /></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="赵星宇" name="author" />
<meta name="MobileOptimized" content="320">

<link href="${base}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${base}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${base}/resources/css/base.css" rel="stylesheet">
<script src="${base}/resources/js/jquery.1.11.3.min.js"></script> 
<link rel="shortcut icon" href="${base}/resources/images/z.ico" />

</head>
<body>
	<%@ include file="header.jsp" %>
	
			<!-- ===每个页面的body=== -->
			<decorator:body/>
	
	</div>
	<div class="rollto" style="display: block;"><a href="javascript:;"></a></div>
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
var obj = null;
var As = document.getElementById('topnav').getElementsByTagName('a');
obj = As[0];
for (i = 1; i < As.length; i++) {
	if (window.location.href.indexOf(As[i].href) >= 0)
		obj = As[i];
}
obj.id = 'topnav_current'
</script>
</html>