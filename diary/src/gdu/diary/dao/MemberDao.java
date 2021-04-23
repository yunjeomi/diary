package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberDao {
	private DBUtil dbUtil;
	
	//Dao에서 사용하는 메소드는 throws Exception으로 예외를 던져 이 메소드를 호출한 Service에게 예외를 처리하도록 넘긴다.
	//멤버 삭제 메소드
	public int deleteMemberByKey(Connection conn, Member member) throws Exception{
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER_BY_KEY);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			System.out.println("deleteMember stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		return returnCnt;
	}
	
	
	//비밀번호 변경 메소드
	public int updateMemberPw(Connection conn, Member member) throws Exception{
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_MEMBER_PW);
			stmt.setString(1, member.getMemberPw());
			stmt.setInt(2, member.getMemberNo());
			System.out.println("updateMemberPw stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		return returnCnt;
	}
	
	//id 중복체크 메소드
	public int countId(Connection conn, String memberId) throws Exception {
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.COUNT_ID);
			stmt.setString(1, memberId);
			System.out.println("countId stmt-> "+stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnCnt = rs.getInt("cnt");
			}
		} finally {
			this.dbUtil.close(null, stmt, rs);
		}
		
		return returnCnt;
	}
	
	//회원가입 메소드
	public int insertMember(Connection conn, Member member) throws Exception {
		int returnCnt = 0;
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println("insertMember stmt-> "+stmt);
			returnCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		return returnCnt;
	}
	
	//로그인 메소드
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println("selectMemberByKey stmt-> "+stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
				returnMember.setMemberDate(rs.getString("memberDate"));
			}
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		
		return returnMember;
	}
}
