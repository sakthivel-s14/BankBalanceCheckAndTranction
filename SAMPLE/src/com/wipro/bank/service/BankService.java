package com.wipro.bank.service;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.InsufficientFundsException;

public class BankService {

    BankDAO dao = new BankDAO();

    public String checkBalance(String accountNumber) {
        if (dao.validateAccount(accountNumber)) {
            return "BALANCE : " + dao.findBalance(accountNumber);
        }
        return "INVALID ACCOUNT";
    }

    public String transfer(TransferBean tb)
            throws InsufficientFundsException {

        if (tb == null) return "INVALID DATA";

        String from = tb.getFromaccountnumber();
        String to = tb.getToaccountnumber();

        if (!dao.validateAccount(from) || !dao.validateAccount(to)) {
            return "INVALID ACCOUNT";
        }

        float balance = dao.findBalance(from);

        if (balance < tb.getAmmount()) {
            throw new InsufficientFundsException();
        }

        float fromBal = balance - tb.getAmmount();
        float toBal = dao.findBalance(to) + tb.getAmmount();

        boolean debit = dao.updateBalance(from, fromBal);
        boolean credit = dao.updateBalance(to, toBal);
        boolean log = dao.transferMoney(tb);

        if (debit && credit && log) {
            return "TRANSFER SUCCESSFUL";
        }

        return "TRANSFER FAILED";
    }
}
