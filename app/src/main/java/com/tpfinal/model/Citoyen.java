package com.tpfinal.model;


import java.io.Serializable;

public class Citoyen implements Serializable {

    private int idUser;

    private String courriel;

    private String password;

    private String nom;

    private String prenom;

    private String nassm;

    private String sexe;

    private int age;

    private String numTelephone;

    private String villeResidence;

    private String isParentOuTuteur;

    private String isMineur;

    private int idParent;

    private int idPermis;

    private Permis permis;


    public Citoyen() {
        super();
    }

    public Citoyen(int idUser,String courriel, String password, String nom, String prenom, String nassm, String sexe, int age, String numTelephone, String villeResidence, String isParentOuTuteur, String isMineur, int idParent,int idPermis) {
        this.idUser = idUser;
        this.courriel = courriel;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.nassm = nassm;
        this.sexe = sexe;
        this.age = age;
        this.numTelephone = numTelephone;
        this.villeResidence = villeResidence;
        this.isParentOuTuteur = isParentOuTuteur;
        this.isMineur = isMineur;
        this.idParent = idParent;
        this.idPermis = idPermis;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNassm() {
        return nassm;
    }

    public void setNassm(String nassm) {
        this.nassm = nassm;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getVilleResidence() {
        return villeResidence;
    }

    public void setVilleResidence(String villeResidence) {
        this.villeResidence = villeResidence;
    }

    public String getIsParentOuTuteur() {
        return isParentOuTuteur;
    }

    public void setIsParentOuTuteur(String isParentOuTuteur) {
        this.isParentOuTuteur = isParentOuTuteur;
    }

    public String getIsMineur() {
        return isMineur;
    }

    public void setIsMineur(String isMineur) {
        this.isMineur = isMineur;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public Permis getPermis() {
        return permis;
    }

    public void setPermis(Permis permis) {
        this.permis = permis;
    }

    public int getIdPermis() {
        return idPermis;
    }

    public void setIdPermis(int idPermis) {
        this.idPermis = idPermis;
    }
}
