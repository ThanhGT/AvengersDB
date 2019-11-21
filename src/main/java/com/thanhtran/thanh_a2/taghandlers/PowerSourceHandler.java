package com.thanhtran.thanh_a2.taghandlers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thanhtran.thanh_a2.model.Superpower;
import com.thanhtran.thanh_a2.model.SuperpowerDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Thanh Tran
 */
public class PowerSourceHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
 
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        
        // any html written to the JspWriter will replace the custom tag
        JspWriter out = getJspContext().getOut();
        
        try {            
            ArrayList<Superpower> superpowerList = SuperpowerDB.getSuperpowerList();
            out.print("<select name='powerSource'>");
            for (Superpower s : superpowerList)
            {
                out.print("<option>" + s.getDesc() + "</option>");
            }
            out.print("</select>");
            
            // executes the body within the custom tag and directs output to the JspWriter
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PowerSourceHandler tag", ex);
        } catch (SQLException ex) {
            Logger.getLogger(PowerSourceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
