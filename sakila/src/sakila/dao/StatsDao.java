package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	// 오늘 날짜의 유무를 판단하는 메서드 있으면 true, 없으면 false
	public boolean selectDay(Connection conn, Stats stats) throws Exception {
		/*
		if(rs.next()) {
			return true; // update 실행
		}
		return false; // insert 실행
		*/
	}
	// 일마다 삽입하는 메서드
	public void insertStats(Connection conn, Stats stats) throws Exception {
		
	}
	// 스탯 업데이트 메서드
	public void updateStats(Connection conn) throws Exception {
		
	}
}
