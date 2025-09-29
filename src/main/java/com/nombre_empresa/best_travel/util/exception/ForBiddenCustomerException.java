package com.nombre_empresa.best_travel.util.exception;

public class ForBiddenCustomerException extends RuntimeException{

    public ForBiddenCustomerException(){
        super("this customer is blocket");
    }
}
