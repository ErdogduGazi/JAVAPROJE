/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nesneler;

/**
 *
 * @author Şeyma
 */
public class Kitap {

    private int id;

    private String kitapAdi;

    private String yazarAdi;

    private int basımYili;

    private String turu;

    public Kitap(int id, String kitapAdi, String yazarAdi, int basımYili, String turu) {
        this.id = id;
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.basımYili = basımYili;
        this.turu = turu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public int getBasımYili() {
        return basımYili;
    }

    public void setBasımYili(int basımYili) {
        this.basımYili = basımYili;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }



}
