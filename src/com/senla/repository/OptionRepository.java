package com.senla.repository;
import com.senla.factory.intf.Option;
import com.senla.factory.OptionFactory;

import java.io.IOException;
import java.util.ArrayList;

public class OptionRepository implements RepositoryBasis<Option, String> {

    public ArrayList<Option> optionsList = new ArrayList<>();

    @Override
    public Option create(Option option) {
        optionsList.add(option);
        return option;
    }

    @Override
    public Option read(String nameOfOption) {
        for (Option option : optionsList) {
            if (option.getNameOfOption().equalsIgnoreCase(nameOfOption))
                return option;
        }
        return null;
    }

    @Override
    public Option update(Option option) {
        for (Option options : optionsList){
            options=option;
        }
        return option;
    }

     @Override
    public void delete (String nameOfOption) {
        int count=0;
        for (int i=0; i<optionsList.size(); i++) {
             if (optionsList.get(i).getNameOfOption().equals(nameOfOption)){
                 optionsList.remove(optionsList.get(i));
                 count++;
                 System.out.println("Услуга " + nameOfOption + " удалена");
             }
         }
         if (count==0){
             System.out.println("Услуги " +  "\"" + nameOfOption + "\"" + " нет в списках услуг");
         }

    }

    @Override
    public ArrayList<Option> createAll(String string) {
        return optionsList;
    }

    @Override
    public ArrayList<Option> readAll() {
        return optionsList;
    }

    public void addTestList() {
        Option option1 = OptionFactory.ORDINARY.create();
        option1.setNameOfOption("Hot water");
        option1.setPricePerOption(7);
        optionsList.add(option1);

        Option option2 = OptionFactory.ORDINARY.create();
        option2.setNameOfOption("Gym");
        option2.setPricePerOption(5);
        optionsList.add(option2);

        Option option3 = OptionFactory.ORDINARY.create();
        option3.setNameOfOption("TV");
        option3.setPricePerOption(10);
        optionsList.add(option3);

        Option option4 = OptionFactory.ORDINARY.create();
        option4.setNameOfOption("Dinner");
        option4.setPricePerOption(7);
        optionsList.add(option4);

        Option vipOption = OptionFactory.VIP.create();
        vipOption.setNameOfOption("Massage");
        vipOption.setPricePerOption(22);
        optionsList.add(vipOption);

        Option vipOption2 = OptionFactory.VIP.create();
        vipOption2.setNameOfOption("Alcohol");
        vipOption2.setPricePerOption(20);
        optionsList.add(vipOption2);

        Option vipOption3 = OptionFactory.VIP.create();
        vipOption3.setNameOfOption("SPA");
        vipOption3.setPricePerOption(25);
        optionsList.add(vipOption3);
    }
}




