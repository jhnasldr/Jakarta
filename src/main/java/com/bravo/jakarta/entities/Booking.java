package com.bravo.jakarta.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime starts;
    @Column(nullable = false)
    private LocalDateTime ends;
    @JsonIgnoreProperties("bookings")
    @ManyToOne(targetEntity = Car.class, cascade = CascadeType.MERGE, optional = false)
    private Car car;
    @JsonIgnoreProperties("bookings")
    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    private Customer customer;

    public Booking() {
    }

    public Booking(LocalDateTime starts, LocalDateTime ends, Car car, Customer customer) {
        this.starts = starts;
        this.ends = ends;
        this.car = car;
        this.customer = customer;
    }

    public LocalDateTime getStarts() {
        return starts;
    }

    public void setStarts(LocalDateTime starts) {
        this.starts = starts;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
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
