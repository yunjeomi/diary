package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	public int addTodo(Todo todo) {
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			returnCnt = this.todoDao.insertTodo(conn, todo);
			System.out.println("todo입력 성공1, 실패0-> "+returnCnt);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnCnt;
	}
}
