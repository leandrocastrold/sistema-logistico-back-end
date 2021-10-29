package br.com.leandro.logisticsbackend.entities;

import br.com.leandro.logisticsbackend.enums.ProductType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @OneToOne(mappedBy = "product")
    private InventoryPosition position;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, ProductType type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

//    public InventoryPosition getPosition() {
//        return position;
//    }
//
//    public void setPosition(InventoryPosition position) {
//        this.position = position;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && getType() == product.getType() && Objects.equals(position, product.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getType(), position);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
