package com.mystudy.firstproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/css/**","/js/**","/h2-console/**","/account/register").permitAll()
                    .anyRequest().authenticated() //그 외에 페이지는 로그인 후 볼 수 있게 처리
                    .and()
                .formLogin()
                    .loginPage("/account/login").permitAll()
                    .and()
                .logout()
                .logoutUrl("/logout").permitAll()
                        .deleteCookies("JESESSION", "Remember-Me");

        //h2 csrf설정
        http
                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**"))
                .and().headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'"))
                .frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource) //spring에 전달해주면 알아서 처리
                .passwordEncoder(passwordEncoder()) //비밀번호 암호화 처리
                .usersByUsernameQuery("select username,password,enabled "
                        + "from member "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select u.username, r.name "
                        + "from user_role ur inner join member u on ur.user_id = u.id "
                        + "inner join role r on ur.role_id = r.role_id "
                        + "where u.username = ?");
    }

/*        @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
