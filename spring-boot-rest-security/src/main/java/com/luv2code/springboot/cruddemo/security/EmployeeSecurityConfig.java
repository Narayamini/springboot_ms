package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EmployeeSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails RamSita = User.builder().username("ramsita").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
        UserDetails Lakshman = User.builder().username("lakshman").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails Hanuman = User.builder().username("hanuman").password("{noop}test123").roles("EMPLOYEE").build();
        return new InMemoryUserDetailsManager(RamSita,Lakshman,Hanuman);
    }
}
