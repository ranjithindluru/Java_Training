package com.user.management.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configure the AuthenticationManagerBuilder
     *
     * @param auth The AuthenticationManagerBuilder 
     * @throws Exception If an error occurs
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(bCryptPasswordEncoder().encode("admin123")) // Encoded password using BCryptPasswordEncoder
            .roles("ADMIN");
    }

    /**
     * Configures the HTTPSecurity 
     *
     * @param http The HttpSecurity object to configure 
     * @throws Exception If an error occurs 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/**").hasRole("ADMIN") // Only users with "ADMIN" role can access URLs starting with "/api/admin/"
            .anyRequest().permitAll() // Any other request is permitted without authentication
            .and().httpBasic() 
            .and().csrf().disable(); // Disable Cross-Site Request Forgery (CSRF) protection
    }

    /**
     * Provides a BCryptPasswordEncoder bean
     *
     * @return A BCryptPasswordEncoder instance used to encode passwords.
     */
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
