package com.marks.finance.moneyinthepocket.core.impls;

import com.marks.finance.moneyinthepocket.core.abstrects.AbstractTreeNode;
import com.marks.finance.moneyinthepocket.core.exceptions.AmountException;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

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
public class DefaultStorage extends AbstractTreeNode implements Storage{


    private Map<Currency, BigDecimal> currencyAmounts = new HashMap<>();
    private List<Currency> currencyList = new ArrayList<>();


    public DefaultStorage(){}


    public DefaultStorage(String name) {
        super(name);
    }

    public DefaultStorage(String name, long id) {
        super(name, id);
    }


    public DefaultStorage(List<Currency> currencyList, Map<Currency, BigDecimal> currencyAmounts, String name) {
        super(name);
        this.currencyList = currencyList;
        this.currencyAmounts = currencyAmounts;

    }

    public DefaultStorage(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    public DefaultStorage(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public List<Currency> getAvailableCurrencies() {
        return currencyList;
    }

    public void setAvailableCurrencies(List<Currency> availableCurrencies) {
        this.currencyList = availableCurrencies;
    }

    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {
        return currencyAmounts;
    }

    /*public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }
    */

    @Override
    public  BigDecimal getAmount(Currency currency) throws CurrencyException{
        checkCurrencyExist(currency);
        return currencyAmounts.get(currency);
    }

    public void checkCurrencyExist(Currency currency) throws CurrencyException {
        if(!currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency " + currency + " not exist.");
        }
    }
    //Update balance by hand
    @Override
    public void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException{
        checkCurrencyExist(currency);
        currencyAmounts.put(currency, amount);
    }

    // add money to the storage
    @Override
    public  void  addAmount(BigDecimal amount, Currency currency) throws CurrencyException{
        checkCurrencyExist(currency);
        BigDecimal oldAmount = currencyAmounts.get(currency);
        currencyAmounts.put(currency, oldAmount.add(amount));
    }

    // take money from the storage
    @Override
    public  void  expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException {
        checkCurrencyExist(currency);

        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newValue = oldAmount.subtract(amount);
        checkAmount(newValue);
        currencyAmounts.put(currency, newValue);
    }

    // amount can not be less zero
    public void checkAmount(BigDecimal amount) throws AmountException{
        if(amount.compareTo(BigDecimal.ZERO)<0){
            throw new AmountException("Amount can't be < 0");
        }
    }

    //work with currency

    @Override
    public  void  addCurrency (Currency currency) throws CurrencyException{
        if(currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency already exist");
        }

        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public  void deleteCurrency(Currency currency) throws CurrencyException{
        checkCurrencyExist(currency);
        // don't allows delete currency if there is amount not a zero
        if(!currencyAmounts.get(currency).equals(BigDecimal.ZERO)){
            throw new CurrencyException("Can't delete currency with amount");
        }

        currencyAmounts.remove(currency);
        currencyList.remove(currency);
    }

    @Override
    public  BigDecimal getApproxAmount(Currency currency){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Currency getCurrency(String code) throws CurrencyException{

        for (Currency currency: currencyList
             ) {
            if(currency.getCurrencyCode().equals(code)){
                return currency;
            }

        }
        throw new CurrencyException("Currency (code = " + code + ") not exist in storage");
    }

}
