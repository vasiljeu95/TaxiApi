package com.github.vasiljeu95.taxiapi.configuration;

import com.github.vasiljeu95.taxiapi.configuration.jwt.JwtConfigurer;
import com.github.vasiljeu95.taxiapi.configuration.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * SecurityConfig
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;
    private static final String ADMIN_ENDPOINT = "/api/admin/**";
    private static final String AUTH_ENDPOINT = "/api/auth/**";
    private static final String USER_ENDPOINT = "/api/users/**";
    private static final String DRIVER_ENDPOINT = "/api/drivers/**";
    private static final String SWAGGER_ENDPOINT = "/swagger-ui.html";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_ENDPOINT).permitAll()
                .antMatchers(SWAGGER_ENDPOINT).permitAll()
                .antMatchers(USER_ENDPOINT).hasRole("USER")
                .antMatchers(USER_ENDPOINT).hasRole("ADMIN")
                .antMatchers(DRIVER_ENDPOINT).hasRole("DRIVER")
                .antMatchers(DRIVER_ENDPOINT).hasRole("ADMIN")
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/**/*.css",
                        "/**/*.html",
                        "/**/*.js",
                        "/**/*.json",
                        "/**/*.bmp",
                        "/**/*.jpeg",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.ttf",
                        "/**/*.eot",
                        "/**/*.svg",
                        "/**/*.woff",
                        "/**/*.woff2").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
        ;
        httpSecurity
                .headers().frameOptions().sameOrigin();
    }
}
