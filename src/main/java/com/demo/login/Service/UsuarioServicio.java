package com.demo.login.Service;


import com.demo.login.Repository.Crud.IUsuarioService;
import com.demo.login.Repository.Crud.UsuarioCrudRepoDAO;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IUsuarioService{

    @Autowired
    private UsuarioCrudRepoDAO usuarioCrudRepoDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    

    // public List<Usuario> getAll() {
    //     return usuarioRepoDAO.getAll();
    // }

    // public Usuario buscarUsuario(Integer id) {
    //     return usuarioRepoDAO.getUsuario(id);
    // }

    // public Usuario registrarUsuario(Usuario usuario) {
    //     //al objeto que recibe setea la contraseña y la encripta
    //     // usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    //     usuario.setPassword(passencoder.encode(usuario.getPassword()));
    //     //guarda el obejto con la contraseña encriptada
    //     return usuarioRepoDAO.guardarRegistro(usuario);
    // }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioCrudRepoDAO.findByCorreo(correo);
        
    }


    @Override
    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioCrudRepoDAO.save(usuario);
    }
}
    
