package com.xwenyuan.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security configuration
 * @author xwenyuan
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * configure user authentication in memory
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("admin")
            .password(new BCryptPasswordEncoder().encode("password"))
            .roles("ADMIN");
    }

    /**
     * configure request authorization
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().headers().disable()    // enable cross-domain request
            .authorizeRequests()
            .antMatchers("/", "/static/**").permitAll()    // urls without auth
            .anyRequest().authenticated()    // other urls need auth
            .and()
            .formLogin()
            .loginPage("/login")    // login url
            .defaultSuccessUrl("/admin")    // login success redirect
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/login")    // logout success redirect
            .permitAll();
    }
    
}
