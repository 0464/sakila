package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.RentalListQuery;
import sakila.vo.Rental;

public class RentalListDao {
	// 대여 목록 출력 메서드
	public ArrayList<Rental> selectRentalList(Connection conn, int beginRow, int rowperPage) throws Exception {
		ArrayList<Rental> list = new ArrayList<Rental>();
		
		PreparedStatement stmt = conn.prepareStatement(RentalListQuery.SELECT_RENTAL_LIST);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowperPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Rental rentalList = new Rental();
			rentalList.setRentalId(rs.getInt("rental_id"));
			rentalList.setTitle(rs.getString("title"));
			rentalList.setRentalDate(rs.getString("rental_date"));
			rentalList.setReturnDate(rs.getString("return_date"));
			list.add(rentalList);
		}
		return list;
	}
	// 대여 목록 검색 출력 메서드
	public ArrayList<Rental> selectRentalSearchList(Connection conn, String search) throws Exception {
		ArrayList<Rental> list = new ArrayList<Rental>();
		
		PreparedStatement stmt = conn.prepareStatement(RentalListQuery.SELECT_RENTAL_SEARCH_LIST);
		stmt.setInt(1, Integer.parseInt(search));
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Rental rentalList = new Rental();
			rentalList.setRentalId(rs.getInt("rental_id"));
			rentalList.setTitle(rs.getString("title"));
			rentalList.setRentalDate(rs.getString("rental_date"));
			rentalList.setReturnDate(rs.getString("return_date"));
			list.add(rentalList);
		}
		return list;
	}
	// 대여 목록 카운트 메서드
	public int countRentalList(Connection conn) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(RentalListQuery.SELECT_COUNT_RENTAL_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
	// 반납 메서드
	public void deleteRental(Connection conn, int rentalId) throws Exception {
		
		PreparedStatement stmt = conn.prepareStatement(RentalListQuery.DELETE_RENTAL);
		stmt.setInt(1, rentalId);
		
		stmt.executeUpdate();
	}
}
