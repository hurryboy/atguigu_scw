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

      <form id="loginForm" action="/member/login" class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 会员登录</h2>
         <span style="color:red">${msg }</span>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" 
				placeholder="请输入登录账号" autofocus name="loginacct">
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
              <span class="errorspan" style="color: red"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control"
			 placeholder="请输入登录密码" style="margin-top:10px;" name="userpswd">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
              <span class="errorspan" style="color: red"></span>
		  </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
          <br>
		       <label>
		            <a href="/forget.html">忘记密码</a>
		          </label>
          <label style="float:right">
          <a href="/reg.html">我要注册</a>
          </label>
        </div>
          <button class="btn btn-lg btn-success btn-block loginBtn" >登录</button>
      </form>
    </div>
    
    <!-- 引用公共js -->
    <%@include file="/WEB-INF/include/commons-js.jsp"%>
    <script>

        $.validator.setDefaults({
            //showErrors:自定义错误显示规则
            showErrors:function(map,list){
                //设置正确的样式
                var successEle = this.successList;
                $.each(successEle,function () {
                    $(this).nextAll(".errorspan").empty();
                    $(this).parent().removeClass("has-success has-error").addClass("has-success");
                });

                //设置错误的样式
                $.each(list,function(){
                    var msg = this.message;
                    var ele = this.element;//获取错误的dom对象
                    $(ele).nextAll(".errorspan").text(msg);
                    $(ele).parent().removeClass("has-success").addClass("has-error");
                });
            }
        });


        //校验插件
        $(function () {
            $("#loginForm").validate({
                rules: {
                    loginacct: {
                        required: true,
                        minlength: 6,
                        maxlength: 12
                    },
                    userpswd: {
                        required: true,
                        minlength: 6,
                        maxlength: 12
                    }
                },
                message: {
                    loginacct: {
                        required: "登陆账号必须填写",
                        minlength: "账号长度不能小于6",
                        maxlength: "账号长度不能大于12"
                    },
                    userpswd: {
                        required: "登陆密码不能为空",
                        minlength: "登陆密码不能大于6",
                        maxlength: "登陆密码不能大于12"
                    }
                }
            });


            $(".loginBtn").click(function () {
                if($(".errorspan").text()==null){
                    $("#loginForm").submit();
                }
            });

            if(${msg!=null}){
                layer.msg(${msg});
            }

        });


    </script>
  </body>
</html>