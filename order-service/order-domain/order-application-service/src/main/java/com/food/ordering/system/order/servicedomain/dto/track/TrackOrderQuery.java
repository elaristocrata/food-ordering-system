package com.food.ordering.system.order.servicedomain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
@Builder
public class TrackOrderQuery {
    private final UUID orderTrackingId;
}
