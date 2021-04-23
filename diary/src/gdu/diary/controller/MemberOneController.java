package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.vo.Member;


@WebServlet("/auth/myAccount")
public class MemberOneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집 - 세션값을 가져온다.
		HttpSession session = request.getSession();
		session.getAttribute("sessionMember");
		
		//member에 세션값을 넣어준다.
		Member member = (Member)session.getAttribute("sessionMember");
		
		//forward - 멤버값을 memberOne.jsp로 보내준다
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/auth/memberOne.jsp").forward(request, response);
	}

}
