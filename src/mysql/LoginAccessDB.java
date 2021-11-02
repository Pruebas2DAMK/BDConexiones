package mysql;

import modelo.Login;
import singleton.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginAccessDB {
    private static Connection con;

    static {
        try {
            con = ConexionBD.getInstance().getCon();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Login> getLogins() throws SQLException{
        String sql = "SELECT * from login";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Login> logins = new ArrayList<>();

        while (rs.next()){
            Login login = new Login();
            login.setId(rs.getInt("id"));
            login.setUsername(rs.getString("username"));
            login.setPassword(rs.getString(3));
            login.setCreated_at(rs.getTimestamp(4));
            logins.add(login);
        }
        return logins;
    }
}
