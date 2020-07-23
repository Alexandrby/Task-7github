package com.senla.model.intf;

import com.senla.factory.intf.Guest;
import com.senla.model.OrdinaryGuest;

public interface OrdinaryGuestBasic extends Guest {

     void getListOptions(OrdinaryGuest ordinaryGuest);
}
