<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <%@include file="/WEB-INF/include/common-css.jsp"%>
    <link rel="stylesheet" href="/static/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>


<div class="container">
    <h1>验证码找回密码</h1>
    <form id="resetPwdForm" action="/front/resetpage" class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 忘记密码</h2>
        <span style="color:red">${msg }</span>
        <div class="form-group has-success has-feedback">
            <input id="email_input" type="text" class="form-control"
                   placeholder="请输入注册时的邮箱" autofocus name="email">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <span class="btn btn-xs btn-primary" onclick="sendCode();">发送邮件(<span>30</span>)秒</span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control"
                   placeholder="填写邮件中的验证码" autofocus name="code">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dosubmit()" > 确认</a>
    </form>
</div>

<!-- 引用公共js -->
<%@include file="/WEB-INF/include/commons-js.jsp"%>
<script>


    function sendCode() {
        $.ajax({
            url:"http://localhost:8080/api/sys/send/email/code?emailaddr="+$("input[name='email']").val(),
            type:"get",
            success:function(data) {
                var msg = data.msgs;
                layer.alert(msg);
                // layer.msg(msg,{time:10000,icon:6});
                console.log(data);
            }
        });
    }


    function dosubmit() {
        $("#resetPwdForm").submit();
    }


</script>

</body>
</html>