package com.pi.orderservice.repository;

import com.pi.orderservice.model.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long> {
    DeliveryInfo findByOrderId(Long orderId);
}
