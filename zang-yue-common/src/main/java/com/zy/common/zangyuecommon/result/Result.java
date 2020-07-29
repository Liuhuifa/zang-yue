package com.zy.common.zangyuecommon.result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/18$ 14:47$
 */
@Data
@Builder
@ApiModel("统一返回实体")
public class Result<T> {
    @ApiModelProperty("响应状码")
    private int code;
    @ApiModelProperty("返回数据")
    private T t;
    @ApiModelProperty("响应描述")
    private String mes;

    public Result(int code, T t, String mes) {
        this.code = code;
        this.t = t;
        this.mes = mes;
    }

    /**
     * 请求成功
     *
     * @param status 状态
     * @param t      数据
     * @return 统一返回
     */
    public static <T> Result<T> success(Status status, T t) {
        return new Result<>(status.getCode(), t, status.getMes());
    }

    /**
     * 请求成功
     *
     * @param status 状态
     * @return 统一返回
     */
    public static <T> Result<T> success(T t) {
        return new Result<>(Status.SUCCESS.getCode(), t, Status.SUCCESS.getMes());
    }

    /**
     * 请求失败
     *
     * @param status 状态
     * @return 统一返回
     */
    public static <T> Result<T> failure(Status status) {
        return new Result<>(status.getCode(), null, status.getMes());
    }

    /**
     * 请求失败
     *
     * @param status 状态
     * @return 统一返回
     */
    public static <T> Result<T> failure(Status status, String mes) {
        return new Result<>(status.getCode(), null, mes);
    }
}
