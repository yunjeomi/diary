package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.vo.Todo;

public class TodoDao {
	
	
	
	public List<Todo> selectTodoListByDate(Connection conn, int memberNo, int targetYear, int targetMonth) throws Exception{
		List<Todo> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_LIST_BY_DATE);
			stmt.setInt(1, memberNo);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			System.out.println("selectTodoListByDate stmt-> "+stmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoNo(rs.getInt("todoNo"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
				list.add(todo);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
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
