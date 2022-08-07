/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import model.consultas.Consultas;
import util.JDBCUtilities;

/**
 *
 * @author Alex Delgado
 */
public class ComprasDao {
    PreparedStatement statement;
    ResultSet resultSet;
    Consultas query = new Consultas();
    private DefaultTableModel model;
    
    private DefaultTableModel setTitulos() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Constructora");
        model.addColumn("Banco vinculado");
        return model;
    }
    
    public DefaultTableModel getDatosComprasGui() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        try {
            setTitulos();
            statement = connection.prepareStatement(query.informe3());
            resultSet = statement.executeQuery();
            Object[] filas = new Object[3];
            while (resultSet.next()){
                filas[0] = resultSet.getInt(1);
                filas[1] = resultSet.getString(2);
                filas[2] = resultSet.getString(3);
                model.addRow(filas);
            }
        }catch (SQLException e) {
            System.err.println("Error al listar los datos de las compras: " + e.getMessage());
        } finally {
           statement.close();
           resultSet.close();
           if (connection != null) {
               connection.close();
           }
        }
        return model;
    }
}
