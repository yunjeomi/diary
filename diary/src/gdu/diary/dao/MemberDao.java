package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberDao {
	private DBUtil dbUtil;
	//멤버 삭제 메소드
	public void deleteMember(Connection conn, Member member) throws Exception{
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(1, member.getMemberPw());
			System.out.println("deleteMember stmt-> "+stmt);
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, stmt, null);
		}
	}
	
	
	//비밀번호 변경 메소드
	public void updateMemberPw(Connection conn, Member member) throws Exception{
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_MEMBER_PW);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			System.out.println("updateMemberPw stmt-> "+stmt);
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, stmt, null);
		}
		
	}
	
	//id 중복체크 메소드
	public int insertMemberCheckId(Connection conn, String memberId) throws Exception {
		int cnt = 0;
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER_CHECK_ID);
			stmt.setString(1, memberId);
			System.out.println("insertMemberCheckId stmt-> "+stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, stmt, rs);
		}
		
		return cnt;
	}
	
	//회원가입 메소드
	public void insertMember(Connection conn, Member member) throws Exception {
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println("insertMember stmt-> "+stmt);
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, stmt, null);
		}
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
			this.dbUtil.close(conn, stmt, null);
		}
		
		return returnMember;
	}
}
