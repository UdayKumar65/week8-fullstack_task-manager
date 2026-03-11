package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.dto.LoginRequest;
import model.entity.User;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController<AuthService> {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    // Register new user
    @PostMapping("/register")
    public User register(@RequestBody User user){

        return ((Object) authService).register(user);

    }

    // Login user
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        return ((Object) authService).login(request);

    }

}