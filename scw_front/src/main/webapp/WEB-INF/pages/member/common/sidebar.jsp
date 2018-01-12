<%--
  Created by IntelliJ IDEA.
  User: CCC
  Date: 2017/12/20
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-sm-3 col-md-3 column">
    <div class="row">
        <div class="col-md-12">
            <div class="thumbnail" style="    border-radius: 0px;">
                <img src="img/services-box1.jpg" class="img-thumbnail" alt="A generic square placeholder image with a white border around it, making it resemble a photograph taken with an old instant camera">
                <div class="caption" style="text-align:center;">
                    <h3>
                        ${login.username}
                    </h3>
                    <span class="label label-danger" style="cursor:pointer;" onclick="window.location.href='cert.html'">未实名认证</span>
                </div>
            </div>
        </div>
    </div>
    <div class="list-group">
        <div class="list-group-item" style="cursor:pointer;" id="member" onclick="window.location.href='member.html'">
            资产总览<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
        </div>
        <div class="list-group-item" id="minecrowdfunding" onclick="window.location.href='minecrowdfunding.html'">
            我的众筹<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
        </div>
    </div>
</div>
<script>
    $("#${url}").addClass("active");
</script>
</body>
</html>
