package com.berkay.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.berkay.domain.event.publisher.DomainEventPublisher;
import com.berkay.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestPublisher extends DomainEventPublisher<OrderPaidEvent> {
}
