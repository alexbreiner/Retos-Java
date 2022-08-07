/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.consultas.Consultas;
import util.JDBCUtilities;

/**
 *
 * @author Alex Delgado
 */
public class ProyectosDao {
    PreparedStatement statement;
    ResultSet resultSet;
    Consultas query = new Consultas();
    private DefaultTableModel model;
    
    private DefaultTableModel setTitulos() {
        model = new DefaultTableModel();
        model.addColumn("Id Proyecto");
        model.addColumn("Constructora");
        model.addColumn("Numero Habitaciones");
        model.addColumn("Ciudad");
        return model;
    }
    
    public DefaultTableModel getDatosProyectosGui() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        try {
            setTitulos();
            statement = connection.prepareStatement(query.informe2());
            resultSet = statement.executeQuery();
            Object[] filas = new Object[4];
            while (resultSet.next()){
                filas[0] = resultSet.getInt(1);
                filas[1] = resultSet.getString(2);
                filas[2] = resultSet.getInt(3);
                filas[3] = resultSet.getString(4);
                model.addRow(filas);
            }
        }catch (SQLException e) {
            System.err.println("Error al listar los datos de los proyectos: " + e.getMessage());
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
