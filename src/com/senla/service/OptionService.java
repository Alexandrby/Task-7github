package com.senla.service;
import com.senla.factory.intf.Option;
import com.senla.repository.OptionCSVRepository;
import com.senla.repository.OptionRepository;
import com.senla.repository.RepositoryBasis;
import com.senla.repository.SerialRepositoryOption;
import com.senla.serial.Serialization;
import com.senla.service.intf.OptionServiceBasic;
import java.io.IOException;
import java.util.ArrayList;

public class OptionService implements OptionServiceBasic <Option, String> {
    private RepositoryBasis repositoryBasis;
    private OptionCSVRepository optionCSVRepository;
    private SerialRepositoryOption serialRepositoryOption;

    public OptionService(OptionRepository optionRepository) {
        this.repositoryBasis = optionRepository;
        this.optionCSVRepository = new OptionCSVRepository(optionRepository);
        this.serialRepositoryOption = new SerialRepositoryOption(new Serialization());
    }

    public void createListHotelOption() throws IOException {
        repositoryBasis.addTestList();
    }

    @Override
    public void readAllCSVOption() throws IOException {
        optionCSVRepository.readAll();
    }

    @Override
    public void createHotelOption(Option option)  {
        try {
            repositoryBasis.create(option);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Услуга" + option.getNameOfOption() + " успешно занесен в список услуг");
        try {
            serialRepositoryOption.create(option);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Проблема с записью(сериализацией) сущности");
        }
    }

    @Override
    public void readOption(String nameOfOption) throws IOException {
        try {
            repositoryBasis.read(nameOfOption);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHotelOption(Option option) {
        repositoryBasis.update(option);
    }

    @Override
    public ArrayList<Option> readHotelOptions() throws IOException {
        return repositoryBasis.readAll();
    }

    @Override
    public void deleteHotelOption(String nameOfOption){
        repositoryBasis.delete(nameOfOption);
    }

    @Override
    public void importHotelOption(String id) throws IOException,IndexOutOfBoundsException  {
        optionCSVRepository.read(id);
    }

    @Override
    public void exportHotelOption(String nameOfOption) throws IOException,NumberFormatException {
        try {
            optionCSVRepository.create((Option) repositoryBasis.read(nameOfOption));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
