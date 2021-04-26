package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Todo;


@WebServlet("/auth/modifyTodoOne")
public class ModifyTodoOneController extends HttpServlet {
	private TodoService todoService;
	//todoOne.jsp에서 수정 클릭했을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		//디버깅
		System.out.println("memberNo-> "+memberNo);
		System.out.println("todoNo-> "+todoNo);
		
		//모델호출
		this.todoService = new TodoService();
		Todo todoOne = this.todoService.getTodoOne(todoNo, memberNo);
		
		//forward
		request.setAttribute("todoOne", todoOne);
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyTodoOne.jsp").forward(request, response);
	}

	//modify Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");
		
		//수집 값 vo에 넣어주기
		Todo todo = new Todo();
		todo.setMemberNo(memberNo);
		todo.setTodoNo(todoNo);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoFontColor(todoFontColor);
		System.out.println("수정할 내용-> "+todo);
		
		//모델호출
		this.todoService = new TodoService();
		this.todoService.modifyTodoOne(todo);
		System.out.println("*todo 수정완료*\n");
		
		//페이지이동
		response.sendRedirect(request.getContextPath()+"/auth/todoOne?todoNo="+todoNo+"&memberNo="+memberNo);
	}

}
