package com.movie.myapps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.myapps.domain.*;

public class CommentDAO {
	
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	
	
	public List getCommentList(){
		
		String strSql = "select  distinct title from review r, comments_on c where r.revid = c.revid";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				
				Comment comment = new Comment();
				//review.setRevid(rs.getInt("revid"));
				//review.setRating(rs.getInt("rating"));
				//review.setText(rs.getString("text"));
				comment.setTitle(rs.getString("title"));
				//review.setMname(rs.getString("mname"));
				lstList.add(comment);
				
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
