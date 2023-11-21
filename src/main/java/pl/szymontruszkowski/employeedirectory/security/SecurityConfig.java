package pl.szymontruszkowski.employeedirectory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails lucas = User.builder()
                .username("lucas")
                .password("{noop}lucas123")
                .roles("EMPLOYEE")
                .build();

        UserDetails william = User.builder()
                .username("william")
                .password("{noop}william123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails emma = User.builder()
                .username("emma")
                .password("{noop}emma123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(lucas, william, emma);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                                .anyRequest().authenticated())

                                .formLogin(form -> form
                                    .loginPage("/showLoginPage")
                                    .loginProcessingUrl("/authenticateTheUser")
                                    .permitAll());

        return http.build();
    }
}
