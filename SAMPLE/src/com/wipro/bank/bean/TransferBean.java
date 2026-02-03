package com.wipro.bank.bean;

import java.util.Date;

public class TransferBean {

    private String fromaccountnumber;
    private String toaccountnumber;
    private float ammount;
    private Date dateofTransaction;

    public String getFromaccountnumber() {
        return fromaccountnumber;
    }

    public void setFromaccountnumber(String fromaccountnumber) {
        this.fromaccountnumber = fromaccountnumber;
    }

    public String getToaccountnumber() {
        return toaccountnumber;
    }

    public void setToaccountnumber(String toaccountnumber) {
        this.toaccountnumber = toaccountnumber;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public Date getDateofTransaction() {
        return dateofTransaction;
    }

    public void setDateofTransaction(Date dateofTransaction) {
        this.dateofTransaction = dateofTransaction;
    }
}
