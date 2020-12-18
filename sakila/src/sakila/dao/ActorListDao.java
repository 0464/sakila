package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.ActorListQuery;
import sakila.vo.Actor;

public class ActorListDao {
	// 배우 목록 출력 메서드
	public ArrayList<Actor> selectActorList(Connection conn, int beginRow, int rowperPage) throws Exception {
		ArrayList<Actor> list = new ArrayList<Actor>();
		
		PreparedStatement stmt = conn.prepareStatement(ActorListQuery.SELECT_ACTOR_LIST);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowperPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Actor actorList = new Actor();
			actorList.setActorId(rs.getInt("actor_id"));
			actorList.setFirstName(rs.getString("first_name"));
			actorList.setLastName(rs.getString("last_name"));
			list.add(actorList);
		}
		return list;
	}
	// 배우 목록 카운트 메서드
	public int countActorList(Connection conn) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(ActorListQuery.SELECT_COUNT_ACTOR_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
	// 배우 상세보기 출력 메서드
	public ArrayList<Actor> selectActorOne(Connection conn, Actor paramActor) throws Exception {
		ArrayList<Actor> list = new ArrayList<Actor>();
		
		PreparedStatement stmt = conn.prepareStatement(ActorListQuery.SELECT_ACTOR_ONE);
		stmt.setInt(1, paramActor.getActorId());
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Actor actorList = new Actor();
			actorList.setActorId(rs.getInt("actor_id"));
			actorList.setFirstName(rs.getString("first_name"));
			actorList.setLastName(rs.getString("last_name"));
			actorList.setFilmInfo(rs.getString("film_info"));
			list.add(actorList);
		}
		return list;
	}
}
