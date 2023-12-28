package com.pi.kitchenservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lineitem")
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "quantite")
    private Integer quantite;
    
    @Column(name = "idMenu")
    private Long idMenu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LineItem() {
    }

    public LineItem(Integer quantite, Long idMenu, Ticket ticket) {
        this.quantite = quantite;
        this.idMenu = idMenu;
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
        result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
        result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
        LineItem other = (LineItem) obj;
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
        if (ticket == null) {
            if (other.ticket != null)
                return false;
        } else if (!ticket.equals(other.ticket))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LineItem [id=" + id + ", quantite=" + quantite + ", idMenu=" + idMenu + ", ticket=" + ticket + "]";
    }

    
}
