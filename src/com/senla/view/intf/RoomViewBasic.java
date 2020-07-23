package com.senla.view.intf;

import com.senla.factory.intf.Room;

public interface RoomViewBasic {

    Room createRoom();

    int deleteRoom();

    int changeStatus ();

    int executeChoice();
}
