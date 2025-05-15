package com.berkay.order.service.domain.valueobject;

import com.berkay.domain.valueobject.BaseId;
import com.berkay.domain.valueobject.OrderId;
import com.berkay.order.service.domain.entity.Product;

public class OrderItemId extends BaseId<Long>{
    public OrderItemId(Long value) {
        super(value);
    }
}
