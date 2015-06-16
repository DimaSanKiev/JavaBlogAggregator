package ua.burdyga.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.burdyga.jba.entity.Blog;
import ua.burdyga.jba.entity.Role;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.repository.BlogRepository;
import ua.burdyga.jba.repository.ItemRepository;
import ua.burdyga.jba.repository.RoleRepository;
import ua.burdyga.jba.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setEnabled(true);
        userAdmin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("admin"));
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blogJavavids = new Blog();
        blogJavavids.setName("JavaVids");
        blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJavavids.setUser(userAdmin);
        blogRepository.save(blogJavavids);

//        Item item1 = new Item();
//        item1.setBlog(blogJavavids);
//        item1.setTitle("first");
//        item1.setLink("http://javavids.com");
//        item1.setPublishedDate(new Date());
//        itemRepository.save(item1);
//
//        Item item2 = new Item();
//        item2.setBlog(blogJavavids);
//        item2.setTitle("second");
//        item2.setLink("http://javavids.com");
//        item2.setPublishedDate(new Date());
//        itemRepository.save(item2);
    }
}
