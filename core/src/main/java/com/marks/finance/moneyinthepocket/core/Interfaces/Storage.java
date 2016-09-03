package com.marks.finance.moneyinthepocket.core.Interfaces;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Alexander on 8/30/2016.
 */
public interface Storage {

    String getName();

    //get balance
    Map<Currency, BigDecimal> getCurrencyAmounts();
    BigDecimal getAmount(Currency currency);
    BigDecimal getApproxAmount(Currency currency);

    // change balance
    void changeAmount (BigDecimal amount, Currency currency);
    void addAmount(BigDecimal amount, Currency currency);
    void expenseAmount(BigDecimal amount, Currency currency);

    //work with currency
    void addCurrency(Currency currency);
    void deleteCurrency(Currency currency);
    Currency getCurrency(String code);
    List<Currency> getAvailableCurrenies();

}
