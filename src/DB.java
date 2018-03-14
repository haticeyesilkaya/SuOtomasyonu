


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    final private String url = "org.sqlite.JDBC";
    final private String db = "jdbc:sqlite:db/";
    private String dbName = "kullanicilar.db";
    private Connection conn = null;
    private Statement st = null;

    public DB() {

    }

    public DB(String dbName) {
        this.dbName = dbName;
    }

    //BAĞLAN METODU KURULUYOR
    /**
     * *
     * bu metod veri tabanına bağlantı kurmayı sağlar
     *
     * @return
     */
    public Statement baglan() {
        if (st != null && conn != null) {
            kapat();
        } else {
            try {
                Class.forName(url);
                conn = DriverManager.getConnection(db + dbName);
                st = conn.createStatement();
                System.out.println("Bağlantı başarılı");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Bağlantı Hatası " + e);
            }
        }
        return st;
    }

    // Veri tabanını kapat
    /**
     * *
     * bu metot veri tabanı bağlantısını kapatmayı sağlar
     *
     */
    public void kapat() {
        if (st != null && conn != null) {
            try {
                st.close();
                conn.close();
                st = null;
                conn = null;
                System.out.println("Kapatma yapıldı");
            } catch (SQLException e) {
                System.err.println("Kapatma Hatası: " + e);
            }
        }
    }

}
