package com.notenest.notenest.config;


import com.notenest.notenest.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurity {



    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/InfoCnt/**").authenticated()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(new jwtValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(){
//        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailServiceImpl);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return new ProviderManager(authProvider);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
