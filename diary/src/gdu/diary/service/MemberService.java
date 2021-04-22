package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	//dao -> service
	//select -> get
	//insert -> add
	//update -> modify
	//delete -> remove
	public Member getMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Member returnMember = null;
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			returnMember = this.memberDao.selectMemberByKey(conn, member);
			conn.commit(); //커밋 꼭 해주기
		} catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, null, null);
		}
		
		return returnMember;
	}
}
