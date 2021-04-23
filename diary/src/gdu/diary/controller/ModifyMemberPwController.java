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


@WebServlet("/auth/modifyMemberPw")
public class ModifyMemberPwController extends HttpServlet {
	private MemberService memberService;
	//memberOne.jsp에서 변경 버튼 눌렀을 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션값 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("sessionMember");
		
		//forward
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyMemberPw.jsp").forward(request, response);
	}
	
	//updateMemberPw.jsp에서 변경 버튼 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수집
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String memberPw = request.getParameter("memberPw");
		
		//수집한 값 member에 넣어주기
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(memberPw);
		System.out.println("비밀번호 수정 멤버정보-> "+member.toString());
		
		//모델실행
		this.memberService = new MemberService();
		int cnt = 0;
		cnt = this.memberService.modifyMemberPw(member);
		if(cnt==0) {	//비밀번호 변경 실패
			response.sendRedirect(request.getContextPath()+"/auth/modifyMemberPw");
			System.out.println("*비밀번호 변경 완료*");
			return;
		}
		System.out.println("*비밀번호 변경 완료*");
		System.out.println("*다시 로그인 해주세요*\n");
		
		//페이지 이동 - 재로그인 필요
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}


}
