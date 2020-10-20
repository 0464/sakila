package sakila.dao;

import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// 총 집계 메서드
	public Stats selectTotalDay (Connection conn) throws Exception {
		Stats returnStats = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS_TOTAL);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setCnt(rs.getLong("SUM(cnt)"));
		}
		return returnStats;
	}
	// 오늘 날짜의 유무를 판단하는 메서드
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		// query SELECT_DAY를 호출
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setCnt(rs.getLong("cnt"));
			returnStats.setDay(rs.getString("day"));
		}
		return returnStats;
	}
	// 일이 바뀌면 바뀐날짜마다 삽입하는 메서드
	public void insertStats(Connection conn, Stats stats) throws Exception {
		// query INSERT_STATS 호출
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
	}
	// 스탯 +1 업데이트 메서드
	public void updateStats(Connection conn, Stats stats) throws Exception {
		// query UPDATE_STATS 호출
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
	}
	// DB 연결 메서드
	public Connection getConnection() throws Exception {
		final String dbaddr = "jdbc:mariadb://localhost:3306/sakila";
		final String dbid = "root";
		final String dbpw = "java1004";
		Connection conn = DriverManager.getConnection(dbaddr, dbid, dbpw);
		return conn;
	}
}
