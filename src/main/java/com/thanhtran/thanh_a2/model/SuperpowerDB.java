/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.thanh_a2.model;

import com.thanhtran.thanh_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thanh Tran
 */

public class SuperpowerDB {

    public static Superpower getSuperpower(int superPowerId) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // connection to database in Heroku
        String dbUrl = System.getenv("JDBC_DATABASE_URL");

        try {
            //PostgerSQL driver
            String driver = "org.postgresql.Driver";

            //load the driver class
            Class.forName(driver).newInstance();

            String connUrl = "jdbc:postgresql://localhost/AvengersDB";
            String username = "postgres";
            String password = "prog32758";

            //establish the connection:
            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DriverManager.getConnection(dbUrl, username, password);
            } else {
                conn = DriverManager.getConnection(connUrl, username, password);
            }

            String sql = "SELECT * FROM powersource where id = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, superPowerId);

            rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String superpower = rs.getString("description");
                return new Superpower(id, superpower);

            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (Exception ex) {
            throw new SQLException(ex.toString());
        } finally {
           DBConnector.closeJDBCObjects(conn, ps, rs); 
        }

    }
    
    public static ArrayList<Superpower> getSuperpowerList() throws SQLException {
        ArrayList<Superpower> superpowerList = new ArrayList<Superpower>(); 
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

      String dbUrl = System.getenv("JDBC_DATABASE_URL");
        
        try {
            //PostgerSQL driver
            String driver = "org.postgresql.Driver";

            //load the driver class
            Class.forName(driver).newInstance();

            String connUrl = "jdbc:postgresql://localhost/AvengersDB";
            String username = "postgres";
            String password = "prog32758";

            //establish the connection:
            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DriverManager.getConnection(dbUrl, username, password);
            } else {
                conn = DriverManager.getConnection(connUrl, username, password);
            }

            String sql = "SELECT * FROM powersource";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String superpower = rs.getString("description");
                superpowerList.add(new Superpower(id,superpower));
            }
            return superpowerList;
            
        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (Exception ex) {
            throw new SQLException(ex.toString());
        } finally {
           DBConnector.closeJDBCObjects(conn, ps, rs); 
        }

    }
}
