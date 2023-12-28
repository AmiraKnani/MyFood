package com.pi.orderservice.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "`order`") 
public class Order {
    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }
    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }
    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderLineItem> orderLineItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DeliveryInfo deliveryInfo;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((consumerId == null) ? 0 : consumerId.hashCode());
        result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
        return result;
    }
    public Order() {
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (consumerId == null) {
            if (other.consumerId != null)
                return false;
        } else if (!consumerId.equals(other.consumerId))
            return false;
        if (restaurantId == null) {
            if (other.restaurantId != null)
                return false;
        } else if (!restaurantId.equals(other.restaurantId))
            return false;
        return true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state; 
    public Long getId() {
        return id;
    }
    public Order(String state, Long consumerId, Long restaurantId) {
        this.state = state;
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", state=" + state + ", consumerId=" + consumerId + ", restaurantId=" + restaurantId
                + "]";
    }
    public Long getConsumerId() {
        return consumerId;
    }
    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    @Column(name = "consumer_id")
    private Long consumerId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    

}
