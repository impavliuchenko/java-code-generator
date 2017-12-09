package com.codegen.config;

import com.codegen.security.JwtAuthenticationTokenFilter;
import com.codegen.security.JwtAuthenticationEntryPoint;
import com.codegen.security.JwtAuthenticationProvider;
import com.codegen.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    //custom authentication manager
    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    //custom filter
    @Bean
    public JwtAuthenticationTokenFilter authenticationConfifureFilter (){
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        //can redirect request to this particular handler and do some processing
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests() //authorize all instead of:
                .antMatchers("**/api/**") // need to authenticate to this
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                //don't make ny session stateful:
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationConfifureFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();

    }
}
