package gdu.diary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBDriveListener
 *
 */
@WebListener
public class DBDriveListener implements ServletContextListener {
	//톰캣 부팅 시
	public void contextInitialized(ServletContextEvent sce)  { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println(this.getClass()+"DB Driver 로딩 성공");	//getClass->Object를 상속받아서 사용 가능; 자기자신 클래스의 위치를 리턴한다.
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver 로딩 실패");
			e.printStackTrace();
		}
	}

	//생성자
    public DBDriveListener() {
    	
    }

    //톰캣 종료 시
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	
}
