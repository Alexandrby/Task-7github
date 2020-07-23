package com.senla.model;

import com.senla.factory.intf.Option;

import java.io.Serializable;

public class VipOption implements Option, Serializable {
    private String nameOfOption;
    private double pricePerOption;
    private int id;
    private String type;


    @Override
    public String getNameOfOption() {
        return nameOfOption;
    }

    @Override
    public void setNameOfOption(String nameOfOption) {
        this.nameOfOption = nameOfOption;
    }

    @Override
    public double getPricePerOption() {
        return pricePerOption;
    }

    @Override
    public void setPricePerOption(double pricePerOption) {
        this.pricePerOption = pricePerOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return "VIP";
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VipOption { " +
                "nameOfOption='" + nameOfOption + '\'' +
                ", pricePerOption=" + pricePerOption +
             //   ", id=" + id +
             //   ", type='" + type + '\'' +
                " }";
    }
}
