<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@include file="/WEB-INF/include/common-css.jsp" %>

    <style>
        #footer {
            padding: 15px 0;
            background: #fff;
            border-top: 1px solid #ddd;
            text-align: center;
        }

        #topcontrol {
            color: #fff;
            z-index: 99;
            width: 30px;
            height: 30px;
            font-size: 20px;
            background: #222;
            position: relative;
            right: 14px !important;
            bottom: 11px !important;
            border-radius: 3px !important;
        }

        #topcontrol:after {
            /*top: -2px;*/
            left: 8.5px;
            content: "\f106";
            position: absolute;
            text-align: center;
            font-family: FontAwesome;
        }

        #topcontrol:hover {
            color: #fff;
            background: #18ba9b;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not(:first-child) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<%@ include file="common/process-top.jsp" %>

<div class="container theme-showcase" role="main">

    <%@ include file="common/process-navigation.jsp" %>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align:center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;    position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-success" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">1. 项目及发起人信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(92, 184, 92, 1);
                                             border-top-color: rgba(92, 184, 92, 0);
                                             border-bottom-color: rgba(92, 184, 92, 0);
                                             border-right-color: rgba(92, 184, 92, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">2. 回报设置</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">3. 确认信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                                        <b>
                                            项目及发起人信息
                                        </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">
                                    <div class="page-header" style="    border-bottom-style: dashed;">
                                        <h3>
                                            项目信息
                                        </h3>
                                    </div>
                                    <form class="form-horizontal" id="project" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">分类信息</label>
                                            <div class="col-sm-10" id="types">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">标签</label>
                                            <div class="col-sm-10">
                                                <ul style="list-style:none;padding-left:0;" id="tags">
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="name" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">一句话简介</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="remark" rows="5"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">筹资金额（元）</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="money" class="form-control"
                                                       style="width:100px;">
                                                <label class="control-label">筹资金额不能低于100元,不能高于1000000000元</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">筹资天数（天）</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="day" class="form-control" style="width:100px;">
                                                <label class="control-label">一般10-90天，建议30天</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目头图</label>
                                            <div class="col-sm-10">
                                                <button type="button" class="btn btn-primary btn-lg active upload-Btn">
                                                    上传图片
                                                </button>
                                                <input type="file" class="upload-file" name="headImg"
                                                       style="display: none">
                                                <label class="control-label">图片上无文字,支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：740*457px</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目详情</label>
                                            <div class="col-sm-10">
                                                <button type="button" class="btn btn-primary btn-lg active upload-Btn">
                                                    上传图片
                                                </button>
                                                <input type="file" class="upload-file" name="infoImg"
                                                       style="display: none">
                                                <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：宽740px</label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-md-12 column">
                                    <div class="page-header" style="    border-bottom-style: dashed;">
                                        <h3>
                                            发起人信息
                                        </h3>
                                    </div>
                                    <form class="form-horizontal" id="organizer">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">自我介绍</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="remark" class="form-control"
                                                       placeholder="一句话自我介绍，不超过40字">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">详细自我介绍</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="desc" rows="5"
                                                          placeholder="向支持者详细介绍你自己或你的团队及项目背景，让支持者在最短时间内了解你，不超过160字"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">联系电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="phone" class="form-control"
                                                       placeholder="此信息不会显示在项目页面">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">客服电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="servicephone" class="form-control"
                                                       placeholder="此信息显示在项目页面">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align:center;">
                        <button type="button" class="btn  btn-warning btn-lg" id="nextStep">下一步
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="margin-top:20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow"
                                                                                      href="http://www.layoutit.cn">服务条款</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow"
                                                                                        href="http://www.layoutit.cn">网站地图</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017layoutit.cn 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>
</div> <!-- /container -->
<%@include file="/WEB-INF/include/commons-js.jsp" %>
<script>

    /*
    * 发起项目第一步的项目保存操作
    **/
    $("#nextStep").click(function () {
        //项目信息
        //图片
        //直接传入dom对象，自动包装文件流和普通数据$("#project")[0]
        var fb = new FormData($("#project")[0]);

        //获取所有样式改变的tag
        var Ztags = "";
        $("span[style='background-color:#428bca']").each(function () {
            Ztags += $(this).attr("id") + ",";
        })
        fb.append("tags", Ztags);
        fb.append("id", sessionStorage.pid)


        //发起人信息
        var ordatatemp = $("#organizer").serialize();//ew FormData($("#organizer")[0]);/*$("#organizer").serialize();*/
        var ordata = ordatatemp+"&id=" + sessionStorage.pid;
        console.log("-------");
        console.log(ordata);

        $.ajax({
            url: "/project/savePro",
            type: "post",
            data: fb,
            //禁用默认格式
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data);
                if (data.code == 1) {
                    layer.msg(data.msg);
                    return;
                } else {
                    //layer.msg(data.msg);
                    //保存发起人信息
                    $.post("/project/saveOrga", ordata, function (data) {
                        if (data.code == 1) {
                            layer.msg(data.msg);
                        } else {
                            window.location.href = "/start-step-2.html";
                        }
                    })
                }
            }
        })

    });

    /*
    * 页面数据请求
    * */
    $.ajax({
        url: "http://localhost:8081/api/project/types",
        type: "post",
        success: function (data) {
            console.log(data);
            initTypes(data.content);
        }
    })

    $.ajax({
        url: "http://localhost:8081/api/project/tags",
        type: "post",
        success: function (data) {
            console.log(data);
            initTags(data.content);
        }
    })

    /*
    * 初始化页面分类信息
    * */
    function initTypes(data) {
        $.each(data, function () {
            var type = "<input type='radio' name='type' id='inlineRadio1' value='" + this.id + "'>" + this.name;
            $("#types").append("<label class='radio-inline'>" + type + "</label>");
        })
    }


    /*
    * 初始化页面标签信息
    * */

    /*
    * <ul style="list-style:none;padding-left:0;" id="tags">
                    <li style="margin:10px 0">[手机]
                        <span class="label-txt">手机</span> <span class="label-txt">快充</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span>
                    </li>
                </ul>
    * */
    function initTags(data) {
        $.each(data, function () {
            if (this.pid == 0) {
                //父标签
                var Ftag = "<li style='margin:10px 0' pid='" + this.id + "'>" + this.name + "</li>"
                $("#tags").append(Ftag);

            } else {
                //子标签
                <!--style='background-color: #428bca'-->
                var Ztag = "<span class='label-txt Ztags' id='" + this.id + "' style=''>" + this.name + "</span>";
                $("li[pid='" + this.pid + "']").append(Ztag);
            }
        })
    }

    //为每个子标签绑定点击事件
    $("#tags").on("click", ".Ztags", function (event) {
        console.log(event);
        //$(event.target).attr("style","background-color:#428bca");
        if ($(event.target).attr("style") == "") {
            $(event.target).attr("style", "background-color:#428bca");
        } else {
            $(event.target).attr("style", "");
        }

    })


    /*
    * 图片上传
    * */
    //模拟文本框被点击事件
    $(".upload-Btn").click(function () {
        $(this).nextAll("input").click();
    });

    //绑定图片文件文本框内容改变事件
    $(".upload-file").change(function () {
        console.log(this.files);
        var file = this.files[0];
        //没有上传到服务器，本地上传文件生成临时文件地址，很吊
        var imgUrl = (window.URL || window.webkitURL).createObjectURL(file);
        var img = "<img src='" + imgUrl + "'/>";
        $(this).nextAll("label").text("文件名：" + file.name);
        $(this).nextAll("img").remove();
        $(this).nextAll("label").after(img);
    });


    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>
</body>
</html>