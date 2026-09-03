package com.ismail.springboot.webapp1.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String goToLoginPage(@RequestParam String name, @RequestParam int age, @RequestParam String country, ModelMap model){
        logger.info("the name passed to the controller from the request is : {}", name);
        model.put("name", name);
        model.put("age", age);
        model.put("country", country);
        return "login";
    }
}
