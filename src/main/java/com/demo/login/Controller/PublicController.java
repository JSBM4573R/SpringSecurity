package com.demo.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {
    
    /**
     * Genero una vista tipo String para mostrarla en el endPoint /public/index
     * @return una vista llamada logout
     */
    @GetMapping("/index")
    public String index() {
        return "logout";
    }
}
