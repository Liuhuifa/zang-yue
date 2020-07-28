package com.zy.core.zangyuecore.security.jwt;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/28 17:48
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Resource(name = "userDetailsService")
    private UserDetailsService detailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String authorization = request.getHeader("Authorization");

        if (StrUtil.isBlank(authorization)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            //验证登录是否过期
            JwtUtil.isExpiration(authorization);
            String username = JwtUtil.getUsernameFromToken(authorization);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //FIXME 目前直接查询数据库，后续改成先在redis中获取，若redis中不存在然后在查询数据库
                UserDetails userDetails = detailsService.loadUserByUsername(username);
                if (!JwtUtil.validateToken(authorization, userDetails)) {
                    return;
                }
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        filterChain.doFilter(request, response);
    }
}
