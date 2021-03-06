package com.marks.finance.moneyinthepocket.core.dao.interfaces;

import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by Alexander on 9/4/2016.
 */
public interface StorageDAO extends CommonDAO <Storage> {


    boolean addCurrency(Storage storage, Currency currency) throws CurrencyException;

    boolean deleteCurrency(Storage storage, Currency currency) throws CurrencyException;

    boolean updateAmount(Storage storage, Currency currency, BigDecimal amount);
}