package com.food.ordering.system.order.servicedomain.ports.output.repository.message.publisher.payment;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.event.OrderCancelEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelEvent> {
}
