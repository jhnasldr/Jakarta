package com.bravo.jakarta.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int dailyCost = 500;
    @Column(length = 20)
    private String brand;
    @Column(length = 30)
    private String model;
    @Column(length = 10, nullable = false)
    private String plateNumber;
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Booking> bookings;

    public Car() {
    }

    public Car(int id, int dailyCost, String brand, String model, String plateNumber, List<Booking> bookings) {
        this.id = id;
        this.dailyCost = dailyCost;
        this.brand = brand;
        this.model = model;
        this.plateNumber = plateNumber;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
