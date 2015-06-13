package ua.burdyga.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.burdyga.jba.entity.Blog;
import ua.burdyga.jba.entity.User;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // this user is an attribute in the Blog entity
    List<Blog> findByUser(User user);

}
