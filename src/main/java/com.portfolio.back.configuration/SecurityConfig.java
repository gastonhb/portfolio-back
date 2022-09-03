package com.portfolio.back;

import com.portfolio.back.configuration.CorsFilter;
import com.portfolio.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.portfolio.back.security.JwtTokenFilter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new  BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
             
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepo.findByUsername(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User " + username + " not found"));
            }
        };
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
//        configuration.addAllowedHeader("Access-Control-Allow-Origin");
//        configuration.addAllowedHeader("Access-Control-Allow-Headers");
//        configuration.addAllowedHeader("Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//        configuration.addAllowedHeader("Access-Control-Allow-Methods");
        //configuration.addAllowedHeader("Access-Control-Allow-Origin: *, Authorization, Access-Control-Allow-Headers: *, Origin, Accept, Content-Type, Access-Control-Request-Method: *, Access-Control-Request-Headers: *");
        //configuration.addExposedHeader("Access-Control-Allow-Origin: *, Authorization, Access-Control-Allow-Headers: *, Origin, Accept, Content-Type, Access-Control-Request-Method: *, Access-Control-Request-Headers: *");
                //addExposedHeaders("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
//        configuration.addAllowedHeader("Access-Control-Allow-Origin: *");
//        configuration.addAllowedHeader("Access-Control-Allow-Methods: GET, POST, DELETE, PUT, PATCH, HEAD");
//        configuration.addAllowedHeader("Access-Control-Allow-Headers: Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//        configuration.addAllowedHeader("Access-Control-Expose-Headers: Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
//        configuration.addAllowedHeader("Access-Control-Allow-Credentials: true");
        // configuration.addIntHeader("Access-Control-Max-Age: 10");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
    
    
        
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
        http.cors().and()
        //http.cors(withDefaults());
        .csrf().disable();
        //http.cors(withDefaults());
        //sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
         
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .anyRequest().authenticated();
         
        http.exceptionHandling()
                .authenticationEntryPoint(
                    (request, response, ex) -> {
                        response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage()
                        );
                    }
            );
        //http.addFilterBefore(CorsFilter);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }  

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
