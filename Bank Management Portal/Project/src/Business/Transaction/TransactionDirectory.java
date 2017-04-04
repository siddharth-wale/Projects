/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import Business.Customer.Customer;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class TransactionDirectory {
    private ArrayList<Transaction> transactionList;
    
    public TransactionDirectory(){
        transactionList = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

 public Transaction addTransaction(Date transactionDate,int transactionAmount,int debitAmount,int creditAmount,
         int transferAccountNumber,int remBalance,Customer tranferPreson,String dbCrStatus){
     Transaction tr = new Transaction();
     tr.setRemBalance(remBalance);
     tr.setCreditAmount(creditAmount);
     tr.setDbCrStatus(dbCrStatus);
     tr.setDebitAmount(debitAmount);
     tr.setTranferPreson(tranferPreson);
     tr.setTransactionAmount(transactionAmount);
     tr.setTransactionDate(transactionDate);
     tr.setTransferAccountNumber(transferAccountNumber);
     transactionList.add(tr);
     return tr;
 }
    
    
}
