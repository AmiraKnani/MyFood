package com.pi.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_info")
public class DeliveryInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer deliveryTime;
    private String deliveryAddress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryInfo(Integer deliveryTime, String deliveryAddress, Order order) {
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.order = order;
    }

    public DeliveryInfo() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
        result = prime * result + ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeliveryInfo other = (DeliveryInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (deliveryTime == null) {
            if (other.deliveryTime != null)
                return false;
        } else if (!deliveryTime.equals(other.deliveryTime))
            return false;
        if (deliveryAddress == null) {
            if (other.deliveryAddress != null)
                return false;
        } else if (!deliveryAddress.equals(other.deliveryAddress))
            return false;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeliveryInfo [id=" + id + ", deliveryTime=" + deliveryTime + ", deliveryAddress=" + deliveryAddress
                + ", order=" + order + "]";
    }


}
