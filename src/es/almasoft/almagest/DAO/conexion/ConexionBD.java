/*
 * ConexionBD.java
 *
 * Creado el 22-may-2016  14:20:43
 *
 * Copyright(c)2016. Alma Software. Todos los derechos reservados.
 *
 */
package es.almasoft.almagest.DAO.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * {Clase que establece la conexión con la base de datos}
 *
 * @author Alfonso Maldonado. amdelgado@gmail.com
 */
public class ConexionBD {

    private String url = "jdbc:postgresql://localhost/almabd";
    private String login = "almabd";
    private String password = "kgh43591";
    private String bd = "almabd";
    private Connection conn;

    public ConexionBD() {

        try {
            //obtenemos el driver de para mysql
            Class.forName("org.postgresql.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
            conn.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión con la base de datos cerrada");
        } catch (Exception e) {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }

}
