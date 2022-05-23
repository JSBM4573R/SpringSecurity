package com.demo.login;

import com.demo.login.Repository.UsuarioRepositorioDAO;
import com.demo.login.Service.UsuarioServicio;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

/**
 * Clase de prueba para ejecutar los metodos creados.
 */
// @Component
public class LoginTestApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorioDAO usuarioDAO;
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public void run(String... args) throws Exception {
        
        
        usuarioDAO.registrar(new Usuario(1,"juan","juan@gmail.com","asd"));
        usuarioServicio.registrarUsuario(new Usuario(2,"Carlos","carlos@gmail.com","qwe"));

        System.out.println("Listar usuarios");
        System.out.println(usuarioDAO.getAll());
        System.out.println("");
        System.out.println("Buscar por el nombre UsuarioRepositorioDAO");
        System.out.println(usuarioDAO.findByNombre("juan"));
        System.out.println("");
        System.out.println("Buscar por el correo UsuarioRepositorioDAO");
        System.out.println(usuarioDAO.findByCorreo("juan@gmail.com"));
        System.out.println("");
        System.out.println("Buscar por el nombre UsuarioServicio");
        System.out.println(usuarioServicio.buscarNombre("Carlos"));
        System.out.println("");
        System.out.println("Buscar por el correo UsuarioServicio");
        System.out.println(usuarioDAO.findByCorreo("carlos@gmail.com"));
        System.out.println("");
        System.out.println("Buscar usuario por el id UsuarioRepositorioDAO");
        System.out.println(usuarioDAO.findById(3));
        System.out.println("");
        System.out.println("Registrar un usuario existente UsuarioRepositorioDAO");
        System.out.println(usuarioServicio.registrarUsuario(new Usuario(2,"Carlos","carlos@gmail.com","qwe")));
    }
    
}
