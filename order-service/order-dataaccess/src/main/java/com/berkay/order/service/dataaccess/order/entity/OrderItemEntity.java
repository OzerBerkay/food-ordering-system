package com.berkay.order.service.dataaccess.order.entity;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderItemEntityId.class)
@Table(name = "order_items")
@Entity
public class OrderItemEntity {
    @Id
    private Long id;
    @Id // This set as composite primary key because to be guaranteed its uniqueness
    // for example (orderItemId, orderId) => {(0,0) (0,1), (0,2), (1,2)} order item id starts from 0 for each order, so using composite id resolve confusion
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    private UUID productId;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subTotal;

    @Override
    public boolean equals(Object o) { // My primary key consist of these two fields
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return id.equals(that.id) && order.equals(that.order);
    }

    @Override
    public int hashCode() { // My primary key consist of these two fields
        return Objects.hash(id, order);
    }
}
