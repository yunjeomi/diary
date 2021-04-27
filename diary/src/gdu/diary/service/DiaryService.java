package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class DiaryService {
	//서비스는 어떤 dao든 호출 할 수 있다.
	private TodoDao todoDao;
	private DBUtil dbUtil;
	//Dao를 따로 호출하지 않고 Service에서만 처리한다.
	public Map<String, Object> getDiary(int memberNo, String targetYear, String targetMonth){
		/*
		 * 타겟 년, 월, 일(날짜)
		 * 타겟 달의 1일(날짜)
		 * 타겟 달의 마지막 일의 숫자 -> endDay
		 * 
		 * startBlank + endDay + endBlank
		 * 전체 셀의 갯수(마지막 일의 숫자보다는 크고 7로 나누어 떨어져야 한다)
		 * 앞의 빈 셀 갯수 -> startBlank = 1일의 위치 값 - 1
		 * 이번달 숫자가 나와야 할 셀의 갯수(1~마지막 날짜)
		 * 뒤의 빈 셀의 갯수 -> endBlank = (7-(startBlank + endDay)%7)
		 */
		
		/*
		int numTargetMonth = 0;
		int numTargetYear = 0;
		
		//넘어온 년/월 세팅
		if(targetMonth != null && targetYear != null) {
			numTargetYear = Integer.parseInt(targetYear);
			numTargetMonth = Integer.parseInt(targetMonth);
			if(numTargetMonth == 0) {
				numTargetYear = numTargetYear - 1;
				numTargetMonth = 12;
			} else if(numTargetMonth == 13) {
				numTargetYear = numTargetYear + 1;
				numTargetMonth = 1;
			}
			target.set(Calendar.YEAR, numTargetYear);
			target.set(Calendar.MONTH, numTargetMonth-1);
		}*/
		
		//1. 캘린더 출력
		Map<String, Object> map = new HashMap<>();
		
		Calendar target = Calendar.getInstance();
		
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		if(targetMonth != null) {
			//두번째 인수값이 -1이면 target의 년을 -1하고, 월은 11(12월)값이 들어간다.
			//두번째 인수값이 12이면 target의 년을 +1하고, 월은 0(1월)값이 들어간다.
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth));
		}
		
		//일은 무조건 1일로 바꿔야 한다.
		target.set(Calendar.DATE, 1);
		//1일 앞에 와야할 빈 셀의 갯수
		int startBlank = target.get(Calendar.DAY_OF_WEEK)-1;
		//마지막 날짜
		int endDay = target.getActualMaximum(Calendar.DATE);
		int endBlank = 0;
		if((startBlank + endDay)%7 != 0) {
			endBlank = 7-(startBlank + endDay)%7;
		}
		//int totalCell = startBlank + endDay + endBlank;
		
		System.out.println("targetYear-> "+targetYear);
		System.out.println("targetMonth-> "+targetMonth);
		System.out.println("startBlank-> "+startBlank);
		System.out.println("endDay-> "+endDay);
		System.out.println("endBlank-> "+endBlank);
		System.out.println();
		
		map.put("targetYear", target.get(Calendar.YEAR));
		map.put("targetMonth", target.get(Calendar.MONTH));
		map.put("startBlank", startBlank);
		map.put("endDay", endDay);
		map.put("endBlank", endBlank);
		
		//2. todo목록 가져와서 추가한다. + 3. dday목록 추가한다.
		this.todoDao = new TodoDao();
		this.dbUtil = new DBUtil();
		
		//todoList
		List<Todo> todoList = null;
		
		//ddayList
		List<Map<String, Object>> ddayList = null;
		
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			todoList = this.todoDao.selectTodoListByDate(conn, memberNo, target.get(Calendar.YEAR), target.get(Calendar.MONTH)+1);
			ddayList = this.todoDao.selectTodoDdayList(conn, memberNo);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		map.put("todoList", todoList);
		map.put("ddayList", ddayList);
		return map;
	}
}
