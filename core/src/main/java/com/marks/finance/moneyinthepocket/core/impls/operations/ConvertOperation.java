package com.marks.finance.moneyinthepocket.core.impls.operations;

import com.marks.finance.moneyinthepocket.core.abstrects.AbstractOperation;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class ConvertOperation extends AbstractOperation{

    private Storage fromStorage;
    private Storage toStorage;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private Currency fromCurrency;
    private Currency toCurrency;

    public ConvertOperation(long id, Calendar dateTime, String getInfo, Storage fromStorage, Storage toStorage, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        super(id, dateTime, getInfo);
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public ConvertOperation(long id, Storage fromStorage, Storage toStorage, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        super(id);
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public ConvertOperation(Storage fromStorage, Storage toStorage, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
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

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }
}
