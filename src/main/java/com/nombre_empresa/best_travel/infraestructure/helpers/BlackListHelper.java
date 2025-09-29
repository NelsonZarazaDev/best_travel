package com.nombre_empresa.best_travel.infraestructure.helpers;

import com.nombre_empresa.best_travel.util.exception.ForBiddenCustomerException;
import org.springframework.stereotype.Component;

@Component
public class BlackListHelper {
    public void isInBlackListCustomer(String customerId){
        if (customerId.equals("GOTW771012HMRGR087")){
            throw new ForBiddenCustomerException();
        }
    }
}
