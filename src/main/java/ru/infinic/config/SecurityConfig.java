package ru.infinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.infinic.config.handler.LoginSuccessHandler;

/**
 * @author Oleg Kadochnikov
 */

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // Указываем страницу с формой логина
                .loginPage("/login")
                // Указываем логику обработки при логине
                .successHandler(new LoginSuccessHandler())
                // Указываем action с формы логина
                .loginProcessingUrl("/login")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("username")
                .passwordParameter("password")
                // Даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // Разрешаем делать логаут всем
                .permitAll()
                // Указываем URL логаута
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // Указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                // Выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                .and().csrf().disable();

        http

                // Делаем страницу регистрации недоступной для авторизированных пользователей
                .authorizeRequests()
                // Страницы аутентификаци доступна всем
                .antMatchers("/login").anonymous()
                // Защищенные URL
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
