package com.wangjin.tallymaster.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/15 下午4:03.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .authorizeRequests()
                // .antMatchers("/").permitAll()                      //请求路径"/"允许访问
                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
                .and()
                .formLogin()
                .loginPage("/login")                             //定义登录的页面"/login"，允许访问
                .permitAll()
                .and()
                .logout()                                           //默认的"/logout", 允许访问
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //添加内存用户
        auth.inMemoryAuthentication()
                .withUser("admin").password("12345").roles("USER","ADMIN").and()
                .withUser("wangjin").password("wangjin").roles("USER","ADMIN");
    }
}
