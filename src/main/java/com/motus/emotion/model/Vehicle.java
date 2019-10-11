package com.motus.emotion.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "model must be set ")
    @Column(nullable = false)
    private String model;

    @NotNull(message = "brand must be set ")
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    @NotNull(message = "type must be set ")
    private String type;

    @Column(nullable = false)
    @NotNull(message = "category must be set ")
    private String category;

    @Column(nullable = false)
    @NotNull(message = "color must be set ")
    private String color;

    @Column(nullable = false)
    @NotNull(message = "serial number must be set ")
    private int serialNumber;

    @Column(nullable = false)
    @NotNull(message = "registering must be set ")
    private String registering;

    @Column(nullable = false)
    @NotNull(message = "available must be set ")
    private boolean available;

    @Column(nullable = false)
    @NotNull(message = "purchaseDate must be set ")
    private Date purchaseDate;

    @Column(nullable = false)
    @NotNull(message = "purchasePrice must be set ")
    private double purchasePrice;

    @Column(nullable = false)
    @NotNull(message = "placeNumber must be set ")
    private int placeNumber;

    @Column(nullable = false)
    @NotNull(message = "kilometers must be set ")
    private int kilometers;

    @Column(nullable = false)
    @NotNull(message = "state must be set ")
    private String state;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String type, String category, String color, int serialNumber, String registering
            , boolean available, double purchasePrice, int placeNumber, int kilometers, String state) {
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.category = category;
        this.color = color;
        this.serialNumber = serialNumber;
        this.registering = registering;
        this.available = available;
        this.purchaseDate = new Date();
        this.purchasePrice = purchasePrice;
        this.placeNumber = placeNumber;
        this.kilometers = kilometers;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRegistering() {
        return registering;
    }

    public void setRegistering(String registering) {
        this.registering = registering;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String[] getState() {
        String[] stateSplited = state.split(" , ");
        return stateSplited;
    }

    public void setState(String[] state) {
        this.state = String.join(" , ", state);
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", serialNumber=" + serialNumber +
                ", registering='" + registering + '\'' +
                ", available=" + available +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", placeNumber=" + placeNumber +
                ", kilometers=" + kilometers +
                ", state=" + state +
                '}';
    }
}
