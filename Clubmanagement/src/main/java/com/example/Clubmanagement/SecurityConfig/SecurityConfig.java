package com.example.Clubmanagement.SecurityConfig;

import com.example.Clubmanagement.Filter.CustomAuthenticationfilter;
import com.example.Clubmanagement.Filter.CustomAuthorisationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

        CustomAuthenticationfilter customAuthenticationfilter=new CustomAuthenticationfilter(authenticationManagerBean());
        customAuthenticationfilter.setFilterProcessesUrl("/Clubpage/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        //public pages
        http.authorizeRequests().antMatchers( "/Clubpage/Visitor/**","/Clubpage/image/**").permitAll();
        http.authorizeRequests().antMatchers( "/Clubpage/login","/Clubpage/refreshtoken/**").permitAll();
        http.authorizeRequests().antMatchers( "/Clubpage/admin/**").hasAnyAuthority("Role_Admin");
        http.authorizeRequests().antMatchers( "/Clubpage/student/**","/Clubpage/member/**","/Clubpage/info").hasAnyAuthority("Role_Student","Role_Admin");
        //otherpages
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(customAuthenticationfilter);
        http.addFilterBefore(new CustomAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManager();
    }
}
