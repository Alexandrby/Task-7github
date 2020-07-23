package com.senla.comparators;

import com.senla.factory.intf.Option;

import java.util.Comparator;

public class OrdinaryOptionByPrice implements Comparator<Option> {

    @Override
    public int compare(Option o1, Option o2) {
        return (int) (o1.getPricePerOption()-o2.getPricePerOption());
    }
}
