package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.dao.MemberDao;
import gdu.diary.vo.Member;


@WebServlet("/auth/updateMember")
public class UpdateMemberPwController extends HttpServlet {
	//memberOne.jsp에서 변경 버튼 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		String memberId = request.getParameter("memberId");
		System.out.println("회원정보-> "+memberId);
		
		//forward
		request.setAttribute("memberId", memberId);
		request.getRequestDispatcher("/WEB-INF/view/member/updateMemberPw.jsp").forward(request, response);
	}
	
	//updateMemberPw.jsp에서 변경 버튼 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//수집한 값 member에 넣어주기
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println("비밀번호 수정 멤버정보-> "+member.toString());
		
		//service?dao?실행
		
		//세션초기화
		
		//페이지 이동
	}


}
