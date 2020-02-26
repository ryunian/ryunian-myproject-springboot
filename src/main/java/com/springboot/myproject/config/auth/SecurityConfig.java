package com.springboot.myproject.config.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
//                .antMatchers("/", "/css/**", "/img/**", "/js/**", "/h2-console/**","/vendor/**", "/profile").permitAll()
//                .antMatchers("/api/**").hasRole(Role.USER.name())
//                .anyRequest().authenticated()
//                .antMatchers("/api/posts/**","/write","/modify").authenticated()
                .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/authenticate")
                    .defaultSuccessUrl("/")
                    .usernameParameter("id")
                    .passwordParameter("pw")
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}