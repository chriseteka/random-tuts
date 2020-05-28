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
public abstract class IObserver {
    
    abstract void notifyOnEmployeeAdded(Employee employee);
    
    abstract void notifyOnEmployeedEdited(Employee employee);
}
