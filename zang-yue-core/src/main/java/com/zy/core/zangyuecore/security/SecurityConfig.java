package com.zy.core.zangyuecore.security;

import com.zy.core.zangyuecore.security.handler.FailureHandler;
import com.zy.core.zangyuecore.security.handler.SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * <p>
 * spring security 核心配置类
 * </p>
 *
 * @author lhf
 * @since 2020/7/15$ 17:26$
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource()
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TODO 用户配置
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO web配置
        web.ignoring().antMatchers("/doc.html",
                "/swagger-resources/**",
                "/images/**",
                "/webjars/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/configuration/security");
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO 安全配置
        http.authorizeRequests()
                .antMatchers("/sys-user/add", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(new SuccessHandler())
                .failureHandler(new FailureHandler())
                .and()
                .csrf().disable()
                .cors().disable();
    }
}
