package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class DBManager {
    static String driver = "org.mariadb.jdbc.Driver";
    static Connection con;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
 
    public static Connection getConnection() {
         try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/search",
                    "sbsst",
                    "sbs123414");
            
            if( con != null ) {
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
         return con;
    }
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null)
			rs.close();
			if(pstmt!=null)
			pstmt.close();
			if(conn!=null)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
    
    
    public static void main(String[] args){
    	DBManager dbcon    = new DBManager();
    }
}
