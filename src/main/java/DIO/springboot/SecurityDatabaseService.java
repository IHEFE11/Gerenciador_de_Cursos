package DIO.springboot;


import DIO.springboot.model.Manager;
import DIO.springboot.model.User;
import DIO.springboot.repository.ManagerRepository;
import DIO.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // 1. Primeiro procura na tabela de USUÁRIOS COMUNS
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // ACHOU! Retorna IMEDIATAMENTE e para o código aqui.
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Define papel de Usuário
            
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    authorities);
        }

        // 2. Se NÃO achou usuário, procura na tabela de GERENTES
        // ATENÇÃO: Use findByUsername, NUNCA findAll
        Manager manager = managerRepository.findByUsername(username); 
        if (manager != null) {
            // ACHOU! Retorna como ADMIN
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // Define papel de Admin
            
            return new org.springframework.security.core.userdetails.User(
                    manager.getUsername(),
                    manager.getPassword(),
                    authorities);
        }

        // 3. Se chegou aqui, não existe em lugar nenhum
        throw new UsernameNotFoundException("Usuário não encontrado!");
    }
}