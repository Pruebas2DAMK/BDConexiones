import java.sql.*;

public class pruebabd {
    public static void main(String[] args) {
      try{
          String user = "root";

        String password = "root";
        String url = "jdbc:mysql://localhost:3306/severo_ad";

        Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(url,user,password);
            if (con != null) {
                System.out.println("conexion realizada correctamente");
                //sirve para tocar las tablas, hacer querys
                Statement statement = con.createStatement();
                //recoger consultas
                ResultSet rs = statement.executeQuery("select * from login where username like 'rafa'");
                while (rs.next()){
                    String username = rs.getString("username");
                    String password2 = rs.getString("password");
                    System.out.println(username+password2);
                }
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
