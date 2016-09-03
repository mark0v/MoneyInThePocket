package com.marks.finance.moneyinthepocket.core.abstrects;

import java.util.Calendar;

/**
 * Created by Alexander on 9/3/2016.
 */
public class AbstractOperation {

    private long id;
    private Calendar dateTime;
    private String getInfo;

    public long getId() {
        return id;
    }

    public AbstractOperation(long id, Calendar dateTime, String getInfo) {
        this.id = id;
        this.dateTime = dateTime;
        this.getInfo = getInfo;
    }

    public AbstractOperation(long id) {
        this.id = id;
    }

    public AbstractOperation() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }
}
