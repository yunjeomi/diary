package gdu.diary.dao;

public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY;
	public final static String INSERT_MEMBER;
	public final static String INSERT_MEMBER_CHECK_ID;
	public final static String UPDATE_MEMBER_PW;
	public final static String DELETE_MEMBER;
	
	static {
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId, member_date memberDate FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?, ?, NOW())";
		INSERT_MEMBER_CHECK_ID = "SELECT COUNT(member_id) cnt FROM member WHERE member_id=?";
		UPDATE_MEMBER_PW = "UPDATE member SET member_pw=PASSWORD(?) WHERE member_id=?";
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
	}
}
