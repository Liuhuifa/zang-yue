package com.zy.common.zangyuecommon.exception.controller;

import com.zy.common.zangyuecommon.result.Result;
import com.zy.common.zangyuecommon.result.Status;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 异常统一处理
 * </p>
 *
 * @author lhf
 * @since 2020/7/29 9:19
 */
@RestControllerAdvice
@Api(tags = "异常统一处理")
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    /**
     * 登录异常
     *
     * @param e 登录异常
     * @return 返回
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result<Object> authentication(AuthenticationException e) {
        logger.error("登录异常{}", e.getMessage());
        return Result.failure(Status.LOGIN_FAILURE, e.getMessage());
    }

    /**
     * 参数异常拦截
     *
     * @param e 拦截到的异常
     * @return 统一返回
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Object> illegalArgumentException(IllegalArgumentException e) {
        logger.error("参数异常:{}", e.getMessage());
        return Result.failure(Status.FAILED, e.getMessage());
    }

    /**
     * 拦截所有异常
     *
     * @param e 拦截到的异常
     * @return 返回
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> exception(Exception e) {
        logger.error(e.getMessage());
        return Result.failure(Status.FAILED, e.getMessage());
    }
}
