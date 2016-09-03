package com.marks.finance.moneyinthepocket.core.interfaces;

import com.marks.finance.moneyinthepocket.core.exceptions.AmountException;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 8/30/2016.
 */
public interface Storage {

    String getName();

    //get balance
    Map<Currency, BigDecimal> getCurrencyAmounts();
    BigDecimal getAmount(Currency currency) throws CurrencyException;
    BigDecimal getApproxAmount(Currency currency) throws CurrencyException;

    // change balance
    void changeAmount (BigDecimal amount, Currency currency)throws CurrencyException;
    void addAmount(BigDecimal amount, Currency currency)throws CurrencyException;
    void expenseAmount(BigDecimal amount, Currency currency)throws CurrencyException, AmountException;

    //work with currency
    void addCurrency(Currency currency) throws CurrencyException;
    void deleteCurrency(Currency currency) throws CurrencyException;
    Currency getCurrency(String code) throws CurrencyException;
    List<Currency> getAvailableCurrencies();

}
