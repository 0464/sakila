package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	
	private StatsDao statsDao;
	
	// 캘린더 메서드 정보은닉 and 중복된 코드를 줄이는 메서드
	public String getToday() {
		// 캘린더로 오늘 일자 변수 입력
		Calendar today = Calendar.getInstance();
		// 포맷 형식 생성
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		// yyyy-MM-dd 타입으로 포맷하고 day 변수에 입력
		String formatStats = formater.format(today.getTime());
		System.out.println("formatStats.day > "+formatStats);
		return formatStats;
	}
	
	public Map<String, Object> getStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// DB 연결
			conn = statsDao.getConnection();
			// 오토커밋 false
			conn.setAutoCommit(false);
			
			Stats stats = new Stats();
			stats.setDay(this.getToday());
			Stats returnToStats = statsDao.selectDay(conn, stats);
			Stats returnStatsTotal = statsDao.selectTotalDay(conn);
			conn.commit();
			// map 형식으로 키값을 넣음
			map.put("returnToStats", returnToStats);
			map.put("returnStatsTotal", returnStatsTotal.getCnt());
		}
		catch (Exception e) {
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
		return map;
	}
	
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		try {
			// DB 연결
			conn = statsDao.getConnection();
			// 오토커밋 false
			conn.setAutoCommit(false);
			
			Stats stats = new Stats();
			stats.setDay(this.getToday());

			Stats toStats = statsDao.selectDay(conn, stats);
			System.out.println("toStats > "+toStats);
			// 오늘 일자가 없으면 인서트 아니면 업데이트
			if(toStats == null) {
				statsDao.insertStats(conn, stats);
			} else {
				statsDao.updateStats(conn, toStats);
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
