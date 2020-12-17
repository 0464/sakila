package sakila.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	// db접근 메서드
	public Connection getConnection() throws Exception {
		// db 주소 포트 이름
		final String dbUrl="jdbc:mariadb://127.0.0.1/sakila";
		final String dbId="root";
		final String dbPw="java1004";
		
		Connection conn;
		// db 접속
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		// auto commit 비활성화
		conn.setAutoCommit(false);
		return conn;
	}
}
