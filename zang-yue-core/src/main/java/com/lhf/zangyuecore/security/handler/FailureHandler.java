package com.lhf.zangyuecore.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 登录成功时的返回
 * </p>
 *
 * @author lhf
 * @since 2020/7/15$ 17:31$
 */
public class FailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletRequest.setCharacterEncoding("utf8");
        httpServletResponse.setCharacterEncoding("utf8");
        //TODO 登录失败的时候的返回
    }
}
