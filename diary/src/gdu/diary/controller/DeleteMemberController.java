package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.vo.Member;

@WebServlet("/auth/deleteMember")
public class DeleteMemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		String memberId = request.getParameter("memberId");
		System.out.println("회원정보-> "+memberId);
		//forward
		request.setAttribute("memberId", memberId);
		request.getRequestDispatcher("/WEB-INF/view/member/deleteMember.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//수집한 값 member에 넣기
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println("탈퇴 멤버정보-> "+member.toString());
		
		//service -> 회원탈퇴와 글삭제를 동시에 진행한다.
		
		//세션초기화
		
		//페이지 이동
		
	}


}
