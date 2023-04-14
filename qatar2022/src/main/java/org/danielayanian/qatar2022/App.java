package org.danielayanian.qatar2022;


import static org.danielayanian.qatar2022.connections.ConectorMySQL.DB_URL;
import static org.danielayanian.qatar2022.connections.ConectorMySQL.PASS;
import static org.danielayanian.qatar2022.connections.ConectorMySQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
  
	public static void main( String[] args ){
        
		Connection conexion = null;
		Statement consulta = null;
			
			try {
				
		        conexion = DriverManager.getConnection(DB_URL, USER, PASS);
		        
		        consulta = conexion.createStatement();
		        
		        //Insertar un nuevo empleado
		        String sql = "INSERT INTO qatar2022.empleados (dni, nombre ,apellido, nacionalidad, idDepartamento) values (3134, 'daniel', 'ayanian', 'argentino', 1)";
		        consulta.executeUpdate(sql);
		        
		        //Modificar nacionalidad de un empleado
		        sql = "UPDATE qatar2022.empleados SET nacionalidad = 'chilena' WHERE dni=3131";
		        consulta.executeUpdate(sql);
		       
		        //Eliminar un departamento
		        sql = "DELETE from qatar2022.departamentos WHERE id=2";
		        consulta.executeUpdate(sql);
		        
		        //Mostrar departamentos ordenados alfabéticamente
		        sql = "SELECT nombre from qatar2022.departamentos order by nombre asc";
		        ResultSet resultado = consulta.executeQuery(sql);
		        
		        while(resultado.next()){
		        	System.out.println(resultado.getString(1));
		        }
		        
		        //Cierra la conexión a la base de datos
		        resultado.close();
		        consulta.close();
		        conexion.close();
	        
			 }catch(SQLException e){		 
			 }finally{
				 
		        try{
		        	
		            if(consulta != null) consulta.close();
		        
		        }catch(SQLException e){  }
		        
		        try{
		            
		        	if(conexion != null) conexion.close();
		       
		        }catch(SQLException e){ }
	   
			 }
	       
	}
}
		  
