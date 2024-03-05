package nam.jpa.entitiy;

import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @Column(name = "oders_id")
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
