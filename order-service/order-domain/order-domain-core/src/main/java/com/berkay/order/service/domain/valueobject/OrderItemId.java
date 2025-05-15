package com.berkay.order.service.domain.valueobject;

import com.berkay.domain.valueobject.BaseId;
import com.berkay.domain.valueobject.OrderId;

public class OrderItemId extends BaseId<Long>{
    private OrderId orderId;
    private final Product prodct;
}
