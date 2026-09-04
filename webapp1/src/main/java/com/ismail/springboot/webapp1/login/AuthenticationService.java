package com.ismail.springboot.webapp1.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String userName, String password){
        return userName.equalsIgnoreCase("ismail") && password.equalsIgnoreCase("dummy");
    }
}
