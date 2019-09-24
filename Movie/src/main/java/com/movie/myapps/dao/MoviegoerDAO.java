package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.Moviegoer;

public class MoviegoerDAO {
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	 public boolean CheckLogin (String name,String pwd){
		
		String strSql = "select * from moviegoer where mname = '"+name+"' and password='"+pwd+"'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	 
	 
	 
	 public List getMoviegoerList(){
	
	String strSql = "select mname from moviegoer ";
	Statement pstmt = null;
	ResultSet rs = null;
	List lstList = new ArrayList();
	try {
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(strSql);
		while (rs.next()) {
			
			Moviegoer moviegoer = new Moviegoer();
			moviegoer.setMname(rs.getString("mname"));
			lstList.add(moviegoer);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) {
				rs.close();
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return lstList;
	
}
	 
	 
	 public void InsertUser(Moviegoer moviegoer){
		 
			String strSql = "insert into moviegoer values(?,?,?,?,?,?,?,?)";
			System.out.println(strSql);
			PreparedStatement pstmt = null;
		
			try {
				pstmt = conn.prepareStatement(strSql);
				pstmt.setString(1, moviegoer.getMname());
				pstmt.setString(2, moviegoer.getStreet());
				pstmt.setString(3, moviegoer.getCity());
				pstmt.setString(4, moviegoer.getState());
				pstmt.setInt(5, moviegoer.getZip());
				pstmt.setString(6, moviegoer.getPhone());
				pstmt.setString(7, moviegoer.getEmail());
				pstmt.setString(8, moviegoer.getPassword());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		} 
		 
	 }
	

	 
	
