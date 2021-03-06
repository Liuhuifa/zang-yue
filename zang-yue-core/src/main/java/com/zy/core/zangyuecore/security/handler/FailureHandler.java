package com.zy.core.zangyuecore.security.handler;

import cn.hutool.json.JSONUtil;
import com.zy.common.zangyuecommon.result.Result;
import com.zy.common.zangyuecommon.result.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 登录成功时的返回
 * </p>
 *
 * @author lhf
 * @since 2020/7/15$ 17:31$
 */
@Slf4j
public class FailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletRequest.setCharacterEncoding("utf8");
        httpServletResponse.setCharacterEncoding("utf8");
        PrintWriter writer = httpServletResponse.getWriter();
        log.error(e.getMessage());
        String json = JSONUtil.toJsonStr(Result.failure(Status.LOGIN_FAILURE));
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
