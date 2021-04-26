package gdu.diary.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.DiaryService;
import gdu.diary.vo.Member;


@WebServlet("/auth/diary")
public class DiaryController extends HttpServlet {
	private DiaryService diaryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.diaryService = new DiaryService();
		//전처리를 하지 않아 문자로 넘어간다.
		//아예 값이 넘어오지 않으면 null값이 넘어 온다.
		String targetYear = request.getParameter("targetYear");
		String targetMonth = request.getParameter("targetMonth");
		HttpSession session = request.getSession();
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		
		//모델 호출
		Map<String, Object> diaryMap = this.diaryService.getDiary(memberNo, targetYear, targetMonth);
		
		request.setAttribute("diaryMap", diaryMap);
		
		//view ; diary.jsp
		request.getRequestDispatcher("/WEB-INF/view/auth/diary.jsp").forward(request, response);
	}


}
