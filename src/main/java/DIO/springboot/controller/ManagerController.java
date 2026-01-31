package DIO.springboot.controller;

import DIO.springboot.repository.ManagerRepository;
import DIO.springboot.handler.BusinessException;
import DIO.springboot.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ManagerController {

    @Autowired
    private ManagerRepository ManagerR;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @GetMapping()
    public List<Manager> getManager(){ 
        return ManagerR.findAll();
    }

    @PostMapping
    public Manager Cadastrar(@RequestBody Manager manager){
        if(manager.getName() == null || manager.getName().isEmpty()){
            throw new BusinessException("O campo 'nome' é obrigatório!");
        }
        if(manager.getUsername() == null || manager.getUsername().isEmpty()){
            throw new BusinessException("O campo 'username' é obrigatório!");
        }
        if(manager.getPassword() == null || manager.getPassword().isEmpty()){
            throw new BusinessException("O campo 'senha' é obrigatório!");
        }
        String passCripto = encoder.encode(manager.getPassword());
        manager.setPassword(passCripto);
        return ManagerR.save(manager);
    }
}