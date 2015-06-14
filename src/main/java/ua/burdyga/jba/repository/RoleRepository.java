package ua.burdyga.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.burdyga.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
