/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.thanh_a2.model;

import java.io.Serializable;

/**
 *
 * @author Thanh Tran
 */
public class Superpower implements Serializable{

    /* private variables for powersource table */
    private int id;
    private String desc;

    /** empty constructor **/
    public Superpower() {

    }
    
    /** 2-arg constructor */
    public Superpower(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    /**
     * 
     * @return id of powersource */
     
    public int getId() {
        return id;
    }

    /** 
     * 
     * @param id set powersource id */
     
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return description
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * 
     * @param desc set description of powersource */
     
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
