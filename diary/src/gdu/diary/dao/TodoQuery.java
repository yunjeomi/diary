package gdu.diary.dao;

public class TodoQuery {
	public final static String DELETE_TODO_BY_MEMBER;
	public final static String INSERT_TODO;
	
	
	static {
		DELETE_TODO_BY_MEMBER = "DELETE FROM todo WHERE member_no=?";
		INSERT_TODO = "INSERT INTO todo(member_no, todo_date, todo_title, todo_content, todo_font_color, todo_add_date) VALUES(?, ?, ?, ?, ?, NOW())";
	}
}
