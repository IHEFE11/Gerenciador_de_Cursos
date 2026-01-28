package DIO.springboot.controller;

import DIO.springboot.repository.UserRepository;
import DIO.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository UserR;
  
    public Optional<User> getUser(int id){
        return UserR.findById(id);
    }
    @PostMapping
    public User Cadastrar(@RequestBody User user){
        return UserR.save(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User loginUser){
        User userEncontrado = UserR.findByUsername(loginUser.getUsername());
        if(userEncontrado != null){
            if(userEncontrado.getPassword().equals(loginUser.getPassword())); 
            return "Login com sucesso \n" + userEncontrado.getName();
        } 
        return "ERRO AO FAZER LOGIN";
    }  
}