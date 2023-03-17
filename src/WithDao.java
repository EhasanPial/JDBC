
import java.sql.*;

public class WithDao {
    public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        dao.setConnection();
        // -------------Add------------- //
        Student s2 = new Student();
        s2.rollNo = 15;
        s2.name = "Pial";

        dao.addStudent(s2);
        // ----------------Get------------ //
        Student s1 = dao.getStudent(15);
        if(s1 != null)
            System.out.println(s1.name);


    }
}

class StudentDao {
    Connection con = null;

    public void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Youtube";
            String userName = "root";
            String password = "12345678";
            con = DriverManager.getConnection(url, userName, password);
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is created...");
            }
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }

    public Student getStudent(int roll) {
        try {
            Student s = new Student();
            s.rollNo = roll;

            String query = "select name from Student where rollNo=" + roll;
            Statement statement = con.createStatement();


            ResultSet res = statement.executeQuery(query);
            res.next();
            s.name = res.getString(1);

            return s;
        } catch (Exception ignore) {
            return null;
        }
    }

    public void addStudent(Student s) {
        try {
            String query = "insert into Student values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.name);
            ps.setInt(2, s.rollNo);
            ps.executeUpdate();
            System.out.println("Added............");
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }

    }
}

class Student {
    int rollNo;
    String name;
}

