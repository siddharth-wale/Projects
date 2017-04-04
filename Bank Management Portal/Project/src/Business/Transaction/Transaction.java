/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import Business.Customer.Customer;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Transaction {
    private Date transactionDate;
    private int transactionAmount;
    private int debitAmount;
    private int creditAmount;
    private int transferAccountNumber;
    private int remBalance; 
    private Customer tranferPreson;
    private String dbCrStatus="none";

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(int debitAmount) {
        this.debitAmount = debitAmount;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getTransferAccountNumber() {
        return transferAccountNumber;
    }

    public void setTransferAccountNumber(int transferAccountNumber) {
        this.transferAccountNumber = transferAccountNumber;
    }

    public int getRemBalance() {
        return remBalance;
    }

    public void setRemBalance(int remBalance) {
        this.remBalance = remBalance;
    }

   

    public Customer getTranferPreson() {
        return tranferPreson;
    }

    public void setTranferPreson(Customer tranferPreson) {
        this.tranferPreson = tranferPreson;
    }

    public String getDbCrStatus() {
        return dbCrStatus;
    }

    public void setDbCrStatus(String dbCrStatus) {
        this.dbCrStatus = dbCrStatus;
    }
         @Override
    public String toString() {
        return String.valueOf(transactionDate);
    }
    
}
