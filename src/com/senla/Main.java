package com.senla;
import com.senla.controller.GuestController;
import com.senla.controller.MainController;
import com.senla.controller.OptionController;
import com.senla.controller.RoomController;
import com.senla.repository.*;
import com.senla.serial.Serialization;
import com.senla.service.GuestService;
import com.senla.service.OptionService;
import com.senla.service.RoomService;
import com.senla.view.GuestView;
import com.senla.view.OptionView;
import com.senla.view.RoomView;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialRepositoryGuest serialRepositoryGuest = new SerialRepositoryGuest(new Serialization());
        SerialRepositoryRoom serialRepositoryRoom = new SerialRepositoryRoom(new Serialization());
        SerialRepositoryOption serialRepositoryOption = new SerialRepositoryOption(new Serialization());
        GuestRepository guestRepository = new GuestRepository();
        RoomRepository roomRepository = new RoomRepository();
        OptionRepository optionRepository = new OptionRepository();
//      EntityCSV guestCSV = new EntityCSV();132
        guestRepository.addTestList();
        optionRepository.addTestList();
        roomRepository.addTestList();
        MainController mainController = new MainController(new GuestController(new GuestService(guestRepository), new GuestView()),
        new RoomController(new RoomService(roomRepository),new RoomView()),new OptionController(new OptionService(optionRepository),new OptionView()));

        mainController.execute();

        System.out.println(serialRepositoryGuest.read("text"));
//        System.out.println(serialRepositoryRoom.read(0));
//        System.out.println(serialRepositoryOption.read("text"));
    }
}