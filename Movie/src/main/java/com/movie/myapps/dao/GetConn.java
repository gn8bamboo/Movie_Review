package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConn {
	
	
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement stmt = null;
	public GetConn() { 
	}
	
	public Connection getConnection() {
		 try
	        {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        } catch(ClassNotFoundException e){
	        System.out.println("Could not load the driver"+e.getMessage());
	        }
		 
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@dataserv.mscs.mu.edu:1521:orcl","sun", "bamboo0222");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	
/*	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			result = 0;
		}
		try {
			stmt.close();
		} catch (SQLException ex1) {
		}
		return result;
	}*/
	
	
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	

}
