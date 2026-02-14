package DIO.springboot.controller;

import DIO.springboot.repository.UserRepository;
import DIO.springboot.handler.BusinessException;
import DIO.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository UserR;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @GetMapping()
    public List<User> getUser(){ 
        return UserR.findAll();
    }
    @PostMapping
    public User Cadastrar(@RequestBody User user){
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new BusinessException("O campo 'username' é obrigatório!");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new BusinessException("O campo 'senha' é obrigatório!");
        }
    String passCripto = new BCryptPasswordEncoder().encode(user.getPassword()); 

// 2. Cria o usuário já com os dados prontos (Login, Senha Criptografada, Role)
// Se for um registro comum, passamos "USER" ou a role que veio do DTO
    User newUser = new User(user.getUsername(), passCripto, "USER"); 

// 3. Salva
    return this.UserR.save(newUser);
    }
 
}