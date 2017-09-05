package zhao.decorator;

public class Decorator implements DrinkDao{

	private String desc = "装饰类的描述，具体看子类";
	
	@Override
	public String describe() {
		return desc;
	}

	@Override
	public int money() {
		return 0;
	}

}
