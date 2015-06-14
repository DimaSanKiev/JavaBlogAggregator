package ua.burdyga.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.burdyga.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

}
