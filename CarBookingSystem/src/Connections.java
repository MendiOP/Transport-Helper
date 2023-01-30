import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections {
    Connection connection;
    Statement statement;

    public Connections(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///cbs1", "root","Munna6954@");
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
