package zhao;

public class Fin extends Test{
	//自己的属性
	private String mod;
	
	@Override	//必须继承的抽象方法
	String mod() {
		return this.mod;
	}
	//重写抽象类的普通方法
	void model(){
		System.out.println("fin");
	}
	
	public static void main(String[] args) {
		Fin f = new Fin();
		f.model();
	}
	
}
