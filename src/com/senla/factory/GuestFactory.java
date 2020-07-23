package com.senla.factory;

import com.senla.factory.intf.Guest;
import com.senla.model.OrdinaryGuest;
import com.senla.model.VipGuest;

public enum  GuestFactory {

    VIP {
        public Guest create(){
            return new VipGuest();
        }
    },
    ORDINARY {
        public Guest create(){
            return new OrdinaryGuest();
        }
    };
    public abstract Guest create();
}

