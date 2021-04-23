package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;

public class TodoDao {
	private DBUtil dbUtil;
	
	public int deleteTodoByMember(Connection conn, int memberNo) throws Exception{
		this.dbUtil = new DBUtil();
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			System.out.println("deleteTodoByMember stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(conn, stmt, null);
		}
		
		return returnCnt;
	}
}
