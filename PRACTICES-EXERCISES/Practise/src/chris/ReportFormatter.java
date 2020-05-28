package chris;

/**
 *
 * @author Chris_Eteka
 */
public abstract class ReportFormatter {

    public abstract String getFormattedValue();
    
    public String convertObjectToXML(Object object){
        return "Converted " + object + " to XML";
    }
    
    public String convertObjectToCSV(Object object){
        return "Converted " + object + " to CSV";
    }
}
