$(function() {
	$("#shouru").hide();
	$("#zhichu").hide();
	$("#shenghuo").mouseover(function() {
		$("#shouru").show();
		$("#zhichu").show();
	});

	$("#shouru")
			.click(
					function() {
						$("#zhichus").remove();
						$("#erbu").remove();
						$("#sy")
								.html(
										"<form  class='form-horizontal' id='shourus'>"
												+ "<fieldset><legend>收入</legend>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='time'>入账时间：</label>  <div class='col-md-4'><input id='time' name='time' type='date' class='form-control input-md'> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='money'>入账金额：</label>  <div class='col-md-4'><input id='money' name='money' type='text' placeholder='请输入入账金额' class='form-control input-md'> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='status'>是否公开：</label><div class='col-md-4'> <label class='radio-inline' for='radios-0'><input type='radio' name='status' id='status' value='0' checked='checked'>他人可见 </label> <label class='radio-inline' for='status'><input type='radio' name='status' id='status' value='1'>他人不可见</label> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='describes'>备注：</label><div class='col-md-4'><textarea class='form-control' id='describes' name='describes'></textarea> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='submit'></label><div class='col-md-8'><button id='submit'  class='btn btn-success'>提交</button>&emsp;<button id='button2id' name='button2id' class='btn btn-danger'>取消</button></div></div>"
												+ "</fieldset></form>");
						$("#submit").click(function() {
							alert(123);
							$.ajax({
								url : '/ozen/bill/add',
								type : 'POST',
								dataType : 'json',
								data : {
									time : $("#time").val(),
									money : $("#money").val(),
									describes : $("#describes").val(),
									status : $("input[name='status']:checked").val(),
									type : 0
								},
								success : function() {
									alert(321);
								}
							});
						});

					});
	$("#zhichu")
			.click(
					function() {
						$("#shourus").remove();
						$("#erbu").remove();
						$("#sy")
								.html(
										"<form  class='form-horizontal' id='shourus'>"
												+ "<fieldset><legend>支出</legend>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='time'>出账时间：</label>  <div class='col-md-4'><input id='time' name='time' type='date' class='form-control input-md'> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='money'>出账金额：</label>  <div class='col-md-4'><input id='money' name='money' type='text' placeholder='请输入入账金额' class='form-control input-md'> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='status'>是否公开：</label><div class='col-md-4'> <label class='radio-inline' for='radios-0'><input type='radio' name='status' id='status' value='0' checked='checked'>他人可见 </label> <label class='radio-inline' for='status'><input type='radio' name='status' id='status' value='1'>他人不可见</label> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='describes'>备注：</label><div class='col-md-4'><textarea class='form-control' id='describes' name='describes'></textarea> </div></div>"
												+ "<div class='form-group'><label class='col-md-4 control-label' for='submit'></label><div class='col-md-8'><button id='submit'  class='btn btn-success'>提交</button>&emsp;<button id='button2id' name='button2id' class='btn btn-danger'>取消</button></div></div>"
												+ "</fieldset></form>");
						$("#submit").click(function() {
							alert(123);
							$.ajax({
								url : '/ozen/bill/add',
								type : 'POST',
								dataType : 'json',
								data : {
									time : $("#time").val(),
									money : $("#money").val(),
									describes : $("#describes").val(),
									status : $("input[name='status']:checked").val(),
									type : 1
								},
								success : function() {
									alert(321);
								}
							});
						});

					});

	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate()
	var sj = year + '-' + month + '-' + day;
	var sss = date.toLocaleDateString();

});