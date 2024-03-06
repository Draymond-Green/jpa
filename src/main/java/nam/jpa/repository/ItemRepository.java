package nam.jpa.repository;

import nam.jpa.entitiy.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


}
