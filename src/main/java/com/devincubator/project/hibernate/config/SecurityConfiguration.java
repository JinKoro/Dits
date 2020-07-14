package com.devincubator.project.hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public CustomSuccessHandler customSuccessHandler(){
        return new CustomSuccessHandler();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception{
            auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select login,password,roleId from user,userrole where login=?")
                .authoritiesByUsernameQuery("select login,name from user " +
                        "join userrole on user.id=userId " +
                        "join role on roleId = role.id where login=?")
                .getUserDetailsService()
            ;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http.authorizeRequests()
                    .antMatchers("/","/home","/user/**").access("hasRole('USER')")
                    .antMatchers("/admin/**").access("hasRole('ADMIN')")
                    .antMatchers("/tutor/**").access("hasRole('TUTOR')")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .loginProcessingUrl("/login") //value в login.jsp
                    .successHandler(customSuccessHandler())
                    .usernameParameter("ssoId") //name в login.jsp
                    .passwordParameter("password") //name в login.jsp
                    .permitAll()
                .and()
                    .csrf()
                .and()
                    .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied")
                .and()
                    .addFilterBefore(filter, CsrfFilter.class);
    }
}
