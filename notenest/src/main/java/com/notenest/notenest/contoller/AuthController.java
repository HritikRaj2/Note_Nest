package com.notenest.notenest.contoller;

import com.notenest.notenest.config.JwtProvider;
import com.notenest.notenest.entity.User;
import com.notenest.notenest.repository.UserRepository;
import com.notenest.notenest.request.LoginRequest;
import com.notenest.notenest.response.AuthResponse;
import com.notenest.notenest.service.CustomUserDetailService;
import com.notenest.notenest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Login Endpoint
    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest){
        Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token = JwtProvider.generateToken(authentication);
        AuthResponse res=new AuthResponse(token, "Signin Successfull");

        return res;
    }

    // Signup Endpoint
    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {
        User isExist =userRepository.findByEmail(user.getEmail());
        if(isExist!=null){
            throw new Exception("this email already exist");
        }

        User newUser= new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser=userRepository.save(newUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);
        AuthResponse res=new AuthResponse(token, "Resgister Success");

        return res;
    }

    private Authentication authenticate(String email, String password){
        UserDetails userDetails=customUserDetailService.loadUserByUsername(email);
        if(userDetails==null){
            throw new BadCredentialsException("invalid Username");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid username or Password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }


}
