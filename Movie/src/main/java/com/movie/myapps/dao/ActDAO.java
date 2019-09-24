package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.Act;
import com.movie.myapps.domain.Movie;

public class ActDAO {
	
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	public List getMovieDetailList(String title){
		
		String strSql = "select  * from acts_in where role = 'Actor' and title = '"+title+"' ";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		
		try {
			
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Act act = new Act();
				act.setAname(rs.getString("aname"));
				act.setRole(rs.getString("role"));
				act.setTitle(rs.getString("title"));
				lstList.add(act);
				
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
	
public List getActorDetailList(String name){
		
		String strSql = "select  * from acts_in where aname = '"+name+"' ";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		
		try {
			
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Act act = new Act();
				act.setAname(rs.getString("aname"));
				act.setRole(rs.getString("role"));
				act.setTitle(rs.getString("title"));
				lstList.add(act);
				
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
	

}
