package com.demo.login.Controller;

import com.demo.login.Service.UsuarioServicio;
import com.demo.login.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UsuarioServicio usuarioServicio;

   @GetMapping("/auth/registro")
   //Creo un metodo que me permita desplegar un formulario con un Model
   public String registroForm(Model model) {
        //al model le agrego el nuevo usuario
        model.addAttribute("usuario", new Usuario());
        //retorna una vista llamada registro
        return "registro";
   }


   @PostMapping("/auth/registro")
   public String registroUsuario(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model) {
       if(result.hasErrors()) {
           return "redirect:/auth/registro";
       }else{
           model.addAttribute("usuario", usuarioServicio.registrar(usuario));
       }
       return "redirect:/auth/login";
   }
    
}
