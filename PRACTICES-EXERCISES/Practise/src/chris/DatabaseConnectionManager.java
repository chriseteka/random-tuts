package chris;

/**
 *
 * @author Chris_Eteka
 */
public class DatabaseConnectionManager {
    
    private final String connector = "CHRIS DATABASE CONNECTOR";

    public String getConnector() {
        return connector;
    }
    
    public DatabaseConnectionManager getConnectionManager(){
        return this;
    }
    
    public void connect(){
        System.out.println(connector + " connected to the database successfully.");
    }
    
    public void disconnect(){
        System.out.println(connector + " disconnected from the database successfully.");
    }
}
