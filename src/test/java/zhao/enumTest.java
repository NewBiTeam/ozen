package zhao;

public enum enumTest {

	NAME("name"),
	age("age");
	
	private final String val;
	
	enumTest (String string){
		this.val = string;
	}
	
	public String getVal(){
		return this.val;
	}
	
}
