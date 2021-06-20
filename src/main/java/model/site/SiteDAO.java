package model.site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
public class SiteDAO {
	public SiteDAO() {}
	private static SiteDAO instance = new SiteDAO();
	
	
	public static SiteDAO getInstance() {
		return instance;
	}
	public int convertURI(SiteVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int num=0;
		
		try {
			String query="INSERT INTO shortUri(regDate,updateDate,memberId,shortCode,originUri,`text`,blanklessText, accessCount) "
					+ "VALUES(now(),now(),0,?,?,?,?,0)";
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(query);

			pstmt.setString(1, vo.getShortCode());
			pstmt.setString(2, vo.getOriginUri());
			pstmt.setString(3, vo.getText());
			pstmt.setString(4, vo.getBlanklessText());
		
			num=pstmt.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();

		}finally {
			
			try {
				DBManager.close(conn, pstmt,rs);
			} catch (Exception ee) {
			}
		}
		return num;

	}
	public int contrastUri(String shortCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int num=0;
		String query="select count from shortUri where shortCode=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			pstmt.setString(1, shortCode);
			if(rs.next()) {
				num=(rs.getInt(1));
			}
		
			
		}catch (Exception e) {
			try {
				DBManager.close(conn, pstmt,rs);
			} catch (Exception ee) {
			}

		}
		return num;
	}
	public String unContrastUri(String shortCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String str="";
		String query="select originUri from shortUri where shortCode=?";
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, shortCode);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				str=(rs.getString(1));
			}
		
			
		}catch (Exception e) {
			try {
				DBManager.close(conn, pstmt,rs);
			} catch (Exception ee) {
			}

		}
		return str;

	}




public int selectOrigin(String origin) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	int num=0;
	String query="select count(*) from shortUri where originUri=?";
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, origin);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			num=(rs.getInt(1));
		}
	
		
	}catch (Exception e) {
		try {
			DBManager.close(conn, pstmt,rs);
		} catch (Exception ee) {
		}

	}
	return num;

}


public String getShort(String origin) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String str="";
	String query="select shortCode from shortUri where originUri=?";
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, origin);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			str=(rs.getString(1));
		}
	
		
	}catch (Exception e) {
		try {
			DBManager.close(conn, pstmt,rs);
		} catch (Exception ee) {
		}

	}
	return str;

}
}








