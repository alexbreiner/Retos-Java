package model.dao;

import model.consultas.Consultas;
import model.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;
import java.sql.*;
import java.util.ArrayList;

public class DeudasPorProyectoDao {
    PreparedStatement statement;
    ResultSet resultSet;
    ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<>();
    Consultas query = new Consultas();

    public ArrayList<DeudasPorProyectoVo> deudasProyectos(Double limiteInferior) throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        try {
            statement = connection.prepareStatement(query.consultasAdeudados(limiteInferior));
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
