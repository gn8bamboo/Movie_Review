package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.Act;
import com.movie.myapps.domain.Movie;
import com.movie.myapps.domain.Search;

public class SearchDAO {
	
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	public List getMovieSearchList(String title){
		
		String strSql = "select distinct title from acts_in where title like '%"+title+"%' ";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		
		try {
			
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Search search = new Search();
				//search.setAname(rs.getString("aname"));
				//search.setRole(rs.getString("role"));
				search.setTitle(rs.getString("title"));
				lstList.add(search);
				
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
	
public List getActorSearchList(String name){
		
		String strSql = "select distinct aname from acts_in where aname like '%"+name+"%'";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		
		try {
			
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Search search = new Search();
				search.setAname(rs.getString("aname"));
				//search.setRole(rs.getString("role"));
				//search.setTitle(rs.getString("title"));
				lstList.add(search);
				
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
