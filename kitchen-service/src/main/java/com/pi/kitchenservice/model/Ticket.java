package com.pi.kitchenservice.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "restaurantId")
    private Long restaurantId;
    
    @Column(name = "preparingTime")
    private Integer preparingTime;
    
    @Column(name = "pickedUpTime")
    private Integer pickedUpTime;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LineItem> lineItems;

    public Long getId() {
        return id;
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getPreparingTime() {
        return preparingTime;
    }

    public void setPreparingTime(Integer preparingTime) {
        this.preparingTime = preparingTime;
    }

    public Integer getPickedUpTime() {
        return pickedUpTime;
    }

    public void setPickedUpTime(Integer pickedUpTime) {
        this.pickedUpTime = pickedUpTime;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Ticket() {
    }

    public Ticket(String state, Long restaurantId, Integer preparingTime, Integer pickedUpTime,
            Set<LineItem> lineItems) {
        this.state = state;
        this.restaurantId = restaurantId;
        this.preparingTime = preparingTime;
        this.pickedUpTime = pickedUpTime;
        this.lineItems = lineItems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
        result = prime * result + ((preparingTime == null) ? 0 : preparingTime.hashCode());
        result = prime * result + ((pickedUpTime == null) ? 0 : pickedUpTime.hashCode());
        result = prime * result + ((lineItems == null) ? 0 : lineItems.hashCode());
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
        Ticket other = (Ticket) obj;
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
        if (restaurantId == null) {
            if (other.restaurantId != null)
                return false;
        } else if (!restaurantId.equals(other.restaurantId))
            return false;
        if (preparingTime == null) {
            if (other.preparingTime != null)
                return false;
        } else if (!preparingTime.equals(other.preparingTime))
            return false;
        if (pickedUpTime == null) {
            if (other.pickedUpTime != null)
                return false;
        } else if (!pickedUpTime.equals(other.pickedUpTime))
            return false;
        if (lineItems == null) {
            if (other.lineItems != null)
                return false;
        } else if (!lineItems.equals(other.lineItems))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", state=" + state + ", restaurantId=" + restaurantId + ", preparingTime="
                + preparingTime + ", pickedUpTime=" + pickedUpTime + ", lineItems=" + lineItems + "]";
    }

    
}
