package com.demo.login.Repository.Crud;

import com.demo.login.model.Usuario;

public interface IUsuarioService {
    public Usuario findByCorreo(String correo);
    public Usuario registrar(Usuario usuario);
}
