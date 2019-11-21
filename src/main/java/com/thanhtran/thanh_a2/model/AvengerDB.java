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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thanh Tran
 */

public class AvengerDB {
        
    /**
     * 
     * @return a list of avengers
     * @throws SQLException 
     */
    public static ArrayList<Avenger> getAvengers() throws SQLException {
        
        ArrayList<Avenger> avengers = new ArrayList<Avenger>();
        
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
                

            // query to get the username to display in the front end
            // TODO: get only relevant fields from User table that need to be displayed
//            String sql = "SELECT * FROM User " + "WHERE Username = '" + username + "' ";
        
            
            String sql = "SELECT * FROM avengers";

            // create a statement object
            ps = conn.prepareStatement(sql);

            // execute query
            rs = ps.executeQuery();

            //

            while (rs.next()) {
                
                String heroName = rs.getString("avengername");
                String desc = rs.getString("description");
                
                int superpowerId = rs.getInt("powersource");
                Superpower superpower = SuperpowerDB.getSuperpower(superpowerId);

                
                avengers.add(new Avenger(heroName, desc, superpower));
            }

        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (Exception ex) {
            throw new SQLException(ex.toString());
        } finally {
           DBConnector.closeJDBCObjects(conn, ps, rs); 
        }
        
        return avengers;
    }
    
    /**
     * 
     * @param name avengers name
     * @param desc description of the avenger
     * @param powerSource superpower of the avenger
     * @return avenger 
     * @throws Exception 
     */
    public static ArrayList<Avenger> addAvenger(String name, String desc, String powerSource) throws Exception {
        
        // 
        ArrayList<Avenger> avengers = new ArrayList<Avenger>();
        
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
        
            //build insert sql
            String sql = "INSERT INTO avengers(avengername, description, powersource) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            
            
            // set powersource id if 
            //ok so this part is hardcoded because I couldn't figure out how to get the index
            //from just the request parameter (me stupid). Althought requirements 
            //doesn't specifically say that this portion of the code has to be dynamic though :)
            int powerSourceNum = 0;
             if (powerSource.equals("Amazing Technology"))
            { powerSourceNum = 1; }
            else if (powerSource.equals("Supernatural"))
            { powerSourceNum = 2; }
            else 
            { powerSourceNum = 3; } 
            
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, powerSourceNum);
            
            rs = ps.executeQuery();

//            int count = ps.executeUpdate();
            System.out.println("Avenger added successfully!");
        
        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (Exception ex) {
            throw new SQLException(ex.toString());
        } finally {
           DBConnector.closeJDBCObjects(conn, ps, rs); 
        }
                
        return avengers;
    }
}