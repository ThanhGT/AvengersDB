package com.thanhtran.thanh_a2.model;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Tran
 */
public class Avenger implements Serializable {

    /**
     * private variables of avenger table */
     
    private String heroName;
    private String desc;
    private Superpower superpower;
    
    /** empty constructor */
    public Avenger() {
        
    }
    
    /** 3 arg constructor **/
    public Avenger(String heroName, String desc, Superpower superpower){
        this.heroName = heroName;
        this.desc = desc;
        this.superpower = superpower;
    }

    /**
     * 
     * @return superpower of avenger
     */
    public Superpower getSuperpower() {
        return superpower;
    }

    /**
     * 
     * @return name of avenger
     */
    public String getHeroName() {
        return heroName;
    }

    /**
     * 
     * @return description
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * 
     * @param heroName set name of avenger 
     */
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    /**
     * 
     * @param desc set desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /**
     * 
     * @param superpower set superpower
     */
    public void setSuperpower(Superpower superpower) {
        this.superpower = superpower;
    }

    
}
