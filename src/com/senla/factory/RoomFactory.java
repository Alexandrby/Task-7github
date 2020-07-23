package com.senla.factory;

import com.senla.factory.intf.Room;
import com.senla.model.OrdinaryRoom;
import com.senla.model.VipRoom;

public enum RoomFactory {
    VIP {
        public Room create(){
            return new VipRoom();
        }
    },
    ORDINARY {
        public Room create(){
            return new OrdinaryRoom();
        }
    };
    public abstract Room create();
}



