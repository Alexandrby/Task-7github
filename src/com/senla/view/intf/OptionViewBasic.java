package com.senla.view.intf;
import com.senla.factory.intf.Option;
import java.util.ArrayList;

public interface OptionViewBasic {

      Option createOption();

       String readOption();

      String deleteOption();

      int executeOption();

      int importOption();

      String exportOption();

      void printAllOption(ArrayList<Option> listAllHotelGuest);
}
