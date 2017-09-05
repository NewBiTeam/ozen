package zhao.decorator;

public class CoffTest1 implements DrinkDao{

	private String desc = "这是第二种咖啡";
	
	@Override
	public String describe() {
		return this.desc;
	}

	@Override
	public int money() {
		return 20;
	}

}
