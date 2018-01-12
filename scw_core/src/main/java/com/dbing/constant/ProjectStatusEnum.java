package com.dbing.constant;

/**
 * author:dbing
 */
public enum ProjectStatusEnum {

    STARTING("0","发起项目"),VERIFY("1","审核中"),PROCESSING("2","众筹中"),FINISH("3","众筹成功"),FAIL("4","众筹失败");

    String code;
    String msg;

    ProjectStatusEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
