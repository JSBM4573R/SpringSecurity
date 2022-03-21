package com.demo.login.Repository.Crud;


import com.demo.login.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRepoDAO extends JpaRepository<Usuario, Integer> {
    public Usuario findByCorreo (String correo);
}
