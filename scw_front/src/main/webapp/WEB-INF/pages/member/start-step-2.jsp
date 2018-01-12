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
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">1. 项目及发起人信息</div>
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
                                        <div class="progress-bar progress-bar-success" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">2. 回报设置</div>
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
                                            回报设置
                                        </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">
                                    <table class="table table-bordered" style="text-align:center;" id="returnTable">
                                        <thead>
                                        <tr style="background-color:#ddd;">
                                            <td>序号</td>
                                            <td>支付金额</td>
                                            <td>名额</td>
                                            <td>单笔限购</td>
                                            <td>回报内容</td>
                                            <td>回报时间</td>
                                            <td>运费</td>
                                            <td>操作</td>
                                        </tr>
                                        </thead>
                                        <tbody id="tbody">
                                        <tr>
                                            <td scope="row">1</td>
                                            <td>￥1.00</td>
                                            <td>无限制</td>
                                            <td>1</td>
                                            <td>1</td>
                                            <td>项目结束后的30天</td>
                                            <td>包邮</td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-xs"><i
                                                        class=" glyphicon glyphicon-pencil"></i></button>
                                                <button type="button" class="btn btn-danger btn-xs"><i
                                                        class=" glyphicon glyphicon-remove"></i></button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <button type="button" class="btn btn-primary btn-lg" id="myTab"><i
                                            class="glyphicon glyphicon-plus"></i> 添加回报
                                    </button>
                                    <div style="border:10px solid #f60;border-bottom-color: #eceeef;border-width: 10px;width:20px;margin-left:20px;
                                             border-left-color: rgba(221, 221, 221, 0);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                    "></div>
                                    <div class="panel panel-default"
                                         style="border-style: dashed;background-color:#eceeef">
                                        <div class="panel-body">

                                            <div class="col-md-12 column">
                                                <form class="form-horizontal" id="returnData" style="display: none"
                                                      enctype="multipart/form-data">
                                                    <div class="form-group">
                                                        <label for="inputEmail3"
                                                               class="col-sm-2 control-label">回报类型</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline">
                                                                <input type="radio" name="type"
                                                                       value="1"> 实物回报
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input type="radio" name="type"
                                                                       value="0"> 虚拟物品回报
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">支持金额（元）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="supportmoney"
                                                                   style="width:100px;">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报内容</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" rows="5" name="content"
                                                                      placeholder="简单描述回报内容，不超过200字"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">说明图片</label>
                                                        <div class="col-sm-10">
                                                            <button type="button" class="btn btn-primary btn-lg active"
                                                                    id="uploadImg">上传图片
                                                            </button>
                                                            <input type="file" style="display: none" name="file"
                                                                   class="imgFile">
                                                            <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：760*510px选择文件</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报数量（名）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="count"
                                                                   style="width:100px;display:inline">
                                                            <label class="control-label">“0”为不限回报数量</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputEmail3"
                                                               class="col-sm-2 control-label">单笔限购</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline">
                                                                <input type="radio" name="signalpurchase"
                                                                       value="0"> 不限购
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input type="radio" name="signalpurchase"
                                                                       value="1"> 限购
                                                            </label>
                                                            <input type="text" class="form-control" name="purchase"
                                                                   style="width:100px;display:inline">
                                                            <label class="radio-inline">默认数量为1，且不超过上方已设置的回报数量</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">运费(元)</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="freight"
                                                                   style="width:100px;display:inline" value="0">
                                                            <label class="control-label">“0”为包邮</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputEmail3"
                                                               class="col-sm-2 control-label">发票</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline">
                                                                <input type="radio" name="invoice"
                                                                       value="0"> 不可开发票
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input type="radio" name="invoice"
                                                                       value="1"> 可开发票（包括个人发票和自定义抬头发票）
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputEmail3"
                                                               class="col-sm-2 control-label">回报时间</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline">
                                                                项目结束后
                                                            </label>
                                                            <input type="text" class="form-control" name="rtndate"
                                                                   style="width:100px;display:inline">
                                                            <label class="radio-inline">天，向支持者发送回报</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputEmail3" class="col-sm-2 control-label"></label>
                                                        <div class="col-sm-10">
                                                            <button type="button" class="btn btn-primary"
                                                                    id="saveReturn">确定
                                                            </button>
                                                            <button type="button" class="btn btn-default"
                                                                    id="resetReturn">取消
                                                            </button>
                                                        </div>
                                                    </div>

                                                </form>
                                            </div>


                                        </div>
                                    </div>
                                </div>

                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <blockquote>
                                                <p>
                                                    <i class="glyphicon glyphicon-info-sign" style="color:#2a6496;"></i>
                                                    提示
                                                </p>
                                                <small>
                                                    3个以上的回报：多些选择能提高项目的支持率。几十、几百、上千元的支持：3个不同档次的回报，能让你的项目更快成功。回报最好是项目的衍生品：<br>与项目内容有关的回报更能吸引到大家的支持。
                                                </small>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align:center;">
                        <button type="button" class="btn  btn-default btn-lg"
                                onclick="window.location.href='start-step-1.html'">上一步
                        </button>
                        <button type="button" class="btn  btn-warning btn-lg"
                                onclick="window.location.href='start-step-3.html'">下一步
                        </button>
                        <a class="btn"> 预览 </a>
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


