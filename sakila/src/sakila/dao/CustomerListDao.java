package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class CustomerListDao {
	// 회원 목록 출력 메서드
	public ArrayList<Customer> selectCustomerList(Connection conn, int beginRow, int rowperPage) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_CUSTOMER_LIST);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowperPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Customer customerList = new Customer();
			customerList.setCustomerId(rs.getInt("ID"));
			customerList.setName(rs.getString("name"));
			customerList.setPhone(rs.getString("phone"));
			customerList.setNotes(rs.getString("notes"));
			customerList.setOverdue(rs.getString("overdue"));
			list.add(customerList);
		}
		return list;
	}
	// 회원 목록 카운트 메서드
	public int countCustomerList(Connection conn) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_COUNT_CUSTOMER_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
}
