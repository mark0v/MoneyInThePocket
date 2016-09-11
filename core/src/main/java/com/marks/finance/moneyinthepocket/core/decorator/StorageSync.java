package com.marks.finance.moneyinthepocket.core.decorator;

import com.marks.finance.moneyinthepocket.core.dao.interfaces.StorageDAO;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by Alexander on 9/11/2016.
 */
public class StorageSync implements StorageDAO{

    private StorageDAO storageDAO;
    private List<Storage> storageList;

    public StorageSync(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
        init();
    }

    private void init() {
        storageList = storageDAO.getAll();
    }


    @Override
    public boolean addCurrency(Storage storage, Currency currency) throws CurrencyException {
        if (storageDAO.addCurrency(storage, currency)){
            storage.addCurrency(currency);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCurrency(Storage storage, Currency currency) throws CurrencyException {
        if (storageDAO.deleteCurrency(storage, currency)){
            storage.deleteCurrency(currency);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAmount(Storage storage, Currency currency, BigDecimal amount) {
        if (storageDAO.updateAmount(storage, currency, amount)){
            return true;
        }
        return false;
    }

    @Override
    public List<Storage> getAll() {
        if (storageList==null){
            storageList = storageDAO.getAll();
        }
        return storageList;
    }

    @Override
    public Storage get(long id) {
        return storageDAO.get(id);
    }

    @Override
    public boolean update(Storage storage) {
        if (storageDAO.update(storage)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Storage storage) {

        if (storageDAO.delete(storage)){
            storageList.remove(storage);
            return true;
        }
        return false;
    }
}
