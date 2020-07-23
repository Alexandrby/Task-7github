package com.senla.model;
import com.senla.comparators.OrdinaryOptionByPrice;
import com.senla.factory.intf.Option;
import com.senla.model.intf.OrdinaryGuestBasic;
import com.senla.serial.Serialization;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.sort;

public class OrdinaryGuest implements OrdinaryGuestBasic, Serializable {
    private String guestName;
    private ArrayList<Option> options;
    private int  NumberOfApartment;
    private LocalDate startRental;
    private LocalDate endRental;
    private long periodRental;
    private int id;
    private String type;

    public OrdinaryGuest() {}

    @Override
    public String getGuestName() {
        return guestName;
    }

    @Override
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public ArrayList<VipOption> getVipOption() {
        return null;
    }

    @Override
    public void setVipOption(ArrayList<VipOption> vipOption) {
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    public int getNumberOfApartment() {
        return NumberOfApartment;
    }

    @Override
    public void setNumberOfApartment(int numberOfApartment) {
        NumberOfApartment = numberOfApartment;
    }

    @Override
    public LocalDate getStartRental() {
        return startRental;
    }

    @Override
    public void setStartRental(LocalDate startRental) {
        this.startRental = startRental;
    }

    @Override
    public LocalDate getEndRental() {
        return endRental;
    }

    @Override
    public void setEndRental(LocalDate endRental) {
        this.endRental = endRental;
    }

    @Override
    public long getPeriodRental() {
        return periodRental;
    }

    @Override
    public void setPeriodRental(long periodRental) {
        this.periodRental = periodRental;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getType() {
        return "Ordinary";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    // List of services and prices(sort by price)
    @Override
    public void getListOptions(OrdinaryGuest ordinaryGuest) {
        sort(ordinaryGuest.options, new OrdinaryOptionByPrice());
        for (Option option :ordinaryGuest.options) {
            System.out.println( option.getNameOfOption() + " " + option.getPricePerOption());
        }
    }


    @Override
    public String toString() {
        return "OrdinaryGuest{" +
                "guestName='" + guestName + '\'' +
                ", options=" + options +
                ", NumberOfApartment=" + NumberOfApartment +
                ", startRental=" + startRental +
                ", endRental=" + endRental +
           //     ", periodRental=" + periodRental +
           //     ", id=" + id +
          //      ", type='" + type + '\'' +
                '}';
    }
}
