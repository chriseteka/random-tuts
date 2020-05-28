/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author Chris_Eteka
 */
public class ISubject {
    
    List<IObserver> observers = new ArrayList<>();
    
    public void addObserver(IObserver iObserver){
        observers.add(iObserver);
    }
    
    public void notifyOnObserverOnNewHire(Employee employee){
        if (observers.isEmpty() || employee == null) return;
        observers.stream().forEach((observer) -> {
            observer.notifyOnEmployeeAdded(employee);
        });
    }
    
    public void notifyOnObserverOnUpdate(Employee employee){
        if (observers.isEmpty() || employee == null) return;
        observers.stream().forEach((observer) -> {
            observer.notifyOnEmployeedEdited(employee);
        });
    }
}
