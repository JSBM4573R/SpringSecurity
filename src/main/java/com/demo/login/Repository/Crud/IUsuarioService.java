package com.demo.login.Repository.Crud;

import com.demo.login.model.Usuario;

/**
 * Interfaz donde creo los metodos que no existen en el CrudRepo de JpaRepository 
 */
public interface IUsuarioService {
    //Creo un metodo con finBy de Spring y el nombre del atributo
    //tener en cuenta que el nombre del metodo tiene que ser en CamelCase
    public Usuario findByCorreo(String correo);
}
