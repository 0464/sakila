package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBlistener implements ServletContextListener {

    public DBlistener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("DBListener.contextInitialized() 실행");
         try {
        	 Class.forName("org.mariadb.jdbc.Driver");
        	 System.out.println("mariaDB 드라이브로딩 성공");
         } catch (ClassNotFoundException e) {
        	 System.out.println("Class.forName() 실행 실패!");
        	 e.printStackTrace();
         }
    }
}
