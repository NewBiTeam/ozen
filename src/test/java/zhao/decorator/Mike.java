package zhao.decorator;

public class Mike extends Decorator {
	private String desc = "添加牛奶";
	private DrinkDao drinkDao = null;

	public Mike(DrinkDao drinkDao) {
		this.drinkDao = drinkDao;
	}

	@Override
	public String describe() {
		return drinkDao.describe() + desc;
	}

	@Override
	public int money() {
		return drinkDao.money() + 40;
	}
}
