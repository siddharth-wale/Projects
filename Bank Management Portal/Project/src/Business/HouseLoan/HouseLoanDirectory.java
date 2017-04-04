/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HouseLoan;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class HouseLoanDirectory {
    private ArrayList<HouseLoan> houseLoanList;
    
    public HouseLoanDirectory(){
        houseLoanList= new ArrayList<>();
    }

    public ArrayList<HouseLoan> getHouseLoanList() {
        return houseLoanList;
    }

   public HouseLoan addHouseLoan(int loanAmount,int repaymentTerm,String repaymentOption,String houseAddress,
           double rateOfInterest,String currentEmployerName,String Occupation,int AnnualGrossIncome,
          String Status,String Date){
       HouseLoan hl = new HouseLoan();
           hl.setRateOfInterest(rateOfInterest);
        hl.setLoanAmount(loanAmount);
        hl.setRepaymentTerm(repaymentTerm);
        hl.setHouseAddress(houseAddress);
        hl.setCurrentEmployerName(currentEmployerName);
        hl.setOccupation(Occupation);
        hl.setAnnualGrossIncome(AnnualGrossIncome);
        
        hl.setRepaymentOption(repaymentOption);
        hl.setStatus("Pending");
        hl.setDate(Date);
       houseLoanList.add(hl);
       return hl;
   }
     public void removeHouseLoan(HouseLoan hl){
        houseLoanList.remove(hl);
    }
    
}
