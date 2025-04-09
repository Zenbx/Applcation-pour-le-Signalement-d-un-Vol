package com.appvol.core;

import javafx.scene.image.ImageView;

import java.time.LocalDate;


public class Annonce  extends Objet{


   protected LocalDate datePublication;
   protected String lieu;
   


   //Constructeur
   public Annonce(String code, String nom,  String description, LocalDate dateVol,ImageView photo, String type, LocalDate datePublication, String lieu){
      super(code, nom, description, dateVol, photo, type);
      this.datePublication = datePublication;
      this.lieu = lieu;
   }

   //Getters et Setters
   public String getLieu(){ return lieu;}
   public void setLieu(String lieu){ this.lieu = lieu;}

   public LocalDate getDatePublication(){ return datePublication;}
   public void setDatePublication(LocalDate datePublication){ this.datePublication = datePublication;}


}

   
