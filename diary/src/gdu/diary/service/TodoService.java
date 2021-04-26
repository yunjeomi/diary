package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	
	//todo 삭제 메소드
	public int removeTodoOne(int todoNo, int memberNo) {
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			returnCnt = this.todoDao.deleteTodoOne(conn, todoNo, memberNo);
			System.out.println("todo삭제 완료 1, 실패 0-> "+returnCnt);
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
	
	//todo 수정 메소드
	public int modifyTodoOne(Todo todo) {
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			returnCnt = this.todoDao.updateTodoOne(conn, todo);
			System.out.println("todo수정 완료 1, 실패 0-> "+returnCnt);
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
	
	//todo 하나 보기 메소드
	public Todo getTodoOne(int todoNo, int memberNo){
		Todo todoOne = new Todo();
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			todoOne = this.todoDao.selectTodoOne(conn, todoNo, memberNo);
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
		return todoOne;
	}
	
	//todo 추가 메소드
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
