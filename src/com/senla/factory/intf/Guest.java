package com.senla.factory.intf;

import com.senla.model.VipOption;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Guest {

     String getGuestName();

     void setGuestName(String guestName);

     ArrayList<VipOption> getVipOption();

     void setVipOption(ArrayList<VipOption> vipOption);

     int getNumberOfApartment();

     void setNumberOfApartment(int numberOfApartment);

     LocalDate getStartRental();

     void setStartRental(LocalDate startRental);

     LocalDate getEndRental();

     void setEndRental(LocalDate endRental);

     long getPeriodRental();

     void setPeriodRental(long periodRental);

     int getId();

     void setId(int id);

     String getType();

     void setType(String type);



}
