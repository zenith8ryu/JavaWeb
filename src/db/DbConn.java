package db;

import java.sql.*;

public class DbConn {

    public static Connection getConn() {
        Connection conn = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/java_web?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String user = "root";
        String password = "pass";

        //Loading MySQL Driver
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
//        System.out.println(getConn());
        String sql = "SELECT * FROM goods";

        try {
            Connection conn = getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
