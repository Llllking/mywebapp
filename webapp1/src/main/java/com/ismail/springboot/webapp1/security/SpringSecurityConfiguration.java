package com.ismail.springboot.webapp1.security;

import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails userDetails1 = createNewUser("Ismail", "dummy");
        UserDetails userDetails2 = createNewUser("hachami", "dummy2");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Nonnull
    private UserDetails createNewUser(String username, String userPassword) {
        return User.builder().passwordEncoder(password -> passwordEncoder().encode(password)).username(username).password(userPassword).roles("ADMIN", "USER").build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();

    }


}
