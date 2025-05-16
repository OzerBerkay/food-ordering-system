package com.berkay.domain.event.publisher;

import com.berkay.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish (T domainEvent);
}
