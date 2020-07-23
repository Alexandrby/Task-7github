package com.senla.controller;
import com.senla.view.MainView;


public class MainController implements Controller {
    private GuestController guestController;
    private RoomController roomController;
    private OptionController optionController;
    private MainView mainView = new MainView();

    public MainController(GuestController guestController, RoomController roomController, OptionController optionController) {
        this.guestController = guestController;
        this.roomController = roomController;
        this.optionController = optionController;
    }

    public void execute()  {
        while (true) {
            int numberOfcase = mainView.executeChoice();
            {
                switch (numberOfcase) {
                    case 1:
                        guestController.execute();
                        break;
                    case 2:
                        roomController.execute();
                        break;
                    case 3:
                        optionController.execute();
                        break;
                    case 4:
                        return;
                    default:
                        mainView.errorSelect();
                }
            }
        }
    }
}
