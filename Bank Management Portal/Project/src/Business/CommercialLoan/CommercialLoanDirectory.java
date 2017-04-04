/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CommercialLoan;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CommercialLoanDirectory {
    private ArrayList<CommercialLoan> commercialLoanList;
    
    public CommercialLoanDirectory(){
        commercialLoanList= new ArrayList<>();
    }

    public ArrayList<CommercialLoan> getCommercialLoanList() {
        return commercialLoanList;
    }
    
    public CommercialLoan addCommercialLoan(int loanAmount,int repaymentTerm,String repaymentOption,String LoanPurpose,
           double rateOfInterest,String currentEmployerName,String Occupation,int AnnualGrossIncome,
           String anyOtherLoan,String Status,String Date){
        CommercialLoan cl =new CommercialLoan();
             cl.setRateOfInterest(rateOfInterest);
        cl.setLoanAmount(loanAmount);
        cl.setRepaymentTerm(repaymentTerm);
        cl.setLoanPurpose(LoanPurpose);
        cl.setCurrentEmployerName(currentEmployerName);
        cl.setOccupation(Occupation);
        cl.setAnnualGrossIncome(AnnualGrossIncome);
        cl.setAnyOtherLoan(anyOtherLoan);
        cl.setRepaymentOption(repaymentOption);
        cl.setStatus("Pending");
        cl.setDate(Date);
        commercialLoanList.add(cl);
        return cl;
    }
     public void removeCommercialLoan(CommercialLoan cl){
        commercialLoanList.remove(cl);
    }
}
