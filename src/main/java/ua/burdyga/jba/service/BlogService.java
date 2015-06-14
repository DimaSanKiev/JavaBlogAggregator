package ua.burdyga.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.burdyga.jba.entity.Blog;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.repository.BlogRepository;
import ua.burdyga.jba.repository.UserRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
    }
}
