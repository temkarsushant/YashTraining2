package com.yash.springcrud.springjdbc.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.springcrud.springjdbc.exception.JdbcException;
import com.yash.springcrud.springjdbc.pojo.Product;
import com.yash.springcrud.springjdbc.service.ProductService;
import com.yash.springcrud.springjdbc.utility.Utility;

/**
 * 
 * @author sushant.temkar Implementation of different services of product
 */
@Service
public class ProductServiceImpl implements ProductService {

	//Implementation for saving the Product details
	public String saveProduct(Product p) throws JdbcException {
		String result = null;

		try {
			String sql = "insert into product(id,name,price) values(?,?,?)";
			Connection con = Utility.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
			stmt.setDouble(3, p.getPrice());
			stmt.executeUpdate();

			result = "Data saved successfully";
		} catch (Exception e) {
			throw new JdbcException("Data saving unsuccessful");

		}

		return result;
	}

	//Implementation for getting the Product details
	public List<Product> getAllProduct() throws JdbcException {
		List<Product> lp = new ArrayList<Product>();
		try {
			String sql = "select * from product";
			Connection con = Utility.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product pp = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				lp.add(pp);
			}
			con.close();
			return lp;
		} catch (Exception e) {
			throw new JdbcException("Error in query, while fetching data.");
		}
	}

	//Implementation for getting latest record of the Product
	public int getLatestId() throws JdbcException {
		int id = 0;
		try {
			String sql = "select * from product order by 1 desc limit 1";
			Connection con = Utility.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			con.close();
			return id;
		} catch (Exception e) {
			throw new JdbcException("Error in query, while fetching data.");
		}
	}

	//Implementation for updating the Product details
	public String updateProduct(int id, String name, Double price) throws JdbcException {
		String sql = "update product set name='" + name + "',price='" + price + "' where id=" + id;
		try {
			Connection con = Utility.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
			con.close();
			return "Record Update Successfully";
		} catch (Exception e) {
			throw new JdbcException("Failed to update record");
		}
	}

	//Implementation for deleting the Product details
	public String deleteProduct(int id) throws JdbcException {

		try {
			String sql = "delete from product where id=?";
			Connection con = Utility.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			con.close();
			return "Record Deleted Successfully";
		} catch (Exception e) {
			throw new JdbcException("Failed to delete the record");
		}
	}
}
