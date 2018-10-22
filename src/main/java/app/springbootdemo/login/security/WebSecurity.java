package app.springbootdemo.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import static app.springbootdemo.login.security.SecurityConstants.SIGN_UP_URL;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
   // private AuthenticationSuccessHandler authenticationSuccessHandler;

    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
  //  @Autowired
    //private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()

                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
//{
//            http
//                    .csrf().disable()
//                    .exceptionHandling()
//                    .authenticationEntryPoint(restAuthenticationEntryPoint)
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/").authenticated()
//                    .and()
//                    .formLogin()
//                    .successHandler(authenticationSuccessHandler)
//                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                    .and()
//                    .logout();
//        }
   }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

//    @Override
//        public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
//            web.ignoring().antMatchers("/swagger/docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
//
//        }




}