package com.marks.finance.moneyinthepocket.core.Impls;

import com.marks.finance.moneyinthepocket.core.Interfaces.Storage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;

/**
 * Created by Alexander on 9/3/2016.
 */
public class DefaultStorage implements Storage{

    private String name;

    private Map<Currency, BigDecimal> currencyAmounts = new HashMap<>();
    private List<Currency> curencyList = new ArrayList<>();

    @Override
    public List<Currency> getAvailableCurrenies() {
        return curencyList;
    }

    public void setAvailableCurrenies(List<Currency> availableCurrenies) {
        this.curencyList = availableCurrenies;
    }

    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {
        return currencyAmounts;
    }

    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  BigDecimal getAmount(Currency currency){
        return currencyAmounts.get(currency);
    }

    //Update balance by hand
    @Override
    public void changeAmount(BigDecimal amount, Currency currency){
        currencyAmounts.put(currency, amount);
    }

    // add money to the storage
    @Override
    public  void  addAmount(BigDecimal amount, Currency currency){
        BigDecimal oldAmount = currencyAmounts.get(currency);
        currencyAmounts.put(currency, oldAmount.add(amount));
    }

    // take money from the storage
    @Override
    public  void  expenseAmount(BigDecimal amount, Currency currency){
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newValue = oldAmount.subtract(amount);
        currencyAmounts.put(currency, newValue);
    }

    //work with currency

    @Override
    public  void  addCurrency (Currency currency){
        curencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public  void deleteCurrency(Currency currency){
        currencyAmounts.remove(currency);
        curencyList.remove(currency);
    }

    @Override
    public  BigDecimal getApproxAmount(Currency currency){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Currency getCurrency(String code){

        for (Currency currency: curencyList
             ) {
            if(currency.getCurrencyCode().equals(code)){
                return currency;
            }

        }
        return null;
    }

}
