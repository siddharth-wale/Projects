/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Enterprise.Enterprise;
import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class PersonDirectory {
      private ArrayList<Person>personList;
    
    
    public PersonDirectory(){
        personList=new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    public Person addPerson(String name,Date DateOfBirth,String Address,
             int MobileNumber,int SSNNumber,String EmailAddress,String Status,Enterprise enterprise){
        
        Person person = new Person();
        person.setName(name);
        person.setAddress(Address);
        person.setDateOfBirth(DateOfBirth);
        person.setMobileNumber(MobileNumber);
        person.setSsnNumber(SSNNumber);
        person.setStatus("Request Pending");
        person.setEnterprise(enterprise);
        personList.add(person);
        return person;
    }
    
    public void deletePerson(Person person)
    {
        personList.remove(person);
    }
         public Boolean checkPersonByPersonID(String personID)
    {
        for(Person person: personList)
       if(person.getPersonId().equalsIgnoreCase(personID))
         {
           return true;     
         }
     return false;
    }
  

    
}
