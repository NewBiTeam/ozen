package zhao.decorator;

public class tea extends Decorator {
	private String desc = "添加茶";
	private DrinkDao dirnkDao = null;

	@SuppressWarnings("unused")
	private void rea(DrinkDao drinkDao) {
		this.dirnkDao = drinkDao;
	}

	@Override
	public String describe() {
		return dirnkDao.describe()+desc;
	}

	@Override
	public int money() {
		return dirnkDao.money()+40;
	}
}
