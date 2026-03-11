package service;

import org.springframework.stereotype.Service;

import model.dto.LoginRequest;
import model.entity.User;

@Service
public class AuthService<UserRepository, JwtTokenProvider> {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository,
                       JwtTokenProvider jwtTokenProvider){

        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;

    }

    // Register new user
    public User register(User user){

        return ((Object) userRepository).save(user);

    }

    // Login user
    public String login(LoginRequest request){

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return jwtTokenProvider.generateToken(user.getUsername());
    }

}