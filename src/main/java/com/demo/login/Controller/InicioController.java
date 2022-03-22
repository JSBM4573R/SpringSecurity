package com.demo.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    /**
     * Genero un metodo Get que me trae la vista principal
     * @return una vista llamada inicio
     */
    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }
}
