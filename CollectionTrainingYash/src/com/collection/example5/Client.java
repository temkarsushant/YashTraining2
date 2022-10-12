package com.collection.example5;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Client {
	public static void main(String[] args) {

		Vector<Integer> vc = new Vector<>();

		vc.add(5);
		vc.add(5);
		vc.add(4);
		vc.add(2);
		vc.add(2);
		vc.add(1);

		Collections.sort(vc);

		System.out.println(vc);
		
		

	}

}
