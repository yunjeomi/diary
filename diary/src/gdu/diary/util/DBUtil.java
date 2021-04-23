package gdu.diary.util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary", "root", "java1004");
			conn.setAutoCommit(false); //무조건 커밋해주기!!
		} catch (SQLException e) {
			e.printStackTrace();
		}	//try-catch문인데 finally 없는 이유? -> 리턴이 conn인데 close()되면 사용을 못하니까
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
