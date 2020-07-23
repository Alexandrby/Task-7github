package com.senla.model.intf;

import java.time.LocalDate;

public interface HotelDateBasic {

    public LocalDate getStartRental();

    public void setStartRental(LocalDate startRental);

    public LocalDate getEndRental();

    public void setEndRental(LocalDate endRental) ;

    public long getPeriodRental();

    public void setPeriodRental(long periodRental);
}
