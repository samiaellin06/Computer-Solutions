import java.sql.*;

public class DBConnect 
{  
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect ()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql//localhost:3306/computer_solutions", "root", "");
            st = con.createStatement();
            
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
    }
}