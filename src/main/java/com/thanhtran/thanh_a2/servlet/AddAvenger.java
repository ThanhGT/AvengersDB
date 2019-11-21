/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.thanh_a2.servlet;

import com.thanhtran.thanh_a2.model.AvengerDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thanh Tran
 */
public class AddAvenger extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            try {

                // store variables in a request variable
                String name = request.getParameter("heroName");
                String desc = request.getParameter("desc");
                String powerSource = request.getParameter("powerSource");
                AvengerDB.addAvenger(name, desc, powerSource);

            } catch (Exception ex) {
                request.setAttribute("error", ex.toString());

                out.print("<h1>Avenger added successfully</h1><br>");
                out.print("<a href=\"index.html\">Back to Index</a>");

            }
        }
    }
}
