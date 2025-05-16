package com.berkay.order.service.domain;

import com.berkay.order.service.domain.dto.message.RestaurantAprovalResponse;
import com.berkay.order.service.domain.ports.input.message.listener.restaurantapproval.RestaurantApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {
    @Override
    public void orderApproved(RestaurantAprovalResponse restaurantAprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantAprovalResponse restaurantAprovalResponse) {

    }
}
