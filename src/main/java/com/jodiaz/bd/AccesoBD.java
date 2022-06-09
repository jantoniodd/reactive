package com.jodiaz.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoBD {

    Connection connection;

    Statement operacion;

    ResultSet respuesta;

    String sentencia;

    public AccesoBD() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancario", "jadd", "123456");

            System.out.println("CONEXION ESTABLECIDA");

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

    }

    public List<String> cargarProvincias() {

        List<String> provincias = new ArrayList<>();

        String query = "SELECT nombre FROM bancario.datos WHERE prov <> '00' and dist = '00'; ";

        try {

            operacion = connection.createStatement();

            respuesta = operacion.executeQuery(query);

            while (respuesta.next()) {

                provincias.add(respuesta.getString("nombre"));

            }

            respuesta.close();
            operacion.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return provincias;

    }

    public List<Lugar> cargarProvinciasObjeto() {

        List<Lugar> provincias = new ArrayList<>();

        String query = "SELECT * FROM bancario.datos WHERE prov <> '00' and dist = '00'; ";

        try {

            operacion = connection.createStatement();

            respuesta = operacion.executeQuery(query);

            while (respuesta.next()) {

                Lugar lugar = new Lugar();
                lugar.setId(respuesta.getInt("id"));
                lugar.setDpto(respuesta.getString("dpto"));
                lugar.setProv(respuesta.getString("prov"));
                lugar.setDist(respuesta.getString("dist"));
                lugar.setNombre(respuesta.getString("nombre"));

                provincias.add(lugar);

            }

            respuesta.close();
            operacion.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return provincias;

    }

}
