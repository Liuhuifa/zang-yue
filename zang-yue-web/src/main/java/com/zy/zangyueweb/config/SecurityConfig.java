package com.zy.zangyueweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TODO 用户配置
        auth.inMemoryAuthentication()
                .withUser("root").roles("ROOT").password(passwordEncoder().encode("123456"));
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
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .cors().disable();
    }
}
