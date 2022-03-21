package com.demo.login.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.demo.login.Repository.Crud.IUsuarioService;
import com.demo.login.Repository.Crud.UsuarioCrudRepoDAO;
import com.demo.login.model.Usuario;

/**
 * Repositorio que implementa la IUsuarioService el cual contiene un metodo creado
 * se genera el Overraid del metodo creado y se personaliza
 */
@Repository
public class UsuarioRepositorioDAO implements IUsuarioService {
    @Autowired
    private UsuarioCrudRepoDAO usuarioCrudRepoDAO;

    /**
     * metodo que permite traer na lista de todos los usuarios
     * @return List<Usuario>
     */
    public List<Usuario> getAll(){
        return (List<Usuario>)usuarioCrudRepoDAO.findAll();
    }
    
    /**
     * metodo que busca por el id a un usuario y lo trae
     * @param id
     * @return Usuario
     */
    public Usuario findById(Integer id) {
        return usuarioCrudRepoDAO.getById(id);
    }

    /**
     * metodo que permite guardar una entidad en este caso el Usuario
     * @param usuario
     * @return save()
     */
    public Usuario registrar(Usuario usuario) {
        return usuarioCrudRepoDAO.save(usuario);
    }

    /**
     * Metodo que permite buscar por el correo 
     * @param correo
     * @return correo_usuario
     */
    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioCrudRepoDAO.findByCorreo(correo);
    }
}
