package com.appvol.core;

public class Utilisateur {

    protected String code;
    protected String nom;
    protected String prenom;
    protected String password;
    protected String email;
    protected int tel;
    

    public Utilisateur( String code ,String nom, String prenom,String password, String email, int tel){
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }


    public Utilisateur(String nom, String prenom, String email, String password, int tel) {
        this("0", nom, prenom, email, password, tel);
    }

     //Getters et Setters
    public String getCode(){ return code;}
    public void setCode(String code){ this.code = code;}

    public String getNom(){ return nom;}
    public void setNom(String nom){ this.nom = nom;}

    public String getPrenom(){ return prenom;}
    public void setPrenom(String prenom){ this.prenom = prenom;}

    public String getPassword(){ return password;}
    public void setPassword(String password){ this.password = password;}

    public String getEmail(){ return email;}
    public void setEmail(String email){ this.email= email;}

    public int getTel(){ return tel;}
    public void setTel(int tel){ this.tel = tel;}

}
