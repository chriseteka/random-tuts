/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris_Eteka
 */
public class EmployeeDAO {
    
    private final List<Employee> employees;

    public EmployeeDAO() {
        employees = new ArrayList<>();
        loadInitData();
    }
    
    Employee firstEmp = new Employee("Emma", 22, "Sango");
    Employee secondEmp = new Employee("John", 23, "Osun");
    Employee thirdEmp = new Employee("Jonna", 24, "Ibadan");
    Employee fourtEmp = new Employee("Eliot", 25, "Ogun");
    Employee fifthEmp = new Employee("James", 26, "Oyo");
    
    private void loadInitData(){
        employees.add(firstEmp);
        employees.add(secondEmp);
        employees.add(thirdEmp);
        employees.add(fourtEmp);
        employees.add(fifthEmp);        
    }
    
    public void addNewEmployee(Employee employee){
        employees.add(employee);
    }
    
    public Employee modifyEmployee(int id, String name){
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .map(e -> {
                    e.setName(name);
                    return e;
                }).findFirst().orElse(null);
    }

    public void showAll() {
        employees.stream().forEach(System.out::println);
    }
}
