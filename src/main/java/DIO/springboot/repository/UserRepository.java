package DIO.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import DIO.springboot.model.User;

public interface UserRepository extends JpaRepository<User,  String> {

    User findByLogin(String login);

}
