package model.dao;

import model.consultas.Consultas;
import model.vo.ComprasDeLiderVo;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComprasDeLiderDao {
    PreparedStatement statement;
    ResultSet resultSet;
    Consultas query = new Consultas();
    ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<>();

    public ArrayList<ComprasDeLiderVo> listadoComprasLider() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        try {
            statement = connection.prepareStatement(query.consultasAllCompras());
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
