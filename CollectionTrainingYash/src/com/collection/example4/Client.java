package com.collection.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface Client {
	public static void main(String[] args) {

		List<String> al = new ArrayList<>();

		al.add("Sushant");
		al.add("Sushant");
		al.add("Mahesh");
		al.add("Mahesh");
		al.add("Abhishek");
		al.add("Abhishek");

		Set<String> ss = new TreeSet<>();

		for (String st : al) {
			ss.add(st);
		}
		
		
		
		//Logic to revers a String via for loop

		ArrayList<String> ls = new ArrayList<>();

		for (String sr : ss) {
			ls.add(sr);

		}
		for (int i = ls.size() - 1; i >= 0; i--) {
			System.out.println(ls.get(i));
		}

	}
}
