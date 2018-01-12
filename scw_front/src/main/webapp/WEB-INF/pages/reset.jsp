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

    <form id="loginForm" action="/front/reset" class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 重置密码</h2>
        <span style="color:red">${msg }</span>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control"
                   placeholder="请输入新密码" autofocus name="npwd">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control"
                   placeholder="请确认新密码" style="margin-top:10px;" name="userpswd">
            <span class="errorspan" style="color: red"></span>
        </div>
        <button class="btn btn-lg btn-success btn-block loginBtn" >重置</button>
    </form>
</div>

<!-- 引用公共js -->
<%@include file="/WEB-INF/include/commons-js.jsp"%>
<script>

    $(function () {
        if(${msg!=null}){
            layer.msg(${msg});
        }
    })

</script>
</body>
</html>