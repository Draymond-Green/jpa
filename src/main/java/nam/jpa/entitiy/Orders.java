package nam.jpa.entitiy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id @GeneratedValue
    @Column(name = "oders_id")
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItems = new ArrayList<>();

}
