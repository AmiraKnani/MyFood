package com.pi.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_line_items")
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;
    private Long idMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderLineItem(Integer quantite, Long idMenu, Order order) {
        this.quantite = quantite;
        this.idMenu = idMenu;
        this.order = order;
    }

    public OrderLineItem() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
        result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
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
        OrderLineItem other = (OrderLineItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (quantite == null) {
            if (other.quantite != null)
                return false;
        } else if (!quantite.equals(other.quantite))
            return false;
        if (idMenu == null) {
            if (other.idMenu != null)
                return false;
        } else if (!idMenu.equals(other.idMenu))
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
        return "OrderLineItem [id=" + id + ", quantite=" + quantite + ", idMenu=" + idMenu + ", order=" + order + "]";
    }



}
