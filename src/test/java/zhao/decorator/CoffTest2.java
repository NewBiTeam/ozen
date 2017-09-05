package zhao.decorator;

public class CoffTest2 implements DrinkDao{

	private String desc = "这是第一种咖啡";
	
	@Override
	public String describe() {
		return this.desc;
	}

	@Override
	public int money() {
		return 10;
	}

}
