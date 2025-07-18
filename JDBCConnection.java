import java.sql.*;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ADTS_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "Ash@2006"; 
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL!");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection con = connect();
        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
                while (rs.next()) {
                    System.out.println("Name: " + rs.getString("name") + ", Roll No: " + rs.getString("roll_no"));
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}