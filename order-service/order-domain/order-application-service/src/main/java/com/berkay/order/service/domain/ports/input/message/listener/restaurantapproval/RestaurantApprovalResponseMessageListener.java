package com.berkay.order.service.domain.ports.input.message.listener.restaurantapproval;

import com.berkay.order.service.domain.dto.message.RestaurantAprovalResponse;

public interface RestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantAprovalResponse restaurantAprovalResponse);

    void orderRejected(RestaurantAprovalResponse restaurantAprovalResponse);
}
