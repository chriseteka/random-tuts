package chris;

import chris.EmployeeReportFormatter.FORMAT_TYPE;

/**
 *
 * @author Chris_Eteka
 */
public class ClientModule {
        
        static final DatabaseConnectionManager dbManager = new DatabaseConnectionManager();
        static EmployeeDAO employeeDAO = new EmployeeDAO(dbManager);
        static ReportFormatter reportFormatter;
    
    public static void main(String[] args) {
        
        Employee john = new Employee(1, "John", "Doctor", true);
        Employee jane = new Employee(2, "jane", "Nurse", true);
        Employee taliu = new Employee(3, "taliu", "Guard", false);
        
        //Saving Employee to the database
        System.out.println("SAVING ************************************");
        hireNewEmployee(john);
        hireNewEmployee(jane);
        hireNewEmployee(taliu);
        System.out.println("*********************************************");
        System.out.println();
        
        //Print all their reports in different formats
        System.out.println("REPORTING ************************************");
        printEmployeeReport(john, FORMAT_TYPE.CSV);
        printEmployeeReport(jane, FORMAT_TYPE.XML);
        printEmployeeReport(taliu, FORMAT_TYPE.CSV);
        System.out.println("*********************************************");
        System.out.println();
        
        //Deleting all employees from the database
        System.out.println("DELETING ************************************");
        terminateEmployee(taliu);
        terminateEmployee(jane);
        terminateEmployee(john);
        System.out.println("*********************************************");
    }
    
    static void hireNewEmployee(Employee employee){
        employeeDAO.saveEmployee(employee);
    }
    
    static void terminateEmployee(Employee employee){
        employeeDAO.deleteEmployee(employee);
    }
    
    static void printEmployeeReport(Employee employee, FORMAT_TYPE formatType){
        reportFormatter = new EmployeeReportFormatter(employee, formatType);
        System.out.println(reportFormatter.getFormattedValue());
    }
}
