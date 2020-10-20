package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
// 세션이 생성되는것을 감지
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
    public StatsListener() {
    	
    }
    // 세션이 생성된 시점에 원래 있던 세션에 생성되었는지 아니면 이미 있던 세션인지 확인
    public void sessionCreated(HttpSessionEvent se)  { 
    	if(se.getSession().isNew()) {
    		statsService = new StatsService();
    		statsService.countStats();
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
