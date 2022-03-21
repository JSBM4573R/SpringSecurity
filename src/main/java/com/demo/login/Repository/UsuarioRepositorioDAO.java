package com.demo.login.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.demo.login.Repository.Crud.UsuarioCrudRepoDAO;
import com.demo.login.model.Usuario;

@Repository
public class UsuarioRepositorioDAO {
    @Autowired
    private UsuarioCrudRepoDAO usuarioCrudRepoDAO;
    
    public List<Usuario> getAll(){
        return (List<Usuario>)usuarioCrudRepoDAO.findAll();
    }
    
    public Usuario getUsuario(Integer id) {
        return usuarioCrudRepoDAO.getById(id);
    }

    //metodo que permite guardar el usuario en la base de datos
    public Usuario guardarRegistro(Usuario usuario) {
        return usuarioCrudRepoDAO.save(usuario);
    }


    // public Usuario buscarNombre(String username) {
    //     Optional<Usuario> consulta = usuarioCrudRepoDAO.findByUserName(username);
    //     if (consulta.isEmpty()) {
    //         return null;
    //     } else {
    //         return consulta.get();
    //     }
    // }
}
