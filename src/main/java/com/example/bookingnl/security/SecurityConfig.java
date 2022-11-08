package com.example.bookingnl.security;

import com.example.bookingnl.filter.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new CustomAuthenticationFilter(authenticationManager(authenticationConfiguration)));
        return http.build();
    }
/*        //For h2-console in browser
        http.
                headers().
                frameOptions().
                and().
                contentSecurityPolicy("frame-ancestors 'self' " + webserver);
        http
                .authorizeRequests()
                .antMatchers("/login/**",
                        "/api/token/refresh",
                        "/h2-console/*").permitAll()
                .antMatchers("/**").hasAnyAuthority("Customer")
                .anyRequest().authenticated();*/
       // http.addFilter(new CustomAuthenticationFilter(authenticationManager(authenticationConfiguration)));
       // http.addFilterBefore(new CustomAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
        //return http.build();


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
                     //   .allowedOrigins(webserver);
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
