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
    // 세션이 지금 생성 된 세션이면 statsService.countStats() 호출
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
