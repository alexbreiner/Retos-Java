package model.dao;

import model.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;
import java.sql.*;
import java.util.ArrayList;

public class DeudasPorProyectoDao {

    public String consulta = "SELECT ID_Proyecto, SUM(Cantidad * Precio_Unidad)  AS VALOR\n" +
            "FROM Compra JOIN MaterialConstruccion \n" +
            "USING(ID_MaterialConstruccion) WHERE Pagado = 'No' GROUP BY ID_PROYECTO\n" +
            "ORDER BY VALOR DESC \n" +
            "LIMIT 49;";

    public ArrayList<DeudasPorProyectoVo> deudasProyectos() throws SQLException {
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        Connection connection = JDBCUtilities.getConnection();
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            statement = connection.prepareStatement(consulta);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DeudasPorProyectoVo deudas = new DeudasPorProyectoVo();
                deudas.setId(resultSet.getInt("ID_Proyecto"));
                deudas.setValor(resultSet.getDouble("VALOR"));
                respuesta.add(deudas);
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return respuesta;
    }
}
