package com.yash.springcrud.springjdbc.service;

import java.util.List;

import com.yash.springcrud.springjdbc.exception.JdbcException;
import com.yash.springcrud.springjdbc.pojo.Product;

/**
 * 
 * @author sushant.temkar List of operation for giving service of product
 */

public interface ProductService {

	public String saveProduct(Product p) throws JdbcException;

	public List<Product> getAllProduct() throws JdbcException;

	public int getLatestId() throws JdbcException;

	public String updateProduct(int id, String name, Double price) throws JdbcException;

	public String deleteProduct(int id) throws JdbcException;
}
