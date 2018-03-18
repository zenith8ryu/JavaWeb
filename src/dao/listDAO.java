package dao;

import java.sql.*;

public class listDAO {
    public void InsertInformation(String name, String birthday, String sex) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ec_lv0?useUnicode=true&characterEncoding=utf8&useSSL=true";// "ec_lv0" is name of the connected db instance
        String user = "root";
        String password = "pass";

        //SQL文
        //メッセージ情報を挿入
        String sql =
                "INSERT INTO table_a left outer join table_a on table_b.b_id = table_a.a_id left outer join table_c on table_b.id_b_c = table_c.id_c VALUES(?, ?, sysdate(), 0, sysdate(), sysdate(), ?, ?)";

        try {
            Class.forName(driver);             //ドライバクラスのロード

            conn = DriverManager.getConnection(url, user, password);    //Connectionクラス生成
            pstmt = conn.prepareStatement(sql);        //PreparedStatementクラス生成
            pstmt.setString(1, name);
            pstmt.setString(2, birthday);
            pstmt.setString(3, sex);
            pstmt.executeUpdate();                    //INSERT文を実行
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        } finally {
            //終了処理
            //PreparedStatement終了
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pstmt = null;
            }
            //Connection終了
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
