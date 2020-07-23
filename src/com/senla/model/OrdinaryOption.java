package com.senla.model;

import com.senla.factory.intf.Option;

import java.io.Serializable;

public class OrdinaryOption implements Option, Serializable {
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
        return "ORDINARY";
    }

    @Override
    public void setType(String type) {
    this.type = type;
    }

    @Override
    public String toString() {
        return "OrdinaryOption { " +
                "nameOfOption='" + nameOfOption + '\'' +
                ", pricePerOption=" + pricePerOption +
            //    ", id=" + id +
            //    ", type='" + type + '\'' +
                " }";
    }
}
