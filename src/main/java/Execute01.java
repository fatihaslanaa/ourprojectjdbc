import java.sql.*;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Flowers","postgres","1234");
        //3. Adım: Statement oluştur.
        Statement statement = con.createStatement();

        ResultSet veri= statement.executeQuery("select * from Flowers");

        while (veri.next()){
            System.out.println(veri.getString(1)
                    + veri.getString(2)
                    + veri.getInt(3));

        }

        //ex1:fiyati ikiden buyukleri getir.
        String str1= "Select name from Flowers where price>2";
        ResultSet veri2=statement.executeQuery(str1);
        while(veri2.next()){
            System.out.println(veri2.getString(1));

        }

        //Close the connection and statement
        con.close();
        statement.close();
        veri.close();

    }
}