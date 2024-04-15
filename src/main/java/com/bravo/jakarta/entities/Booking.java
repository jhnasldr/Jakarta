package com.bravo.jakarta.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {
    @Id
    private Long id;
    @Column(nullable = false)
    private LocalDateTime from;
    @Column(nullable = false)
    private LocalDateTime till;
    @ManyToOne(targetEntity = Car.class, cascade = CascadeType.MERGE, optional = false)
    private Car car;
    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    private Customer customer;

    public Booking() {
    }

    public Booking(LocalDateTime from, LocalDateTime till, Car car, Customer customer) {
        this.from = from;
        this.till = till;
        this.car = car;
        this.customer = customer;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTill() {
        return till;
    }

    public void setTill(LocalDateTime till) {
        this.till = till;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
