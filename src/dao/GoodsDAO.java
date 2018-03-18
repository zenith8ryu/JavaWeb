package dao;

import db.DbConn;
import db.DbDisconn;
import entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        new GoodsDAO().easyAdd("coin2", 2, 2.00);
    }

    public boolean easyAdd(String gname, int gnum, double price) {
//        String g_name = gname;
//        int g_num = gnum;
//        double g_price = price;

        boolean isAdded = false;
        conn = DbConn.getConn();
        String addSql = "INSERT INTO GOODS(GNAME, GNUM, PRICE) VALUES(?,?,?)";

        try {
            pstmt = conn.prepareStatement(addSql);
            pstmt.setString(1, gname);
            pstmt.setInt(2, gnum);
            pstmt.setDouble(3, price);

            int rsNum = pstmt.executeUpdate();
            if (rsNum > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbDisconn.close(pstmt, conn);
        }

        return isAdded;
    }


    /**
     * 0. Get gid of goods by gname(unique key)
     *
     * @param GNAME
     * @return
     */
    public int getGoodsId(String GNAME) {
        int gid = -1;
        conn = DbConn.getConn();
        String searchSql = "SELECT * FROM goods where gname=?";

        try {
            pstmt = conn.prepareStatement(searchSql);
            pstmt.setString(1, GNAME);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                gid = rs.getInt("gid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbDisconn.closeAll(rs, pstmt, conn);
        }

        return gid;
    }

    /**
     * 1. Add a new item into the "goods" table
     *
     * @param goods item name
     * @return boolean
     */
    public boolean addGoods(Goods goods) {
        boolean isAdded = false;
        conn = DbConn.getConn();
        String addSql = "INSERT INTO GOODS(GNAME, GNUM, PRICE) VALUES(?,?,?)";

        try {
            pstmt = conn.prepareStatement(addSql);
            pstmt.setString(1, goods.getGname());
            pstmt.setDouble(2, goods.getPrice());
            pstmt.setInt(3, goods.getGnum());

            int rsNum = pstmt.executeUpdate();
            if (rsNum > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbDisconn.close(pstmt, conn);
        }

        return isAdded;
    }

    /**
     * 2. Update info of existed goods in "goods" table
     *
     * @param goods
     * @return
     */
    public boolean updateGoods(Goods goods) {
        boolean isUpdate = false;
        Connection conn = DbConn.getConn();
        String updateSql = "UPDATE goods SET gprice=?, gnum=? WHERE gname=?";

        try {
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setDouble(1, goods.getPrice());
            pstmt.setInt(2, goods.getGnum());
            pstmt.setString(3, goods.getGname());

            int rsNum = pstmt.executeUpdate();
            if (rsNum == 1) {
                isUpdate = true;
            } else if (rsNum > 1) {
                System.out.println("Emergency, more than 1 data have been updated!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdate;
    }

    /**
     * 3. delete good from "goods" table
     *
     * @param gid id of goods
     * @return
     */
    public boolean deleteGoods(int gid) {
        boolean isDeleted = false;
        Connection conn = DbConn.getConn();
        String delSql = "DELETE FROM goods WHERE gid=?";

        try {
            pstmt = conn.prepareStatement(delSql);
            pstmt.setInt(1, gid);
            int rsNum = pstmt.executeUpdate();
            if (rsNum > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbDisconn.close(pstmt, conn);
        }

        return isDeleted;
    }
}
