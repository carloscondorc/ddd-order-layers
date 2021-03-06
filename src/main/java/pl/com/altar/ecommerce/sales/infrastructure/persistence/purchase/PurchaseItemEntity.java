package pl.com.altar.ecommerce.sales.infrastructure.persistence.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.com.altar.ecommerce.sales.domain.purchase.projections.PurchaseItemData;
import pl.com.altar.ecommerce.shared.Money;
import pl.com.altar.ecommerce.shared.Quantity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "order_item_table")
public class PurchaseItemEntity implements PurchaseItemData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Long id;

    private String name;

    @Embedded
    private Quantity quantity;

    @Embedded
    private Money price = Money.zero();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private PurchaseEntity order;

}
