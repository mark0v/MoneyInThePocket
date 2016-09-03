package com.marks.finance.moneyinthepocket.core.impls.operations;

import com.marks.finance.moneyinthepocket.core.abstrects.AbstractOperation;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class TransferOperation extends AbstractOperation {

    private Storage fromStorage;
    private Storage toStorage;
    private BigDecimal amount;
    private Currency currency;

    public TransferOperation(long id, Calendar dateTime, String getInfo, Storage fromStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id, dateTime, getInfo);
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public TransferOperation(long id, Storage fromStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id);
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public TransferOperation(Storage fromStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
