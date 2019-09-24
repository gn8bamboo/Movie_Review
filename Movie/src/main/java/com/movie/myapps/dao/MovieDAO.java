package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.*;

public class MovieDAO {
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	
	public List getMovieList(){
		
		String strSql = "select title from movie ";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Movie movie = new Movie();
				movie.setTitle(rs.getString("title"));
				lstList.add(movie);
				
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
