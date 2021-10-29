package br.com.leandro.logisticsbackend.entities;

import javax.persistence.*;

@Entity
public class InventoryPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    private Integer availableQuantity;
    private Integer reserveQuantity;

    public InventoryPosition() {
    }

    public InventoryPosition(Product product, Integer availableQuantity, Integer reserveQuantity) {
        this.product = product;
        this.availableQuantity = availableQuantity;
        this.reserveQuantity = reserveQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getReserveQuantity() {
        return reserveQuantity;
    }

    public void setReserveQuantity(Integer reserveQuantity) {
        this.reserveQuantity = reserveQuantity;
    }

    @Override
    public String toString() {
        return "InventoryPosition{" +
                "id=" + id +
                ", availableQuantity=" + availableQuantity +
                ", reserveQuantity=" + reserveQuantity +
                '}';
    }
}
