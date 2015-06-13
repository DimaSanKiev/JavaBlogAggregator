package ua.burdyga.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.burdyga.jba.entity.Blog;
import ua.burdyga.jba.entity.Item;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.repository.BlogRepository;
import ua.burdyga.jba.repository.ItemRepository;
import ua.burdyga.jba.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithBlogs(int id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        // find all items which belong to some blog
        for (Blog blog : blogs) {
            List<Item> items = itemRepository.findByBlog(blog);
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }
}
