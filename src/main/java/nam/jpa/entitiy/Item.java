package nam.jpa.entitiy;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private Integer quantity;
    private Integer price;
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();
    public Item(String itemName, Integer quantity, Integer price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}
