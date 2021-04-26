package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;
import gdu.diary.vo.TodoDate;


@WebServlet("/auth/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	//diary.jsp에서 일을 클릭했을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		
		//미리 만들어놓은 vo에 year,month,day를 넣어준다.
		TodoDate todoDate = new TodoDate();
		todoDate.setYear(year);
		todoDate.setMonth(month);
		todoDate.setDay(day);
		
		//디버깅
		System.out.println("선택한todoDate-> "+todoDate);	//toString()
		
		//forward
		request.setAttribute("todoDate", todoDate);
		request.getRequestDispatcher("/WEB-INF/view/auth/addTodo.jsp").forward(request, response);
	}
	
	//todo Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		HttpSession session = request.getSession();
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		String todoDate = request.getParameter("todoDate");
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");
		Todo todo = new Todo();
		todo.setMemberNo(memberNo);
		todo.setTodoDate(todoDate);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoFontColor(todoFontColor);
		
		//디버깅
		System.out.println("todo-> "+todo);	//toString()
		
		//서비스 호출
		this.todoService = new TodoService();
		this.todoService.addTodo(todo);
		System.out.println("*Todo입력완료*");
		
		//다이어리 컨트롤러에 year와 month를 넘겨주기 위해 date를 자른다
		String[] arr = todoDate.split("-"); //arr[0]="yyyy" arr[1]="mm" arr[2]="dd"
		
		//다이어리 메인 페이지로 이동
		//월을 -1 해주기 위해 string->int 변환
		response.sendRedirect(request.getContextPath()+"/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1));
	}


}
