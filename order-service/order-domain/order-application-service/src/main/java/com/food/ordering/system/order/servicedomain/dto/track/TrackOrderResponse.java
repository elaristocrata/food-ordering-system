package com.food.ordering.system.order.servicedomain.dto.track;

import com.food.ordering.system.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class TrackOrderResponse {
    @NonNull
    public final UUID orderTrackingId;
    @NonNull
    public final OrderStatus orderStatus;
    public final List<String> failureMessages;
}
