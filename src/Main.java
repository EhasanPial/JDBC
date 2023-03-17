


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver") ;

            // creating a connection
            String url = "jdbc:mysql://localhost:3306/Youtube";
            String userName = "root" ;
            String password = "12345678";
            Connection con = DriverManager.getConnection(url,userName,password);
            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else {
                System.out.println("Connection is created...");
            }

            // create a query
//            String q = "create table table1(tId int(20) primary key auto_increment," +
//                            " tName varchar(200) not null, " +
//                            "tCity varchar(400))" ;
//            Statement stmt = con.createStatement() ;
//            stmt.executeUpdate(q);
//            System.out.println("table created in database");
//            con.close();

            String q = "insert into table1(tName,tCity) values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
            System.out.println("Enter name : ");
            String name = br.readLine();

            System.out.println("Enter City: ");
            String city = br.readLine();
            // set the values for query
            pstmt.setString(1,name);
            pstmt.setString(2,city);

            pstmt.executeUpdate();
            System.out.println("inseted...");
            con.close();


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
}

class Update {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/Youtube";
            String userName = "root" ;
            String password = "12345678";
            Connection con = DriverManager.getConnection(url,userName,password);
            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else {
                System.out.println("Connection is created...");
            }

            // query
            String q = "update table1 set tName=?, tCity=? where tId=?";
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name: ");
            String name = bf.readLine();
            System.out.println("Enter city: ");
            String city = bf.readLine() ;

            System.out.println("Student id: ");
            int id = Integer.parseInt(bf.readLine()) ;

            PreparedStatement ps = con.prepareStatement(q) ;
            ps.setString(1,name);
            ps.setString(2,city);
            ps.setInt(3,id);

            ps.executeUpdate();
            System.out.println("done..................");


        }
        catch (Exception ignored) {}

    }
}