<%--修改回报 模态框--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改回报 </h4>
            </div>
            <div class="modal-body">
                <form>
                        <table>
                            <tr>
                                <td>支付金额：</td>
                                <td><input type="text" name="supportmoney"></td>
                            </tr>
                            <tr>
                                <td>名额：</td>
                                <td><input type="text" name="count"></td>
                            </tr>
                            <tr>
                                <td>回报内容：</td>
                                <td><input type="text" name="content"></td>
                            </tr>
                            <tr>
                                <td>回报时间:</td>
                                <td><input type="text" name="rtndate"></td>
                            </tr>
                            页面调得不爽，劳资不写了
                        </table>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%@include file="/WEB-INF/include/commons-js.jsp" %>
<script>
    /*
     *初始化当前项目的回报列表
     */
    initReturnTables();

    function initReturnTables() {
        $.get("http://localhost:8081/api/project/returns","pid="+sessionStorage.pid,function (data) {
            console.log(data);
            var body = $("#tbody");
            body.empty();
            $.each(data.content,function () {
                var tr = $("<tr></tr>");
                var id = "<td>"+this.id+"</td>"
                var supportMoney = "<td>"+this.supportmoney+"</td>";
                var m = "<td>"+this.count+"</td>";
                var purchase;
                if(this.signalpurchase==0){
                    purchase = "<td>不限购</td>";
                }else{
                    purchase = "<td>"+this.purchase+"</td>";
                }
                var content = "<td>"+this.content+"</td>";
                var rtndate = "<td>项目结束后"+this.rtndate+"</td>";

                var btn = "<td>" +
                    "<button type='button' id='editReturn' class='btn btn-primary btn-xs'>" +
                    "<i class='glyphicon glyphicon-pencil'></i></button>" +
                    "<button type='button' id='deleteReturn' rid='"+this.id+"' class='btn btn-danger btn-xs'>" +
                    "<i class='glyphicon glyphicon-remove'></i></button>" +
                    "</td>";
                var freight;
                if(this.freight==0){
                    freight = "<td>包邮</td>";
                }else{
                    freight  = "<td>"+this.freight+"</td>";
                }

                tr.append(id).append(supportMoney).append(m).append(purchase)
                    .append(content).append(rtndate).append(freight).append(btn);
                body.append(tr);
            })

        });
    }

    /*
   * 保存回报信息
   * */
    $("#saveReturn").click(function () {
        var formData = new FormData($("#returnData")[0]);
        formData.append("projectid", sessionStorage.pid);
        $.ajax({
            url: "/project/saveReturn",
            type: "post",
            data: formData,
            //禁用默认格式
            contentType: false,
            processData: false,
            success: function (data) {
                $("#returnData")[0].reset();
                initReturnTables();
                layer.msg(data.msg);
            }
        })

    });

    /*
    * 重置回报表单信息
    * */
    $("#resetReturn").click(function () {
        $("#returnData").reset();
    });

    /*
    * 图片上传
    * */
    //模拟文本框被点击事件
    $("#uploadImg").click(function () {
        $(this).nextAll("input").click();
    });

    //绑定图片文件文本框内容改变事件
    $(".imgFile").change(function () {
        console.log("改变文本框");
        var file = this.files[0];
        //没有上传到服务器，本地上传文件生成临时文件地址，很吊
        var imgUrl = (window.URL || window.webkitURL).createObjectURL(file);
        var img = "<img src='" + imgUrl + "'/>";
        $(this).nextAll("label").text("文件名：" + file.name);
        $(this).nextAll("img").remove();
        $(this).nextAll("label").after(img);
    });



    //为回报列表按钮绑定点击事件
    //删除回报
    $("#tbody").on("click","#deleteReturn",function () {
        console.log("delteRe");
        $.get("http://localhost:8081/api/project/deleteReturnById","rid="+$(this).attr("rid"),function (data) {
            layer.msg(data.msgs);
            initReturnTables();
        })

    })

    //修改回报
    $("#tbody").on("click","#editReturn",function () {
        console.log("edit");
        $('#myModal').modal({
            keyboard: false
        })
    })


    $('#myTab').click(function () {
        $("#returnData").toggle();
    })
</script>
</body>
</html>