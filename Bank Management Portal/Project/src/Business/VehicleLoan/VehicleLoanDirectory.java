/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VehicleLoan;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class VehicleLoanDirectory {
    
    private ArrayList<VehicleLoan> vehicleLoanList;
    
    public VehicleLoanDirectory(){
        vehicleLoanList = new ArrayList<>();
    }

    public ArrayList<VehicleLoan> getVehicleLoanList() {
        return vehicleLoanList;
    }

    public VehicleLoan addVehicleLoan(String VehicleCondition,int LoanAmount,int RepaymentTerm,
            String VehicleType,String Brand,String Model,double RateOfInterest,String CurrentEmployerName
            ,String Occupation,int AnnualGrossIncome,String Status,String Date,String RepaymentOption){
        VehicleLoan vl =new VehicleLoan();
           vl.setVehiccleCondition(VehicleCondition);
        vl.setLoanAmount(LoanAmount);
        vl.setRepaymentTerm(RepaymentTerm);
        vl.setVehicleType(VehicleType);
        vl.setBrand(Brand);
        vl.setModel(Model);
        vl.setRateOfInterest(RateOfInterest);
        
        vl.setCurrentEmployerName(CurrentEmployerName);
        vl.setOccupation(Occupation);
        vl.setAnnualGrossIncome(AnnualGrossIncome);
      
        vl.setRepaymentOption(RepaymentOption);
        vl.setStatus("Pending");
        vl.setDate(Date);
        vehicleLoanList.add(vl);
        return vl;
    }
     public void removeVehicleLoan(VehicleLoan vl){
        vehicleLoanList.remove(vl);
    }
    
}
