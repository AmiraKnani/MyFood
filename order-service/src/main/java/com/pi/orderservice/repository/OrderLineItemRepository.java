package com.pi.orderservice.repository;

import com.pi.orderservice.model.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
    List<OrderLineItem> findByOrderId(Long orderId);
}
