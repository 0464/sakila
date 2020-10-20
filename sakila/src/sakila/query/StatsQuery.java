package sakila.query;

public class StatsQuery {
	// StatsDao.selectDay
	public static final String SELECT_DAY ="SELECT day, count FROM stats WHERE day=?";
	// StatsDao.insertStats
	public static final String INSERT_STATS ="INSERT INTO stats(day, count) VALUES(?, 1)";
	// StatsDao.updateStats
	public static final String UPDATE_STATS ="UPDATE stats SET count=count+1 WHERE day";
}
