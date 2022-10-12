package com.collection.example3;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Client {
	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>();

		al.add(3);
		al.add(4);
		al.add(2);
		al.add(2);
		al.add(1);

		Set<Integer> ss = new TreeSet<>();

		for (int k : al) {
			ss.add(k);
		}

		System.out.println(ss);

	}
}
