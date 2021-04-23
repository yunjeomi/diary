package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;

@WebServlet("/auth/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	
	//memberOne에서 회원탈퇴 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션값을 멤버로
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("sessionMember");
		
		//멤버정보 넣고 넘겨준다. forward
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/auth/removeMember.jsp").forward(request, response);
	}
	
	//deleteMember.jsp에서 정보 입력하고 회원탈퇴 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체 생성
		this.memberService = new MemberService();
		
		//수집
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String memberPw = request.getParameter("memberPw");
		
		//수집한 값 member에 넣기
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(memberPw);
		System.out.println("탈퇴 멤버정보-> "+member.toString());
		
		//service -> 회원탈퇴와 글삭제를 동시에 진행한다.
		boolean result = this.memberService.removeMemberByKey(member);
		if(result == false) {//false; 탈퇴실패
			System.out.println("*탈퇴실패*");
			response.sendRedirect(request.getContextPath()+"/auth/removeMember");	//기존 입력 페이지로 이동
			return;
		}
		//true 회원탈퇴 성공
		System.out.println("*회원 탈퇴 완료*");
		
		//페이지 이동
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}


}
