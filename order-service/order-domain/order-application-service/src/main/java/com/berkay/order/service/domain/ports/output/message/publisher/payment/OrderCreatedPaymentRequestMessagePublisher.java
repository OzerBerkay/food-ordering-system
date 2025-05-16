package com.berkay.order.service.domain.ports.output.message.publisher.payment;

import com.berkay.domain.event.publisher.DomainEventPublisher;
import com.berkay.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
