package ua.burdyga.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.burdyga.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
