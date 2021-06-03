package com.tpfinal.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Permis implements Serializable {

    private int idPermis;

    private String typePermis;

    private Date datePermis;

    private Date finDatePermis;

    private String isExpired;

    private String veutRenew;


    public Permis(){

    }

    public Permis(int idPermis, String typePermis, Date datePermis, Date finDatePermis, String isExpired, String veutRenew) {
        this.idPermis = idPermis;
        this.typePermis = typePermis;
        this.datePermis = datePermis;
        this.finDatePermis = finDatePermis;
        this.isExpired = isExpired;
        this.veutRenew = veutRenew;
    }

    public int getIdPermis() {
        return idPermis;
    }

    public void setIdPermis(int idPermis) {
        this.idPermis = idPermis;
    }

    public String getTypePermis() {
        return typePermis;
    }

    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }

    public Date getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(Date datePermis) {
        this.datePermis = datePermis;
    }

    public Date getFinDatePermis() {
        return finDatePermis;
    }

    public void setFinDatePermis(Date finDatePermis) {
        this.finDatePermis = finDatePermis;
    }

    public String getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(String isExpired) {
        this.isExpired = isExpired;
    }

    public String getVeutRenew() {
        return veutRenew;
    }

    public void setVeutRenew(String veutRenew) {
        this.veutRenew = veutRenew;
    }
}
