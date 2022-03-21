package com.demo.login.Service;


import java.util.List;

import com.demo.login.Repository.UsuarioRepositorioDAO;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepositorioDAO usuarioRepositorioDAO;
    
    /**
     * metodo que trae a todos los usuarios en una lista
     * @return
     */
    public List<Usuario> getAll() {
        return usuarioRepositorioDAO.getAll();
    }

    /**
     * metodo que trae a un usuario por su id
     * @param id
     * @return
     */
    public Usuario buscarUsuario(Integer id) {
        return usuarioRepositorioDAO.findById(id);
    }

    /**
     * metodo que busca por el correo a un Usuario
     * @param correo
     * @return
     */
    public Usuario buscarCorreo(String correo) {
        return usuarioRepositorioDAO.findByCorreo(correo);
    }

    /**
     * guardar el usuario con la contraseña encriptada de BCryptPasswordEncoder
     * @param usuario
     * @return save(usuario)
     */
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepositorioDAO.findById(usuario.getId()) != null) {
            //al objeto que recibe setea la contraseña y la encripta
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            //guarda el objeto con la contraseña encriptada
            return usuarioRepositorioDAO.registrar(usuario);
        } else {
            return usuario;
        }
    }
}
    
