package com.notenest.notenest.contoller;


import com.notenest.notenest.entity.User;
import com.notenest.notenest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public String check(){
        return "yes its working";
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }


}
