package com.example.tencentrecruit.CommonBox;

/**
 * Function:响应码枚举，参考HTTP状态码的语义
 *
 * @author liubing
 * Date: 2018/9/30 下午2:24
 * @since JDK 1.8
 */
public enum ResultCode {
    //成功
    SUCCESS(2000),
    //已获得许可
    YE_VERY(2001),
    //失败
    FAIL(4000),
    //未认证（签名错误）
    UNAUTHORIZED(4001),
    NOT_AUTH(4002),
    //接口不存在
    NOT_FOUND(4004),
    //token失效
    TOKEN_TIMEOUT(4444),
    //认证造假（上传的假token） 或者token上传错误
    NO_AUTH(4445),
    //未获得许可（没有权限）

    //服务器内部错误
    INTERNAL_SERVER_ERROR(5000),
    //没那么智能，分辨不出正相关还是负相关
    NOT_SMART_ENOUGH(6008);


    public int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
