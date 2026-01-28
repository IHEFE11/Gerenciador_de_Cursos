package DIO.springboot.controller;

import DIO.springboot.repository.UserRepository;
import DIO.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository UserR;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable int id){ 
        return UserR.findById(id);
    }

    @PostMapping
    public User Cadastrar(@RequestBody User user){
        String passCripto = encoder.encode(user.getPassword());
        user.setPassword(passCripto);
        return UserR.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser){
        User userEncontrado = UserR.findByUsername(loginUser.getUsername());
        if(userEncontrado != null){
            boolean senhaBatuta = encoder.matches(loginUser.getPassword(), userEncontrado.getPassword());
            if(senhaBatuta){
                return "Login com sucesso \n" + userEncontrado.getName();
            }
        } 
        return "ERRO AO FAZER LOGIN";
    }  
}