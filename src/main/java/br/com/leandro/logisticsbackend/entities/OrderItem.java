package br.com.leandro.logisticsbackend.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", unique = false)
    private Product product;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID" )
    @Transient
    private OrderModel orderModel;

    private Integer quantity;
    private BigDecimal totalPrice;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity, BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderModel getOrder() {
        return orderModel;
    }

    public void setOrder(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
