package chris;

/**
 *
 * @author Chris_Eteka
 */
public class EmployeeDAO {
    
    private final DatabaseConnectionManager connectionManager;

    public EmployeeDAO(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager.getConnectionManager();
    }
    
    public void saveEmployee(Employee employee){
        connectionManager.connect();
        System.out.println("Using " + connectionManager.getConnector() 
                + " to save " + employee + " to the database.");
        connectionManager.disconnect();
    }
    
    public void deleteEmployee(Employee employee) {
        connectionManager.connect();
        System.out.println("Using " + connectionManager.getConnector()
                + " to delete " + employee + " from the database.");
        connectionManager.disconnect();
    }
}
