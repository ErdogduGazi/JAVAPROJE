/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operasyonlar;

import Nesneler.Kitap;
import Nesneler.Uye;
import Veritabani.Veritabani;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Şeyma
 */
public class DatabaseIslemleri {

    private Connection con = null;

    private Statement statement = null;

    private PreparedStatement preparedStatement = null;

    public static void main(String[] args) {
        DatabaseIslemleri kitap = new DatabaseIslemleri();
    }

    public DatabaseIslemleri() {

        //VERi tabanı bağlantı işlemi...
        //"jdbc:mysql://localhost:3306/demo
        String url = "jdbc:mysql://" + Veritabani.host + ":" + Veritabani.port + "/" + Veritabani.db_ismi + "?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı..");
        }

        try {
            con = DriverManager.getConnection(url, Veritabani.kullanici_adi, Veritabani.parola);
            System.out.println("Bağlantı başarılı.");
        } catch (SQLException e) {
            System.out.println("Bağlantı başarısız..");
        }

    }

    public boolean girisYap(String kullaniciAdi, String parola) {

// sql sorugusu
        String sorgu = "Select * From adminler where kullaniciadi=? and parola=?";

        try {

            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, parola);
            //girilen kullanıcı adı ve parola varsa rs ye atar.
            ResultSet rs = preparedStatement.executeQuery();

            // rs false olursa kayıtlı admin yok.
            if (rs.next() == false) {

                return false;

            } else {
                //varsa giriş yapabilir..
                return true;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;

        }

    }

    public ArrayList<Kitap> kitaplariGetir() {

//göndereceğimiz arrayListi başlatmak...
        ArrayList<Kitap> kitaplar = new ArrayList<>();

//databaseden tüm verileri almak...
        try {

            String sorgu = "Select * From kitaplar";

            preparedStatement = con.prepareStatement(sorgu);

            ResultSet rs = preparedStatement.executeQuery();

            //hepsini dön bitince false
            while (rs.next()) {

                int id = rs.getInt("id");
                String kitapadi = rs.getString("kitapadi");
                String yazaradi = rs.getString("yazaradi");
                int basımyili = rs.getInt("basımyili");
                String türü = rs.getString("turu");

                // gecici array listemizi doldurmak.. (Uye referansıyla)
                kitaplar.add(new Kitap(id, kitapadi, yazaradi, basımyili, türü));

            }
            //kitapları dön
            return kitaplar;

        } catch (SQLException e) {
            //hata olursa null dön...
            return null;
        }

    }

    public void kitapEkle(String kitapAdi, String kitapYazari, int basimTarihi, String türü) {

        try {
            String query = "INSERT INTO kitaplar (kitapadi,yazaradi,basımyili,turu) VALUES (?,?,?,?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, kitapAdi);
            preparedStatement.setString(2, kitapYazari);
            preparedStatement.setInt(3, basimTarihi);
            preparedStatement.setString(4, türü);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public void kitapGuncelle(int id, String kitapAdi, String yazarAdi, int basimYili, String kitapTuru) {
        try {
            String query = "UPDATE kitaplar SET kitapadi=? , yazaradi=? , basımyili=? , turu=? where id=? ";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, kitapAdi);
            preparedStatement.setString(2, yazarAdi);
            preparedStatement.setInt(3, basimYili);
            preparedStatement.setString(4, kitapTuru);

            //idsi istediğim olan değerde bu işlemleri yap..
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void kitapSil(int id) {
        try {

            String sorgu = "Delete From kitaplar where id=?";

            preparedStatement = con.prepareStatement(sorgu);

            //1.Soru işaretine parametredeki id'yi ata...
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {

        }

    }

    public void uyeEkle(String uyeAdi, String uyeSoyadi, int okunanKitapSayisi) {

        try {
            String query = "INSERT INTO uyeler (ad,soyad,uyeliktipi) VALUES (?,?,?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, uyeAdi);
            preparedStatement.setString(2, uyeSoyadi);

            if (okunanKitapSayisi >= 5) {
                preparedStatement.setString(3, "Platin Üye");

            } else {
                preparedStatement.setString(3, "Normal Üye");
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public ArrayList<Uye> uyeleriGetir() {

//göndereceğimiz arrayListi başlatmak...
        ArrayList<Uye> uyeler = new ArrayList<>();

//databaseden tüm verileri almak...
        try {

            String sorgu = "Select * From uyeler";

            preparedStatement = con.prepareStatement(sorgu);

            ResultSet rs = preparedStatement.executeQuery();

            //hepsini dön bitince false
            while (rs.next()) {

                String uyeAdi = rs.getString("ad");
                String uyeSoyadi = rs.getString("soyad");
                String uyelikTipi = rs.getString("uyeliktipi");

                // gecici array listemizi doldurmak.. (Uye referansıyla)
                uyeler.add(new Uye(uyeAdi, uyeSoyadi, uyelikTipi));

            }
            //uyeleri dön
            return uyeler;

        } catch (SQLException e) {
            //hata olursa null dön...
            return null;
        }

    }

    public boolean platinMi(String uyeAdi, String uyeSoyadi) {

        ArrayList<Uye> geciciList = new ArrayList<>();
        geciciList = uyeleriGetir();

        for (Uye uye : geciciList) {
            if (uye.getUyelikTipi().equals("Platin Üye") && uyeAdi.equals(uye.getUyeAdi()) && uyeSoyadi.equals(uye.getUyeSoyadi())) {
                return true;

            }
        }

        return false;

    }

    public void uyeCikar(String uye) {

        
        String[] parts = uye.split(" ");
        String ad = parts[0];
        String soyad = parts[1];
       // String result=ad+soyad;
        //String type = parts[2];
       // System.out.println(ad+soyad);
        //System.out.println(soyad);

        try {

            String sorgu = "Delete FROM uyeler  where ad=? AND soyad=?";

            preparedStatement = con.prepareStatement(sorgu);

            
            preparedStatement.setString(1, ad);

            preparedStatement.setString(2, soyad);


            preparedStatement.executeUpdate();
           // con.commit();

        } catch (SQLException e) {

        }

    }
}
