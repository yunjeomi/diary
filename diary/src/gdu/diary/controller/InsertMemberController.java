package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;


@WebServlet("/insertMember")
public class InsertMemberController extends HttpServlet {
	private MemberService memberService;
	//login에서 회원가입 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집 없음
		//setAtrribute()없음
		//forward
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/insertMember.jsp");
		rd.forward(request, response);
	}
	
	//insertMember.jsp에서 가입버튼 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 수집
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//수집값 넣어주기
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println("회원가입 정보-> "+member.toString());
		
		//id 중복 확인
		int cnt = 0;
		cnt = this.memberService.addMemberCheckId(memberId);
		if(cnt != 0) {	//이미 존재하는 id
			System.out.println("*이미 존재하는 id입니다.*");
			response.sendRedirect(request.getContextPath()+"/insertMember");
			return;
		}
		
		//회원가입 실행
		this.memberService.addMember(member);
		System.out.println("*회원가입 완료*");
		
		//sendRedirect
		response.sendRedirect(request.getContextPath()+"/login");
	}


}
