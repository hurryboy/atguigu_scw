<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/static/jquery/jquery-2.1.1.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/script/docs.min.js"></script>
<script src="/static/script/back-to-top.js"></script>

<script src="/plugins/jquery-validation-1.13.1/dist/jquery.validate.min.js"></script>
<script src="/plugins/jquery-validation-1.13.1/dist/localization/messages_zh.min.js"></script>
<script src="/plugins/layer-v3.0.3/layer/layer.js"></script>

<script>
    $(function () {
        $("a[href='/${pageUrl}']").css("color","red");
        $("a[href='/${pageUrl}']").parent().parent().show();

        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });

</script>
