/**
 * Funcion_PortSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.examples.www.wsdl.WSPractica_wsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aytos.prueba.COCHE;
import aytos.prueba.LISTACOCHESELEMENTO;

public class Funcion_PortSoapBindingImpl implements com.examples.www.wsdl.WSPractica_wsdl.Funcion_PortType {
	public aytos.prueba.LISTACOCHESELEMENTO[] funcion2(aytos.prueba.CLIENTE param1) throws java.rmi.RemoteException {

		Connection conn = conectarBaseDatos();
		List<String> listaMatriculas = new ArrayList<String>();
		try {
			listaMatriculas = traerMatriculas(conn, param1.getDocumento());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		LISTACOCHESELEMENTO[] respuesta = new LISTACOCHESELEMENTO[listaMatriculas.size()];
		for (int i = 0; i < respuesta.length; i++) {
			try {
				respuesta[i] = traerCoches(conn, listaMatriculas.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return respuesta;
	}

	private static Connection conectarBaseDatos() {
		try {
			try {
				// Se registra el Driver de MySQL
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de MySQL: " + ex);
			}
			Connection connection = null;

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servicios", "root", "");

			boolean valid = connection.isValid(5000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");

			return connection;

		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
			return null;
		}
	}

	private static List<String> traerMatriculas(Connection conn, String documento) throws SQLException {
		String sql = "Select matricula FROM intermedia WHERE documento ='" + documento + "'";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		List<String> res = new ArrayList<String>();
		while (result.next()) {
			res.add(result.getString(1));
		}

		return res;
	}

	private static LISTACOCHESELEMENTO traerCoches(Connection conn, String matricula) throws SQLException {
		String sql = "Select * FROM coche WHERE matricula ='" + matricula + "'";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		result.next();

		COCHE aux = new COCHE(result.getString(1), result.getInt(2), result.getString(3), result.getInt(4));

		LISTACOCHESELEMENTO res = new LISTACOCHESELEMENTO();
		res.setCoche(aux);

		return res;
	}
}
