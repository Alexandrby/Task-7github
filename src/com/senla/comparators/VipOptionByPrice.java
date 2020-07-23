package com.senla.comparators;

import com.senla.model.VipOption;

import java.util.Comparator;

public class VipOptionByPrice implements Comparator<VipOption> {
    @Override
    public int compare(VipOption vipOption1, VipOption vipOption2) {
        return (int) (vipOption1.getPricePerOption()- vipOption2.getPricePerOption());
    }
}
