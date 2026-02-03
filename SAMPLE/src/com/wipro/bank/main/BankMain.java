package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;

public class BankMain {

    public static void main(String[] args) {

        BankService service = new BankService();

       
        System.out.println(service.checkBalance("717823333"));

       
        TransferBean tb = new TransferBean();
        tb.setFromaccountnumber("717823331");   
        tb.setToaccountnumber("123345676");     
        tb.setAmmount(25);                   
        tb.setDateofTransaction(new java.util.Date());
        try {
            System.out.println(service.transfer(tb));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(service.checkBalance("717823331"));
    }
}
