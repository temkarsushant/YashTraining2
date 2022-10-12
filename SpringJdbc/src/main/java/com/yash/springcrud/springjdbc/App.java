package com.yash.springcrud.springjdbc;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.yash.springcrud.springjdbc.exception.JdbcException;
import com.yash.springcrud.springjdbc.pojo.Product;
import com.yash.springcrud.springjdbc.service.ProductService;
import com.yash.springcrud.springjdbc.serviceimpl.ProductServiceImpl;

/**
 * 
 * @author sushant.temkar Functionality of Application
 */
public class App {
	static Logger log = Logger.getLogger(App.class.getName());

	static int count = 1;
	
	@Autowired
	static ProductService ps;

	public static void main(String[] args) throws JdbcException {
		BasicConfigurator.configure();

		String choice = null;
		while (true) {
			log.info("\n Welcome to Product \n");
			log.info("Press 1 to Save the Data");
			log.info("Press 2 to Fetch the Data");
			log.info("Press 3 to Update the Data");
			log.info("Press 4 to Delete the Data");
			log.info("Press 6 to exit");

			Scanner sc = new Scanner(System.in);

			int key = sc.nextInt();
			switch (key) {
			case 1:
				count = ps.getLatestId();
				log.info("Enter Name of Product");
				String pName = sc.next();
				log.info("Enter the price");
				Double price = sc.nextDouble();
				Product pp = new Product(count + 1, pName, price);
				ps.saveProduct(pp);
				count++;
				break;
			case 2:
				List<Product> lp = ps.getAllProduct();
				for (Product p : lp)
					System.out.println(p);
				break;
			case 3:

				log.info("Please provide below details to update the record");
				log.info("Enter id");
				int id = sc.nextInt();
				log.info("Enter the updated name of the product");
				String name = sc.next();
				log.info("Enter the updated price of the product");
				double prise = sc.nextDouble();

				String result = ps.updateProduct(id, name, prise);
//				System.out.println(result);
				log.info(result);
				break;

			case 4:

				log.info("Please provide Id to delete the record");
				log.info("Enter id");
				int did = sc.nextInt();
				String dresult = ps.deleteProduct(did);
				log.info(dresult);
//				System.out.println(dresult);
				break;
			case 6:
				choice = "Exit";
				break;

			default:
				break;
			}

			if (choice != null && choice.equalsIgnoreCase("Exit")) {
				break;
			}
		}

	}
}
