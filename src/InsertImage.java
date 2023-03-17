import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// blob - binary large object;
public class InsertImage {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            // creating a connection
            String url = "jdbc:mysql://localhost:3306/Youtube";
            String userName = "root";
            String password = "12345678";
            Connection con = DriverManager.getConnection(url, userName, password);
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is created...");
            }
            FileInputStream fis = new FileInputStream("C:/Users/ASUS/Desktop/Screenshot 2023-02-22 151000.png") ;


            String q = "insert into images(pic) values(?)" ;
            PreparedStatement ps = con.prepareStatement(q) ;
            ps.setBinaryStream(1,fis,fis.available());
            ps.executeUpdate();
            System.out.println("done....");
            con.close();

        } catch (Exception ignored) {

        }
    }
}


