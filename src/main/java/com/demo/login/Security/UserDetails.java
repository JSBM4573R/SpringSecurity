package com.demo.login.Security;

import com.demo.login.Repository.Crud.UsuarioCrudRepoDAO;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

/**
 * clase que implementa UserDetailsService el cual contiene un metodo loadUserByUsername
 * para poder realizar validaciones y usar metodos UserBuilder para construir un nuevo Usuario
 * se declara con la etiqueta @Service porque implementamos un servicio de UserDetails.
 */
@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    private UsuarioCrudRepoDAO usuarioCrudRepoDAO;

    /**
     * sobre-escritura del metodo loadUserByUsername el cual recibe el String correo
     * ademas lanza una excepcion su el correo no fue encontrado con throw new UsernameNotFoundException
     */
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        //Declaro un objeto de tipo usuario en el cual almaceno el metodo  buscarNombre(nombreUsuario)
        Usuario usuario = usuarioCrudRepoDAO.findByNombre(nombre);
        //Declarar un objeto builder de tipo UserBuilder = null
        UserBuilder builder = null;

        //si el usuario es diferente a null es decir si existe entonces
        if(usuario != null) {
            //builder = al nombre de usuario ingresado
            builder = User.withUsername(nombre);
            //habilitamos el builder con el metodo .disabled(false)
            builder.disabled(false);
            //le pasamos el password del usuario 
            builder.password((usuario.getPassword()));
            //le pasamos una autoridad ROLE_USER 
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            //lanzo exepcion nueva con UsernameNotFoundException(msg)
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        //al final que construya el objeto builder con el metodo build()
        return builder.build();
    }
}