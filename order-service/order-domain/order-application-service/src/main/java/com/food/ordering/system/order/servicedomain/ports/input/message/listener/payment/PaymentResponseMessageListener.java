package com.food.ordering.system.order.servicedomain.ports.input.message.listener.payment;

import com.food.ordering.system.order.servicedomain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
