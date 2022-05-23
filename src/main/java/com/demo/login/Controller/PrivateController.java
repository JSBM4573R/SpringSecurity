package com.demo.login.Controller;

import javax.servlet.http.HttpSession;

import com.demo.login.Service.UsuarioServicio;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class PrivateController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * @param auth
     *          contiene la autenticacion necesaria para iniciar sesion
     * @param session
     *          contiene la sesion activa creada por el usuario ingresado
     * @return una vista llamada index
     */
    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session) {
        //creo una variable nombre que va a contener el nombre del usuario
        //por medio de Authentication
        String correo = auth.getName();

        //si la sesion es igual a nula es decir no hay ninguna sesion activa entonces
        if(session.getAttribute("usuario") == null) {
            //Creo una variable usuario del objeto usuario que va a contener el correo del usuario
            Usuario usuario = usuarioServicio.buscarCorreo(correo);
            //evito que me traiga el password lo seteo como null para garantizar seguridad
            usuario.setPassword(null);
            //al objeto session le cambio el atributo al nuevo usuario ingresado
            session.setAttribute("usuario", usuario);
        }
        //retorne una vista llamada index
        return "index";
    }
}
