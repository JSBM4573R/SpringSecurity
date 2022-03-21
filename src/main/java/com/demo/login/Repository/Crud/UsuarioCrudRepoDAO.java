package com.demo.login.Repository.Crud;


import com.demo.login.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository interface que extiende de JpaRepository el cual contiene todos
 * los metodos para la comunicacion con la Base de Datos MySQL
 */
@Repository
public interface UsuarioCrudRepoDAO extends JpaRepository<Usuario, Integer> {
    public Usuario findByCorreo (String correo);
}
