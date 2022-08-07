package util;

import java.sql.*;

public class JDBCUtilities {
    private static final String UBICACION_DB = "ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_DB;
        try {
            return  DriverManager.getConnection(url);
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return  null;
        }
    }
}

