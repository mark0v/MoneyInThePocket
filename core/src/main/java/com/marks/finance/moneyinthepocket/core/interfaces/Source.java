package com.marks.finance.moneyinthepocket.core.interfaces;

import com.marks.finance.moneyinthepocket.core.objects.OperationType;

import java.lang.String;
/**
 * Created by Alexander on 9/3/2016.
 */
public interface Source {

    String getName();

    long getId();

    OperationType getOperationType();


}