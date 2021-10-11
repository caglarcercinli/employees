package com.example.employees.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
               .usersByUsernameQuery("select email as username," +
             "employees.password as password, actief as enabled from employees where email = ?")
                .authoritiesByUsernameQuery("select employees.email as username," +
                        "'admin' as authorities from employees where employees.email=?");
                //
        //        auth.inMemoryAuthentication()
//                .withUser("caglar")
//                .password("{noop}caglar")
//                .authorities("admin")
//                .and()
//                .withUser("user")
//                .password("{noop}user")
//                .authorities("admin");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/images/**")
                .mvcMatchers("/css/**")
                .mvcMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests(requests -> requests
                .mvcMatchers("/", "/login","/congrats").permitAll()
                .mvcMatchers("/**").authenticated());
        http.logout(logout -> logout.logoutSuccessUrl("/"));
    }
}
