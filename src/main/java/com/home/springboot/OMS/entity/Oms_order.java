package com.home.springboot.OMS.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "oms_order")
public class Oms_order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "creation_time")
    @Temporal(TemporalType.DATE)
    private Date creation_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private Oms_user oms_user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Oms_order() {
    }

    public Oms_order(Date creation_time) {

        this.creation_time = creation_time;
    }


    public Oms_order(Date creation_time, Oms_user oms_user, List<Product> products) {
        super();
        this.creation_time = creation_time;
        this.oms_user = oms_user;
        this.products = products;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Oms_user getOms_user() {
        return oms_user;
    }

    public void setOms_user(Oms_user oms_user) {
        this.oms_user = oms_user;
    }

    public void addProduct(Product theProduct) {

        if (products == null) {
            products = new ArrayList<>();
        }

        products.add(theProduct);
    }

    @Override
    public String toString() {
        return "Oms_order [order_id=" + order_id + ", products=" + products + ", creation_time=" + creation_time
                + ", oms_user=" + oms_user + "]";
    }

}
