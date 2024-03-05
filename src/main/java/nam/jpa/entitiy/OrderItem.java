package nam.jpa.entitiy;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    private Long id;
    @JoinColumn(name = "orders_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Orders orders;
    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
}
