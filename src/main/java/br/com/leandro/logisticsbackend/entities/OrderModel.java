package br.com.leandro.logisticsbackend.entities;

import br.com.leandro.logisticsbackend.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID",unique = false )
    private List<OrderItem> orderItems;

    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public OrderModel() {
    }

    public OrderModel(List<OrderItem> orderItems, BigDecimal totalPrice, OrderStatus status) {
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", products=" + orderItems +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }
}
