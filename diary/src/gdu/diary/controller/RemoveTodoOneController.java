package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;


@WebServlet("/auth/removeTodoOne")
public class RemoveTodoOneController extends HttpServlet {
	private TodoService todoService;
	
	//todoOne.jsp에서 삭제 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		//모델호출
		this.todoService = new TodoService();
		this.todoService.removeTodoOne(todoNo, memberNo);
		System.out.println("*todo 삭제완료*\n");
		
		//페이지 이동 -> 메인다이어리로 이동하라
		response.sendRedirect(request.getContextPath()+"/auth/diary");
		
	}
}
