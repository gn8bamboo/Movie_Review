package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.*;


public class ActorDAO {
	
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	
	public List getActorList(){
		
		String strSql = "select aname from actor ";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Actor actor = new Actor();
				actor.setAname(rs.getString("aname"));
				lstList.add(actor);
				
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
