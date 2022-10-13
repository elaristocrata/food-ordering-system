package com.food.ordering.system.order.servicedomain.ports;

import com.food.ordering.system.order.service.domain.OrderServiceDomain;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.servicedomain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.servicedomain.mapper.OrderDataMapper;
import com.food.ordering.system.order.servicedomain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.servicedomain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.servicedomain.ports.output.repository.RestaurantRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public class OrderCreateCommandHandler {
    private final OrderServiceDomain orderServiceDomain;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateCommandHandler(OrderServiceDomain orderServiceDomain, OrderRepository orderRepository,
                                     CustomerRepository customerRepository, RestaurantRepository restaurantRepository,
                                     OrderDataMapper orderDataMapper) {
        this.orderServiceDomain = orderServiceDomain;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderServiceDomain.validateAndInitiateOrder(order, restaurant);
        Order orderResult = orderSave(order);
        return orderDataMapper.orderToCreateOrderResponse(orderResult,"OrderCreated");
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if (optionalRestaurant.isEmpty()) {
            throw new OrderDomainException("Restaurant not found");
        }
        return optionalRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            throw new OrderDomainException("Could not find customer");
        }
    }

    private Order orderSave(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            throw new OrderDomainException("Could not save order!");
        }
        return orderResult;
    }

}
