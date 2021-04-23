package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	private TodoDao todoDao;
	//dao -> service
	//select -> get
	//insert -> add
	//update -> modify
	//delete -> remove
	
	/*
	 * 호출 경로
	 * Controller -> (1)Service(){conn} -> (2)-1 Dao(conn){stmt/rs}.. -2 Dao(conn){stmt/rs}.. -> (3)service(){conn} -> Controller
	 * 
	 * (1)에서 (2)를 호출한다. (1)은 내부 변수로 conn을 갖고 있는데, 이 conn을 (2)에게 매개변수(conn)로 넘겨준다.
	 * (2)는 내부변수로 stmt/rs를 갖고 있는데 (2)의 내부에서 실행하였으니, finally에서 바로 close한다. (Dao가 갖고 있던 stmt/rs를 닫음)
	 * 이 실행과정 중 예외가 발생할 수 있는데, 이 예외는 try-catch 처리하지 않고 throws하여 Service가 대신 예외처리 하도록 한다.
	 * 따라서 (1)은 예외처리를 try-catch구문처리 해주며, 
	 * 더불어 트랜잭션 처리를 위해 (3)에서 한 개 혹은 여러 개의(2)를 실행 한 후 이들을 한번에 실행 할 수 있도록 commit()한다.
	 * 예외가 발생할 경우 catch구문에서 rollback 할 수 있도록 하며 rollback도 예외처리를 해야 하므로 catch구문 안에 try-catch구문을 다시 넣어 rollback() 코드를 넣어준다.
	 * 마지막으로 finally를 써서 (1)의 내부변수로 있던 conn을 close한다.
	 */
	
	//로그인
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
	
	//회원가입 - id중복확인 & 가입 동시에
	public int addMember(Member member) {
		int memberCnt = 0;
		int checkIdCnt = 0;
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			checkIdCnt = this.memberDao.countId(conn, member.getMemberId());
			System.out.println("*id 중복체크 cnt 1중복, 0가입가능*-> "+checkIdCnt);
			if(checkIdCnt==0) {	//Id가 중복 되지 않아 회원가입이 가능한 경우에 회원가입 메소드를 실행 할 것
				memberCnt = this.memberDao.insertMember(conn, member);
				System.out.println("*가입cnt 1성공, 0실패*-> "+memberCnt);
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			this.dbUtil.close(conn, null, null);
		}
		
		return memberCnt;	//최종적으로 memberCnt를 받아 1이면 가입 완료 하도록 하자
	}
	
	//비밀번호 변경
	public int modifyMemberPw(Member member) {
		int returnCnt=0;
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			returnCnt = this.memberDao.updateMemberPw(conn, member);
			System.out.println("*업데이트cnt 1성공, 0실패*-> "+returnCnt);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, null, null);
		}
		
		return returnCnt;
	}
	
	//회원정보 삭제 - todo삭제&탈퇴 동시에
	//삭제 성공 -> true, 삭제 실패(rollback) -> false
	public boolean removeMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int todoRowCnt = 0;
		int memberRowCnt = 0;
		try {
			conn = this.dbUtil.getConnection();
			todoRowCnt = this.todoDao.deleteTodoByMember(conn, member.getMemberNo());
			memberRowCnt = this.memberDao.deleteMemberByKey(conn, member);
			System.out.println("todo삭제 갯수 -> "+todoRowCnt);
			System.out.println("회원탈퇴 성공1, 실패0-> "+memberRowCnt);
			conn.commit();
		} catch (Exception e) {
			try {
				//todoRowCnt성공, memberRowCnt실패 일 때 1은 실행되고 2는 실행되지 않은 상태
				//때문에, 동일한 connection을 쓰고 있는 dao 모두를 롤백해야 한다.
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			this.dbUtil.close(conn, null, null);
		}
		
		return (todoRowCnt+memberRowCnt)>0;
	}
}
