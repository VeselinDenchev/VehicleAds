package com.vehicleads.configurations;

import com.vehicleads.implementation.services.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/", "/ads/*","/ads/*/*", "/register", "/login", "/error", "/resources/**", "/static/**",
                                     "/css/**", "/js/**", "/img/**", "/webjars/**", "https://cdn.jsdelivr.net/**",
                                     "https://code.jquery.com/**", "https://cdnjs.cloudflare.com/ajax/**",
                                     "https://stackpath.bootstrapcdn.com/**",
                                     "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/**",
                                     "https://kit.fontawesome.com/**").permitAll() // Public URLs
                        .anyRequest().authenticated() // All other URLs are protected
        );
        http.formLogin(form ->
                       form.loginPage("/login")
                           .defaultSuccessUrl("/")
                           .permitAll() // Allow access to the login page
        );
        http.logout(logout ->
                    logout.logoutUrl("/logout")
                          .logoutSuccessUrl("/")
                          .permitAll());
        http.sessionManagement(sessionManagement ->
            sessionManagement.sessionFixation().changeSessionId() // Protect against session fixation attacks
                             .maximumSessions(1) // Only one concurrent session per user
                              .expiredUrl("/login?expired")); // Redirect if session expires)

        return http.build();
    }

    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
