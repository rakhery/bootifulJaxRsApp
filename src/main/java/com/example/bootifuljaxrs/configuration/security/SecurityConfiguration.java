package com.example.bootifuljaxrs.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private static UserDetails user(String usr,String ...roles){
        return User.withUsername(usr).password("{noop}password").roles(roles).build();
    }

    @Bean
    UserDetailsService bookUserDetailsService(){
        List<UserDetails> details= Arrays.asList(user("rchris","ADMIN","USER"),user("rhery","USER"));
        return new InMemoryUserDetailsManager(details);

    }
    //In Spring Security 5.7.0-M2 we deprecated the WebSecurityConfigurerAdapter hmmm...
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .antMatcher("/**")
                .authorizeRequests().antMatchers("/h2-console/**")
                .permitAll()
                .and()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/customers*").hasRole("ADMIN")
                .anyRequest().permitAll();
        return http.build();
    }





}
