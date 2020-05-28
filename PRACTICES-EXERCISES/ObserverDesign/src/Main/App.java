/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import model.Employee;
import observers.HRObserver;
import observers.IObserver;
import observers.PayrollObserver;

/**
 *
 * @author Chris_Eteka
 */
public class App {
    
    public static void main(String[] args) {
        IObserver hrObserver = new HRObserver();
        IObserver payrollObserver = new PayrollObserver();
        
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        
        ems.registerObserver(hrObserver);
        ems.registerObserver(payrollObserver);
        
        Employee chris = new Employee("Chris", 19, "Enugu");
        ems.hireEmployee(chris);
        System.out.println("");
        System.out.println("");
        
        ems.showEmployees();
        System.out.println("");
        System.out.println("");
        
        ems.modifyEmployee(53, "Haliu");
        System.out.println("");
        System.out.println("");
        ems.showEmployees();
    }
    
}
