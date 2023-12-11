package pl.szymontruszkowski.employeedirectory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configuration class responsible for Spring Security config.
 */
@Configuration
public class SecurityConfig {

    /**
     * Define login credentials and roles for different users.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails lucas = User.builder()
                .username("lucas")
                .password("{bcrypt}$2a$10$9UyDHNHPTewyRV1QBzrpvOcNMGPw2aNT6ZaWW/0iMQyP/7Bubeb3i")
                .roles("EMPLOYEE")
                .build();

        UserDetails william = User.builder()
                .username("william")
                .password("{bcrypt}$2a$10$iYLOmxRGudICyL35TucY3uSoIbjKYUjiNRPKllgTjRY08/ShYyDkm")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails emma = User.builder()
                .username("emma")
                .password("{bcrypt}$2a$10$X3HF3xTo7L6Wdc6hBGfkhO4cFhoaqNZx3Y6xNxWwyHje/2IHSrU62")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(lucas, william, emma);
    }

    /**
     * Restrict URLs based on roles, define custom login/access denied page.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(new AntPathRequestMatcher("/")).hasRole("EMPLOYEE")
                        .requestMatchers(new AntPathRequestMatcher("/sortByFirstName")).hasRole("EMPLOYEE")
                        .requestMatchers(new AntPathRequestMatcher("/sortByLastName")).hasRole("EMPLOYEE")

                        .requestMatchers(new AntPathRequestMatcher("/showAddEmployeeForm")).hasRole("MANAGER")
                        .requestMatchers(new AntPathRequestMatcher("/processAddEmployeeForm")).hasRole("MANAGER")
                        .requestMatchers(new AntPathRequestMatcher("/updateEmployee")).hasRole("MANAGER")

                        .requestMatchers(new AntPathRequestMatcher("/deleteEmployee")).hasRole("ADMIN")
                        .anyRequest().authenticated())

                        .formLogin(form -> form
                            .loginPage("/login-page")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll())

                        .logout(LogoutConfigurer::permitAll)

                        .exceptionHandling(configurer -> configurer
                            .accessDeniedPage("/access-denied-page"));

        return http.build();
    }

    /**
     * Enable access to H2 Console regardless of the logged-in user.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }
}
