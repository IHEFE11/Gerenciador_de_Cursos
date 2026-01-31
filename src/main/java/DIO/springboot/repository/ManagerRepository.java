package DIO.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import DIO.springboot.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
   
    Manager findByUsername(String username);

} 
