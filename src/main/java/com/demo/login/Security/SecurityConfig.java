package com.demo.login.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetails userDetailsService;

    //Inyectamos un @Bean para encriptar las contraseñas con BCryptPasswordEncoder
    //en el metodo passwordEncoder que retornada la contraseña Encriptada.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    //Sobre-escribimos el tipo de autenticacion que voy a usar
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //al objeto auth le agragamos el userDetailsService ademas del passwordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder((passwordEncoder()));
    }

    @Override
    //sobre-escribimos los permisos http requests  
    protected void configure(HttpSecurity http) throws Exception {
        //al objeto http le agregamos las authorizeRequests con antMatchers
        //la raiz /, todo lo que venga despues de /auth/, todo lo que venga de /public/..
        //el simbolo que representa autorizar todo lo que venga despues de un endpoint es doble * 
        //le damos permiso con permitAll de lo contrario anyRequest tendra que autenticarse authenticated 
        http.authorizeRequests().antMatchers("/","/auth/**","/public/**","/api/**","/css/**","/js/**", "/static/**").permitAll().anyRequest().authenticated()
        //concatenamos con and
        .and()
            //utilizamos el formLogin de Spring y le damos un page con loginPage("/auth/login")
            //si es correcto el login accedo al index privado con defaultSuccessUrl("/private/index", true)
            //si no es correcto el login entonces agregue al Path el ?error=true con failureForwardUrl("/auth/login?error=true")
            .formLogin().loginPage("/auth/login").defaultSuccessUrl("/private/index", true).failureForwardUrl("/auth/login?error=true")
            //Spring lee el error y lo redireccionamos a un Path personalizado con el informe de error
            .loginProcessingUrl("/auth/login-post").permitAll()
        //concatenamos con and
        .and()
            //creamos el logout el cual permite el cerrar sesion con .logout() con el path .logoutUrl("/logout")
            //ademas si cerramos correctamente la sesion lo redireccionamos al index publico con .logoutSuccessUrl("/public/index")
            .logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");
    }
    
}
