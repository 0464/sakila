package sakila.query;

public class StatsQuery {
	// StatsDao.selectDay
	public static final String SELECT_DAY ="SELECT day, cnt FROM stats WHERE day=?";
	// StatsDao.insertStats
	public static final String INSERT_STATS ="INSERT INTO stats(day, cnt) VALUES(?, 1)";
	// StatsDao.updateStats
	public static final String UPDATE_STATS ="UPDATE stats SET cnt=cnt+1 WHERE day=?";
	// StatsDao.selectTotalDay
	public static final String SELECT_STATS_TOTAL = "SELECT SUM(cnt) FROM stats";
}
