package com.food.ordering.system.order.servicedomain.ports.input.service;

import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.servicedomain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.servicedomain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
