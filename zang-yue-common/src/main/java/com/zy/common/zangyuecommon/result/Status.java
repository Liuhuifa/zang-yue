package com.zy.common.zangyuecommon.result;

/**
 * <p>
 * 请求状态
 * </p>
 *
 * @author lhf
 * @since 2020/7/18$ 14:51$
 */
public enum Status {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),
    /**
     * 请求失败
     */
    FAILED(500, "请求失败"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(2000, "登陆成功"),
    /**
     * 登录失败
     */
    LOGIN_FAILURE(5000, "登录失败")

    ;

    private final int code;
    private final String mes;

    Status(int code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public int getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }
}
