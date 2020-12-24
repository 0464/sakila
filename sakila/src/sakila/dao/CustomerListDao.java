package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
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
	
	// 회원 검색 목록 출력 메서드
	public ArrayList<Customer> selectCustomerSearchList(Connection conn, int beginRow, int rowperPage, String search) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_CUSTOMER_SEARCH_LIST);
		stmt.setString(1, search);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowperPage);
		
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
	public int countCustomerSearchList(Connection conn, String search) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_COUNT_CUSTOMER_SEARCH_LIST);
		stmt.setString(1, search);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
	// 회원 상세보기 메서드
	public ArrayList<Customer> selectCustomerOne(Connection conn, Customer paramCustomer) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_CUSTOMER_ONE);
		stmt.setInt(1, paramCustomer.getCustomerId());
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Customer customerList = new Customer();
			customerList.setCustomerId(rs.getInt("ID"));
			customerList.setName(rs.getString("name"));
			customerList.setEmail(rs.getString("email"));
			customerList.setAddress(rs.getString("address"));
			customerList.setZipCode(rs.getString("zip code"));
			customerList.setPhone(rs.getString("phone"));
			customerList.setNotes(rs.getString("notes"));
			customerList.setSid(rs.getInt("SID"));
			list.add(customerList);
		}
		return list;
	}
	// MVP 목록 출력 메서드
	public ArrayList<Customer> selectMVPList(Connection conn) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_MVP_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Customer mvpList = new Customer();
			mvpList.setCustomerId(rs.getInt("ID"));
			mvpList.setName(rs.getString("name"));
			mvpList.setTotalAmount(rs.getInt("totalAmount"));
			mvpList.setSid(rs.getInt("SID"));
			
			list.add(mvpList);
		}
		return list;
	}
}
