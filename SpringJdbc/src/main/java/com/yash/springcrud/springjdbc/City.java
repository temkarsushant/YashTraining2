package com.yash.springcrud.springjdbc;

public class City {
	String cityname;

	City(String cname) {
		cityname = cname;
	}

	public void showcity() {
		System.out.println(cityname);
	}
}
