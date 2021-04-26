package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoDao {
	
	public int insertTodo(Connection conn, Todo todo) throws Exception{
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.INSERT_TODO);
			stmt.setInt(1, todo.getMemberNo());
			stmt.setString(2, todo.getTodoDate());
			stmt.setString(3, todo.getTodoTitle());
			stmt.setString(4, todo.getTodoContent());
			stmt.setString(5, todo.getTodoFontColor());
			System.out.println("insertTodo stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		
		return returnCnt;
	}
	
	public int deleteTodoByMember(Connection conn, int memberNo) throws Exception{
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			System.out.println("deleteTodoByMember stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		
		return returnCnt;
	}
}
