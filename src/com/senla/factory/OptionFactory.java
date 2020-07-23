package com.senla.factory;
import com.senla.factory.intf.Option;
import com.senla.model.OrdinaryOption;
import com.senla.model.VipOption;

public enum OptionFactory {
    VIP {
        public Option create(){
            return new VipOption();
        }
    },
    ORDINARY {
        public Option create(){
            return new OrdinaryOption();
        }
    };
    public abstract Option create();
}



