package com.marks.finance.moneyinthepocket.core.exceptions;

/**
 * Created by Alexander on 9/3/2016.
 */
public class AmountException extends Exception {
    public AmountException() {
    }

    public AmountException(String message) {
        super(message);
    }

    public AmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountException(Throwable cause) {
        super(cause);
    }
}
