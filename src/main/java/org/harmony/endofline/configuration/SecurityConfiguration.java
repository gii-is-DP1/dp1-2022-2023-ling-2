package org.harmony.endofline.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/resources/**","/webjars/**","/h2-console/**").permitAll()
            .antMatchers("/dashboard", "/achievement", "/achievement/**").hasAuthority("TRUE")
            .antMatchers(HttpMethod.GET, "/","/oups").permitAll()
            .antMatchers("/u/new").permitAll()
            // TODO: Here we should put the security for the rest of the pages
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .failureUrl("/login-error")
            .and()
            .logout()
            .logoutSuccessUrl("/");
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "select username,password,enabled "
                    + "from users "
                    + "where username = ?")
            .authoritiesByUsernameQuery(
                "select username, is_admin "
                    + "from users "
                    + "where username = ?")
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder =  NoOpPasswordEncoder.getInstance();
        return encoder;
    }

}
