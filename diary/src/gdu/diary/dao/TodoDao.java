package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;

public class TodoDao {
	
	//todo 한개 삭제 메소드
	public int deleteTodoOne(Connection conn, int todoNo, int memberNo) throws Exception{
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_ONE);
			stmt.setInt(1, todoNo);
			stmt.setInt(2, memberNo);
			System.out.println("deleteTodoOne stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return returnCnt;
	}
	
	//todo 수정 메소드
	public int updateTodoOne(Connection conn, Todo todo) throws Exception{
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.UPDATE_TODO_ONE);
			stmt.setString(1, todo.getTodoTitle());
			stmt.setString(2, todo.getTodoContent());
			stmt.setString(3, todo.getTodoFontColor());
			stmt.setInt(4, todo.getTodoNo());
			stmt.setInt(5, todo.getMemberNo());
			System.out.println("updateTodoOne-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return returnCnt;
	}
	
	//todo 하나 보기 메소드
	public Todo selectTodoOne(Connection conn, int todoNo, int memberNo) throws Exception{
		Todo todoOne = new Todo();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_ONE);
			stmt.setInt(1, todoNo);
			stmt.setInt(2, memberNo);
			System.out.println("selectTodoOne stmt-> "+stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				todoOne.setTodoNo(rs.getInt("todoNo"));
				todoOne.setTodoDate(rs.getString("todoDate"));
				todoOne.setTodoTitle(rs.getString("todoTitle"));
				todoOne.setTodoContent(rs.getString("todoContent"));
				todoOne.setTodoFontColor(rs.getString("todoFontColor"));
				todoOne.setTodoAddDate(rs.getString("todoAddDate"));
				todoOne.setMemberNo(rs.getInt("memberNo"));
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return todoOne;
	}
	
	//todo 리스트 출력 메소드
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
	
	//todo 추가 메소드
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
	
	//todo 전체 삭제 메소드
	public int deleteTodoByMember(Connection conn, Member member) throws Exception{
		int returnCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			System.out.println("deleteTodoByMember stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return returnCnt;
	}
}
