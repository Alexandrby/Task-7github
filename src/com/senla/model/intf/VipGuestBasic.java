package com.senla.model.intf;

import com.senla.factory.intf.Guest;
import com.senla.model.VipGuest;

public interface VipGuestBasic extends Guest {

    public void getListOptions(VipGuest vipGuest);

}
