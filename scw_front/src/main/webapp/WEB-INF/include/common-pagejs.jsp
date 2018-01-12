<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script>
    //第一页和最后一页 的设置
    if(${pageInfo.isFirstPage}){
        $("li[pid='startPage']").attr("class","disabled");
    }else {
        $("li[pid='startPage']").attr("class","");
    }


    if(${pageInfo.isLastPage}){
        $("li[pid='endPage']").attr("class","disabled");
    }else {
        $("li[pid='endPage']").attr("class","");
    }
</script>