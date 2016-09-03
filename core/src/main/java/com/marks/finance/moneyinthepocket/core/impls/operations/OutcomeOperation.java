package com.marks.finance.moneyinthepocket.core.impls.operations;

import com.marks.finance.moneyinthepocket.core.abstrects.AbstractOperation;
import com.marks.finance.moneyinthepocket.core.interfaces.Source;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class OutcomeOperation extends AbstractOperation {

    private Storage fromStorage;
    private Source toSource;
    private BigDecimal amount;
    private Currency currency;

    public OutcomeOperation(long id, Calendar dateTime, String getInfo, Storage fromStorage, Source toSource, BigDecimal amount, Currency currency) {
        super(id, dateTime, getInfo);
        this.fromStorage = fromStorage;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

    public OutcomeOperation(long id, Storage fromStorage, Source toSource, BigDecimal amount, Currency currency) {
        super(id);
        this.fromStorage = fromStorage;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

    public OutcomeOperation(Storage fromStorage, Source toSource, BigDecimal amount, Currency currency) {
        this.fromStorage = fromStorage;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }

    public Source getToSource() {
        return toSource;
    }

    public void setToSource(Source toSource) {
        this.toSource = toSource;
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
