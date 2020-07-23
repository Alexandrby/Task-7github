package com.senla.model;
import com.senla.factory.intf.Room;

import java.io.Serializable;

public class VipRoom implements Room, Serializable {
    private int numberOfRoom;
    private double pricePerRoom;
    private String status;
    private int star;
    private int capacityOfRoom;
    private String type;
    private int id;

    public VipRoom() {}

    @Override
    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    @Override
    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    @Override
    public double getPricePerRoom() {
        return pricePerRoom;
    }

    @Override
    public void setPrice(int price) {
        this.pricePerRoom = price;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getStar() {
        return star;
    }

    @Override
    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public int getCapacityOfRoom() {
        return capacityOfRoom;
    }

    @Override
    public void setCapacityOfRoom(int capacityOfRoom) {
        this.capacityOfRoom = capacityOfRoom;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
    this.id = id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VipRoom { " +
                "numberOfRoom=" + numberOfRoom +
                ", type=" + type +
                ", pricePerRoom=" + pricePerRoom +
                ", status='" + status + '\'' +
                ", capacityOfRoom=" + capacityOfRoom +
                ", star=" + star +
                " }";
    }
}



