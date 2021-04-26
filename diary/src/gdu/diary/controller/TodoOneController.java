package gdu.diary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;


@WebServlet("/auth/todoOne")
public class TodoOneController extends HttpServlet {
	private TodoService todoService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		HttpSession session = request.getSession();
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		//디버깅
		System.out.println("memberNo-> "+memberNo);
		System.out.println("todoNo-> "+todoNo);
		
		//모델호출
		this.todoService = new TodoService();
		Todo todoOne = new Todo();
		todoOne = (Todo)this.todoService.getTodoOne(todoNo, memberNo);
		
		//forward
		request.setAttribute("todoOne", todoOne);
		request.getRequestDispatcher("/WEB-INF/view/auth/todoOne.jsp").forward(request, response);
	}
}
