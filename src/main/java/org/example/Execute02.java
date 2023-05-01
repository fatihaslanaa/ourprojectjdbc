package org.example;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musteriler", "postgres", "1234");
        //3. Adım: Statement oluştur.
        Statement statement = con.createStatement();
        ResultSet veri = statement.executeQuery("select * from musteriler");

        //       musteriler tablosuna yeni kayit ekleyin(4260,kubra,9000)

        String sql1 = "insert into musteriler values(4260,'fatih',9000)";
        System.out.println(sql1);

        //coklu kayit ekleme 1 den fazla veri
        //1.yol

        String[] veri1 = {"insert into musteriler values(426000900,'fatih',9000)","insert into musteriler values(4269,'kubra',10000)"} ;
        int count=0;
        for(String w:veri1){
            count+=statement.executeUpdate(w);
        }
        System.out.println(count+"satir eklendi");
        System.out.println(veri1);
    }
}