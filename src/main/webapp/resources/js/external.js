$(function(){
	$("#shouru").hide();
	$("#zhichu").hide(); 
	$("#shenghuo").mouseover(function(){
		$("#shouru").show();
		$("#zhichu").show(); 
	});
	$("#shouru").click(function(){
		$("#sy").html("<form class='form-horizontal'>" +
				"<fieldset><legend>收入</legend>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textinput'>入账时间：</label>  <div class='col-md-4'><input id='time' name='textinput' type='date' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textinput'>入账金额：</label>  <div class='col-md-4'><input id='money' name='textinput' type='text' placeholder='请输入入账金额' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textinput'>Text Input</label>  <div class='col-md-4'><input id='textinput' name='textinput' type='text' placeholder='placeholder' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textarea'>备注</label><div class='col-md-4'><textarea class='form-control' id='textarea' name='textarea'>default text</textarea> </div></div>"+
				"</fieldset></form>")
		
	});
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate()
	var sj = year+'-'+month+'-'+day;
	var sss = date.toLocaleDateString();
	
});