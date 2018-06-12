package com.fjianc.ssm.exception;

import com.fjianc.ssm.enums.ProductStateEnum;

public class ProductException extends RuntimeException{

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public String ProductException(ProductStateEnum stateEnum) {
        return stateEnum.getStateInfo();
    }

}
