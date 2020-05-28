/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import model.Employee;

/**
 *
 * @author Chris_Eteka
 */
public class PayrollObserver extends IObserver{
    
    void notifyOnEmployeeAdded(Employee employee) {
        notifyPayroll();
        System.out.println("New employee hired with name: " + employee.getName());
    }

    void notifyOnEmployeedEdited(Employee employee) {
        notifyPayroll();
        System.out.println("New employee modified with name: " + employee.getName());        
    }
    
    private void notifyPayroll(){
        System.out.println("Payroll department Notified");
    }
}
