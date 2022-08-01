package model.dao;

import model.vo.ComprasDeLiderVo;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComprasDeLiderDao {
    public String consulta = "SELECT l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido AS LIDER, SUM(c.Cantidad * mc.Precio_Unidad) AS VALOR \n" +
            "FROM Proyecto p \n" +
            "JOIN Lider l ON l.ID_Lider  = p.ID_Lider \n" +
            "JOIN Compra c ON  C.ID_Proyecto =  p.ID_Proyecto \n" +
            "JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion\n" +
            "--GROUP BY l.ID_Lider\n" +
            "GROUP BY LIDER \n" +
            "ORDER BY VALOR DESC \n" +
            "LIMIT 10;";

    public ArrayList<ComprasDeLiderVo> listadoComprasLider() throws SQLException {
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        Connection connection = JDBCUtilities.getConnection();
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            statement = connection.prepareStatement(consulta);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ComprasDeLiderVo liderCompras = new ComprasDeLiderVo();
                liderCompras.setLider(resultSet.getString("LIDER"));
                liderCompras.setValor(resultSet.getDouble("VALOR"));

                respuesta.add(liderCompras);
            }

            statement.close();
            resultSet.close();
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error de conexion" + e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return respuesta;
    }
}
