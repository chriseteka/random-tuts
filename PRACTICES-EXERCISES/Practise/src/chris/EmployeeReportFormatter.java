package chris;

/**
 *
 * @author Chris_Eteka
 */
public class EmployeeReportFormatter extends ReportFormatter{
    
    private Employee employee;
    private FORMAT_TYPE formatType;

    public EmployeeReportFormatter(Employee employee, FORMAT_TYPE formatType) {
        this.employee = employee;
        this.formatType = formatType;
    }

    @Override
    public String getFormattedValue() {
        if (formatType.equals(FORMAT_TYPE.CSV)) 
            return super.convertObjectToCSV(employee);
        else if (formatType.equals(FORMAT_TYPE.XML)) 
            return super.convertObjectToXML(employee);
        else return "Cannot format input object";
    }
    
    enum FORMAT_TYPE{
        CSV, XML;
    }
}
