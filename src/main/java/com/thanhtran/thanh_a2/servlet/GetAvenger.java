package com.thanhtran.thanh_a2.servlet;

import com.thanhtran.thanh_a2.db.DBConnector;
import com.thanhtran.thanh_a2.model.Avenger;
import com.thanhtran.thanh_a2.model.AvengerDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thanh Tran
 */
public class GetAvenger extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            try {

                // stores Avengers into an array list
                ArrayList<Avenger> avengers = AvengerDB.getAvengers();

                request.setAttribute("avengers", avengers);

            } catch (Exception ex) {
                request.setAttribute("error", ex.toString());
            }

            RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
            rd.forward(request, response);

        }
    }
