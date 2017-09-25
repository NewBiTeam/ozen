$(function(){
	$("#shouru").hide();
	$("#zhichu").hide(); 
	$("#shenghuo").mouseover(function(){
		$("#shouru").show();
		$("#zhichu").show(); 
	});
	
	$("#shouru").click(function(){
		$("#zhichus").remove();
		$("#erbu").remove();
		$("#sy").html("<form class='form-horizontal' action='/ozen/bill/add' method='POST' id='shourus'>" +
				"<fieldset><legend>收入</legend>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='time'>入账时间：</label>  <div class='col-md-4'><input id='time' name='time' type='date' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='money'>入账金额：</label>  <div class='col-md-4'><input id='money' name='money' type='text' placeholder='请输入入账金额' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='radios'>是否公开：</label><div class='col-md-4'> <label class='radio-inline' for='radios-0'><input type='radio' name='radios' id='radios-0' value='1' checked='checked'>他人可见 </label> <label class='radio-inline' for='radios-1'><input type='radio' name='radios' id='radios-1' value='2'>他人不可见</label> </div></div>"+
				"<div class='form-group'><label class='col-md-4 control-label' for='describes'>备注：</label><div class='col-md-4'><textarea class='form-control' id='describes' name='describes'></textarea> </div></div>"+
				"<div class='form-group'><label class='col-md-4 control-label' for='button1id'></label><div class='col-md-8'><button id='button1id'  class='btn btn-success'>提交</button>&emsp;<button id='button2id' name='button2id' class='btn btn-danger'>取消</button></div></div>"+
				"</fieldset></form>")
		
	});
	$("#zhichu").click(function(){
		$("#shourus").remove();
		$("#erbu").remove();
		$("#sy").html("<form class='form-horizontal' id='zhichus'>" +
				"<fieldset><legend>支出</legend>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textinput'>出账时间：</label>  <div class='col-md-4'><input id='time' name='textinput' type='date' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='textinput'>出账金额：</label>  <div class='col-md-4'><input id='money' name='textinput' type='text' placeholder='请输入入账金额' class='form-control input-md'> </div></div>" +
				"<div class='form-group'><label class='col-md-4 control-label' for='radios'>是否公开：</label><div class='col-md-4'> <label class='radio-inline' for='radios-0'><input type='radio' name='radios' id='radios-0' value='1' checked='checked'>他人可见 </label> <label class='radio-inline' for='radios-1'><input type='radio' name='radios' id='radios-1' value='2'>他人不可见</label> </div></div>"+
				"<div class='form-group'><label class='col-md-4 control-label' for='textarea'>备注：</label><div class='col-md-4'><textarea class='form-control' id='describes' name='textarea'></textarea> </div></div>"+
				"<div class='form-group'><label class='col-md-4 control-label' for='button1id'></label><div class='col-md-8'><button id='button1id' name='button1id' class='btn btn-success'>提交</button>&emsp;<button id='button2id' name='button2id' class='btn btn-danger'>取消</button></div></div>"+
				"</fieldset></form>")
		
	});
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate()
	var sj = year+'-'+month+'-'+day;
	var sss = date.toLocaleDateString();
	
});