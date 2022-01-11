/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nesneler;


public class Uye {
  
private String uyeAdi;

private String uyeSoyadi;

private String uyelikTipi;

    public Uye(String uyeAdi, String uyeSoyadi, String uyelikTipi) {
        this.uyeAdi = uyeAdi;
        this.uyeSoyadi = uyeSoyadi;
        this.uyelikTipi = uyelikTipi;
    }

    public String getUyeAdi() {
        return uyeAdi;
    }

    public void setUyeAdi(String uyeAdi) {
        this.uyeAdi = uyeAdi;
    }

    public String getUyeSoyadi() {
        return uyeSoyadi;
    }

    public void setUyeSoyadi(String uyeSoyadi) {
        this.uyeSoyadi = uyeSoyadi;
    }

    public String getUyelikTipi() {
        return uyelikTipi;
    }

    public void setUyelikTipi(String uyelikTipi) {
        this.uyelikTipi = uyelikTipi;
    }



  
}
