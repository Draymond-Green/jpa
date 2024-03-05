package nam.jpa.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @Column(name = "item_id")
    private Long id;
    private String name;

}
