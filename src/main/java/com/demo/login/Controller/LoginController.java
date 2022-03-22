package com.demo.login.Controller;

import com.demo.login.Service.UsuarioServicio;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/auth/login")
    //metodo String porque retorno una vista
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        //retorna una vista llamada login
        return "login";
    }

   @GetMapping("/auth/registro")
   //Creo un metodo que me permita desplegar un formulario con un Model
   public String registroForm(Model model) {
        //al model le agrego el nuevo usuario
        model.addAttribute("usuario", new Usuario());
        //retorna una vista llamada registro
        return "registro";
   }

   @PostMapping("/auth/registro")
   //metodo que recibe un objeto tipo usuario un modelo tipo model y una pequeña validacion con BindingResult en result
   public String registroUsuario(@ModelAttribute Usuario usuario, BindingResult result, Model model) {
       //BindingResult result guarda una validacion si existe un error con el metodo hasErrors entonces
       if(result.hasErrors()) {
           //retorno una redireccion al endPoint de registro
           return "redirect:/auth/registro";
       }else{
           //si todo sale bien guardo el registrol agregandole al modelo "usuario" el nuevo registro
           model.addAttribute("usuario", usuarioServicio.registrarUsuario(usuario));
       }
       //despues de agregar ok genero una redireccion al login
       return "redirect:/auth/login";
   }
}
