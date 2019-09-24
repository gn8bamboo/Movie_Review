package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.*;

public class ReviewDAO {
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	
	public List getReviewList(){
		
		String strSql = "select distinct title from review";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Review review = new Review();
				//review.setRevid(rs.getInt("revid"));
				//review.setRating(rs.getInt("rating"));
				//review.setText(rs.getString("text"));
				review.setTitle(rs.getString("title"));
				//review.setMname(rs.getString("mname"));
				lstList.add(review);
				
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
