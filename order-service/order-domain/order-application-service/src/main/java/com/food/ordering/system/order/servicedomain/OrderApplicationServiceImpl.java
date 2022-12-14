package com.food.ordering.system.order.servicedomain;

import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.servicedomain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.servicedomain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.servicedomain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
@Slf4j
@Validated
@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {
    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return null;
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return null;
    }
}
