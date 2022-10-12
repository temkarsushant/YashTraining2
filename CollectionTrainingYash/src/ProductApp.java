import java.util.ArrayList;
import java.util.List;

public class ProductApp {
	public static void main(String[] args) {

		List<Product> lp = new ArrayList<>();

		lp.add(new Product(1, "Laptop", 400000.00));
		lp.add(new Product(2, "cpu", 50000.00));
		lp.add(new Product(3, "ram", 30000.00));
		lp.add(new Product(4, "ssd", 40000.00));
		lp.add(new Product(5, "Headfone", 2000.00));


		for(Product p:lp) {
//			System.out.println(p.id);
			
			if(p.price>4000) {
				System.out.println(p);
			}
		}
//		System.out.println(lp);
	}
}
