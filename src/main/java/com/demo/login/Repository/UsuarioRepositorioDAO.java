package com.demo.login.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.demo.login.Repository.Crud.IUsuarioService;
import com.demo.login.Repository.Crud.UsuarioCrudRepoDAO;
import com.demo.login.model.Usuario;

/**
 * Repositorio que implementa la IUsuarioService el cual contiene un metodo creado
 * se genera el Override del metodo creado y se personaliza
 */
@Repository
public class UsuarioRepositorioDAO implements IUsuarioService {
    @Autowired
    private UsuarioCrudRepoDAO usuarioCrudRepoDAO;

    /**
     * metodo que permite traer una lista de todos los usuarios
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
    public Optional<Usuario> findById(Integer id) {
        return usuarioCrudRepoDAO.findById(id);
    }

    /**
     * metodo que permite guardar una entidad en este caso el Usuario
     * @param usuario
     * @return save(usuario)
     */
    public Usuario registrar(Usuario usuario) {
        return usuarioCrudRepoDAO.save(usuario);
    }

    /**
     * Metodo @Override que permite buscar en la DB el correo del usuario 
     * @param correo
     * @return correo_usuario
     */
    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioCrudRepoDAO.findByCorreo(correo);
    }

    /**
     * Metodo @Override que permite buscar en la DB el nombre del usuario 
     * @param nombre
     * @return nombre_usuario
     */
    @Override
    public Usuario findByNombre(String nombre) {
        return usuarioCrudRepoDAO.findByNombre(nombre);
    }

    /**
     * Metodo que valida si el correo existe en la DB.
     * @param correo
     * @return false si no existe y true si existe
     */
    public boolean existeCorreo(String correo) {
        if(findByCorreo(correo) == null){
            return false;
        }else{
            return true;
        }
    }

}
