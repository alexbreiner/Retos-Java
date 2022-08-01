package model.dao;

import model.vo.ProyectoBancoVo;
import util.JDBCUtilities;
import java.sql.*;
import java.util.*;

public class ProyectoBancoDao {
    public String consulta1 = "--EJERCICIO 2 RETO 3\n" +
            "SELECT ID_Proyecto AS ID, Constructora, Ciudad, Proyecto.Clasificacion, Estrato,\n" +
            "Nombre ||' '||Primer_Apellido ||' '|| Segundo_Apellido AS LIDER\n" +
            "FROM Proyecto JOIN Tipo USING (ID_Tipo) JOIN Lider USING (ID_LIDER)\n" +
            "WHERE Banco_Vinculado= 'Conavi'\n" +
            "ORDER BY Fecha_Inicio DESC, Ciudad ASC, Constructora;";

    public ArrayList<ProyectoBancoVo> listaDeBancos() throws SQLException {
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        Connection connection = JDBCUtilities.getConnection();
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            statement = connection.prepareStatement(consulta1);
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
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return respuesta;
    }
}
