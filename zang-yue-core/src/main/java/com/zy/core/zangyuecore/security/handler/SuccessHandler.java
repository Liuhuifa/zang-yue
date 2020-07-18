package com.zy.core.zangyuecore.security.handler;

import cn.hutool.json.JSONUtil;
import com.zy.common.zangyuecommon.result.Result;
import com.zy.common.zangyuecommon.result.Status;
import com.zy.core.zangyuecore.security.jwt.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletRequest.setCharacterEncoding("utf8");
        httpServletResponse.setCharacterEncoding("utf8");
        //TODO 登陆成功时候的返回
        //生成token
        String token = JwtUtil.generate((UserDetails) authentication.getDetails());
        PrintWriter writer = httpServletResponse.getWriter();
        String json = JSONUtil.toJsonStr(Result.success(Status.LOGIN_SUCCESS, token));
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
