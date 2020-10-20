package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.*;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	public void countStats() {
		statsDao = new StatsDao();
		final String URL = "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 오토커밋 false
			conn.setAutoCommit(false);
			// 캘린더에 오늘 일자
			Calendar today = Calendar.getInstance();
			// yyyy-MM-dd 타입으로 포맷
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String day = formater.format(today);
			Stats stats = new Stats();
			stats.setDay(day);
			// 오늘 일자면 업데이트 아니면 인서트
			if(statsDao.selectDay(conn, stats) == true) {
				statsDao.updateStats(conn);
			} else {
				statsDao.insertStats(conn, stats);
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
