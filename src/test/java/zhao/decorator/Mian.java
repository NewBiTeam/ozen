package zhao.decorator;

public class Mian {

	public static void main(String[] args) {
		DrinkDao drinkDao = new CoffTest1();
		Mike mike = new Mike(drinkDao);
		System.out.println("hei");
		System.out.println(mike.describe());
		System.out.println(mike.money());
	}
}
