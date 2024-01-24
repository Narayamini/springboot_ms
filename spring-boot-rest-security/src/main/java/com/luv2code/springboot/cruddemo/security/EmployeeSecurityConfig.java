package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EmployeeSecurityConfig {

    //add support for JDBC ..no hardcoded users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //defining the query to retrieve the user by username- here we provide ? at end of user_id so this will be filled by the incoming login data
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        //defining the query to retrieve the roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
        //tells spring security to use JDBC security authentication with our datasource
    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource)
//    {
//        return new JdbcUserDetailsManager(dataSource);
//        //tells spring security to use JDBC security authentication with our datasource as the table schema is fixed we
//        //no need to give more details
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests
                (configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disabled CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails RamSita = User.builder().username("ramsita").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        UserDetails Lakshman = User.builder().username("lakshman").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails Hanuman = User.builder().username("hanuman").password("{noop}test123").roles("EMPLOYEE").build();
        return new InMemoryUserDetailsManager(RamSita, Lakshman, Hanuman);
    }

     */
}


