package com.marks.finance.moneyinthepocket.core.exceptions;

/**
 * Created by Alexander on 9/3/2016.
 */
public class CurrencyException extends Exception {
    public CurrencyException() {
    }

    public CurrencyException(String message) {
        super(message);
    }

    public CurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyException(Throwable cause) {
        super(cause);
    }

}
