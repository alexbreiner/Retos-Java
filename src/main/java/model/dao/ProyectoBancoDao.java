package model.dao;

import model.consultas.Consultas;
import model.vo.ProyectoBancoVo;
import util.JDBCUtilities;
import java.sql.*;
import java.util.*;

public class ProyectoBancoDao {
    PreparedStatement statement;
    ResultSet resultSet;
    Consultas query = new Consultas();
    ArrayList<ProyectoBancoVo> respuesta = new ArrayList<>();
    
    public ArrayList<ProyectoBancoVo> listaDeBancos(String banco) throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        try {
            statement = connection.prepareStatement(query.consultaBancos(banco));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProyectoBancoVo listBank = new ProyectoBancoVo();
                listBank.setId(resultSet.getInt("ID"));
                listBank.setConstructora(resultSet.getString("Constructora"));
                listBank.setCuidad(resultSet.getString("Ciudad"));
                listBank.setClasificacion(resultSet.getString("Clasificacion"));
                listBank.setEstrato(resultSet.getInt("Estrato"));
                listBank.setLider(resultSet.getString("LIDER"));
                respuesta.add(listBank);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return respuesta;
    }
}
