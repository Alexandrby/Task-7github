package com.senla.model;
import com.senla.comparators.VipOptionByPrice;
import com.senla.model.intf.VipGuestBasic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.sort;

public class VipGuest implements VipGuestBasic, Serializable {
    private String guestName;
    private ArrayList<VipOption> vipOption;
    private int  numberOfApartment;
    private LocalDate startRental;
    private LocalDate endRental;
    private long periodRental;
    private int id;
    private String type;

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
        return vipOption;
    }

    @Override
    public void setVipOption(ArrayList<VipOption> vipOption) {
        this.vipOption = vipOption;
    }

    @Override
    public int getNumberOfApartment() {
        return numberOfApartment;
    }

    @Override
    public void setNumberOfApartment(int numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
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
    // List of services and prices(sort by price)
     @Override
    public void getListOptions(VipGuest vipGuest){
       sort(vipGuest.vipOption, new VipOptionByPrice());
        for (VipOption vipOption :vipGuest.vipOption) {
            System.out.println( vipOption.getNameOfOption() + " " + vipOption.getPricePerOption());
        }
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
        return "Vip";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VipGuest{" +
                "guestName='" + guestName + '\'' +
                ", vipOption=" + vipOption +
                ", numberOfApartment=" + numberOfApartment +
                ", startRental=" + startRental +
                ", endRental=" + endRental +
           //     ", periodRental=" + periodRental +
          //      ", id=" + id +
          //      ", type='" + type + '\'' +
                '}';
    }
}
