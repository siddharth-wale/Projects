/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EducationLoan;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class EducationLoanDirectory {
    private ArrayList<EducationLoan> eductaionLoanList;
    
    public EducationLoanDirectory(){
        eductaionLoanList=new ArrayList<>();
    }

    public ArrayList<EducationLoan> getEductaionLoanList() {
        return eductaionLoanList;
    }
    
    public EducationLoan addEducationLoan(int loanAmount,int repaymentTerm,String repaymentOption,String universityName,String universityAddress,String courseName,String courseDuration,double rateOfInterest,String currentEmployerName,String Occupation,int AnnualGrossIncome,String Status,String Date){
        EducationLoan el = new EducationLoan();
          el.setRateOfInterest(rateOfInterest);
        el.setLoanAmount(loanAmount);
        el.setRepaymentTerm(repaymentTerm);
        el.setUniversityAddress(universityAddress);
        el.setUniversityName(universityName);
        el.setCourseDuration(courseDuration);
        el.setCourseName(courseName);
        el.setCurrentEmployerName(currentEmployerName);
        el.setOccupation(Occupation);
        el.setAnnualGrossIncome(AnnualGrossIncome);
       
        el.setRepaymentOption(repaymentOption);
        el.setStatus("Pending");
        el.setDate(Date);
        eductaionLoanList.add(el);
        return el;
    }
    public void removeEducationLoan(EducationLoan el){
        eductaionLoanList.remove(el);
    }
}
