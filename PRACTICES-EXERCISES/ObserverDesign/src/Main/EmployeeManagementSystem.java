/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import model.Employee;
import model.EmployeeDAO;
import observers.IObserver;
import observers.ISubject;

/**
 *
 * @author Chris_Eteka
 */
public class EmployeeManagementSystem {
    
    private final ISubject subject;
    private final EmployeeDAO employeeDAO;

    public EmployeeManagementSystem() {
        this.subject = new ISubject();
        this.employeeDAO = new EmployeeDAO();
    }
    
    public void registerObserver(IObserver observer){
        subject.addObserver(observer);
    }
    
    public void hireEmployee(Employee employee){
        employeeDAO.addNewEmployee(employee);
        subject.notifyOnObserverOnNewHire(employee);
    }
    
    public void modifyEmployee(int employeeId, String employeeName){
        Employee modifyEmployee = employeeDAO.modifyEmployee(employeeId, employeeName);
        subject.notifyOnObserverOnUpdate(modifyEmployee);
    }
    
    public void showEmployees(){
        employeeDAO.showAll();
    }
}
