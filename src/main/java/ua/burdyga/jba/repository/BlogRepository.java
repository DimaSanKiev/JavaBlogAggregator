package ua.burdyga.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.burdyga.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
