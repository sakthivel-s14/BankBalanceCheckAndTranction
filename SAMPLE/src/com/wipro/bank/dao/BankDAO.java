package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DButil;

public class BankDAO {

    public boolean validateAccount(String accountNumber) {
        try {
            Connection con = DButil.getDBConnection();
            String query =
                "SELECT account_number FROM account_tbl WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public float findBalance(String accountNumber) {
        try {
            Connection con = DButil.getDBConnection();
            String query =
                "SELECT balance FROM account_tbl WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean updateBalance(String accountNumber, float newBalance) {
        try {
            Connection con = DButil.getDBConnection();
            String query =
                "UPDATE account_tbl SET balance=? WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setFloat(1, newBalance);
            ps.setString(2, accountNumber);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean transferMoney(TransferBean transferBean) {
        try {
            Connection con = DButil.getDBConnection();

            String query = "INSERT INTO transfer_tbl " +
                           "VALUES (TRANSFER_SEQ.NEXTVAL, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, transferBean.getFromaccountnumber());
            ps.setString(2, transferBean.getFromaccountnumber()); // ✅ FIXED
            ps.setDate(3, new java.sql.Date(
                    transferBean.getDateofTransaction().getTime()));
            ps.setFloat(4, transferBean.getAmmount());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    }

