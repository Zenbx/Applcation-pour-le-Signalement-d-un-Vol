package com.appvol.core;

import java.time.LocalDate;

import javafx.scene.image.ImageView;

public abstract class  Objet {
    protected String code;
    protected String nom;
    protected String description;
    protected LocalDate dateVol;
    protected ImageView photo;
    protected String type;
   


   //Constructeur
   public Objet(String code, String nom,  String description, LocalDate dateVol,ImageView photo, String type){
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.dateVol = dateVol;
        this.photo = photo;
        this.type = type;
   }

   //Getters et Setters
   public String getCode(){ return code;}
   public void setCode(String code){ this.code = code;}

   public String getNom(){ return nom;}
   public void setNom(String nom){ this.nom = nom;}

   public String getDescription(){ return description;}
   public void setDescription(String description){ this.description = description;}

   public LocalDate getDateVol(){ return dateVol;}
   public void setDateVol(LocalDate dateVol){ this.dateVol = dateVol;}

   public ImageView getPhoto(){ return photo;}
   public void setPhoto(ImageView photo){ this.photo = photo;}

   public String getType(){ return type;}
   public void setType(String type){ this.type = type;}

}
