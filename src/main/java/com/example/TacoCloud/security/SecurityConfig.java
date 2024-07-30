package com.example.TacoCloud.security;

import com.example.TacoCloud.data.UserDataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author aleksandrov_maksim
 */
@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception{
        
        return http
                .authorizeHttpRequests(c -> {
                        c.requestMatchers("/design", "/orders").hasRole("USER");
                        c.requestMatchers("/", "/**").permitAll();
                })
                .formLogin(c -> 
                        c.loginPage("/login").defaultSuccessUrl("/design", true))
                .build();
                
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
        
    @Bean
    public UserDetailsService userDetailsService(UserDataRepository userRepo) {
        return username -> {
            UserData user = userRepo.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }
}
