package com.zy.core.zangyuecore.security;

import com.zy.core.zangyuecore.security.handler.FailureHandler;
import com.zy.core.zangyuecore.security.handler.SuccessHandler;
import com.zy.core.zangyuecore.security.phone.PhoneFilter;
import com.zy.core.zangyuecore.security.phone.PhoneProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;
    @Resource
    private PhoneProvider phoneProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TODO 用户配置
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(phoneProvider);
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
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO 安全配置
        http.authorizeRequests()
                .antMatchers("/sys-user/add", "/login/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(new SuccessHandler())
                .failureHandler(new FailureHandler())
                .and()
                .csrf().disable()
                .cors();

        http.addFilterAfter(phoneFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PhoneFilter phoneFilter() throws Exception {
        PhoneFilter phoneFilter = new PhoneFilter();
        phoneFilter.setAuthenticationSuccessHandler(new SuccessHandler());
        phoneFilter.setAuthenticationFailureHandler(new FailureHandler());
        phoneFilter.setAuthenticationManager(super.authenticationManagerBean());
        return phoneFilter;
    }

}
