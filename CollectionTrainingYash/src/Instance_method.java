
interface Greet2 {
	void say();
}

public class Instance_method {

	public void speak() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		Instance_method i = new Instance_method();

		Greet2 g2 = i::speak;

		g2.say();

		Greet2 s2 = new Instance_method()::speak;
		s2.say();

	}
}