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


@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	
	//login에서 회원가입 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집 없음, setAtrribute()없음
		//forward
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addMember.jsp");
		rd.forward(request, response);
	}
	
	//insertMember.jsp에서 가입버튼 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체 생성
		this.memberService = new MemberService();
		
		//request 수집
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//수집값 넣어주기
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println("회원가입 정보-> "+member.toString());
		
		//모델호출 - id체크와 가입을 동시에 진행한다.
		int cnt = 1;
		cnt = this.memberService.addMember(member);
		if(cnt == 1) {	//1; 중복된 id 존재 
			System.out.println("*중복된 id*\n");
			response.sendRedirect(request.getContextPath()+"/addMember");
			return;
		}
		
		//cnt값이 0 일때 회원가입 실행
		System.out.println("*회원가입 완료*");
		
		//sendRedirect - 로그인 페이지로 이동하라
		response.sendRedirect(request.getContextPath()+"/login");
	}


}
