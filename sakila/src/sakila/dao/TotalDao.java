package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.vo.*;

public class TotalDao {
	// 매장별 판매량 출력 메서드
	public ArrayList<Total> selectStoreTotal(Connection conn) throws Exception {
		ArrayList<Total> list = new ArrayList<Total>();
		
		PreparedStatement stmt = conn.prepareStatement(TotalQuery.SELECT_STORE_TOTAL);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Total totalList = new Total();
			totalList.setStore(rs.getString("store"));
			totalList.setManager(rs.getString("manager"));
			totalList.setTotalSales(rs.getInt("total_sales"));
			list.add(totalList);
		}
		return list;
	}
	// 카테고리별 판매량 출력 메서드
	public ArrayList<Total> selectCategoryTotal(Connection conn) throws Exception {
		ArrayList<Total> list = new ArrayList<Total>();
		
		PreparedStatement stmt = conn.prepareStatement(TotalQuery.SELECT_CATEGORY_TOTAL);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Total totalList = new Total();
			totalList.setCategory(rs.getString("category"));
			totalList.setTotalSales(rs.getFloat("total_sales"));
			list.add(totalList);
		}
		return list;
	}
}
