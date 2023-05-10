package JDBC;

public class RecipeDTO {
	private String ans;
	private String hint1;
	private String hint2;
	private String hint3;
	public RecipeDTO(String ans, String hint1, String hint2, String hint3) {
		super();
		this.ans = ans;
		this.hint1 = hint1;
		this.hint2 = hint2;
		this.hint3 = hint3;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getHint1() {
		return hint1;
	}
	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}
	public String getHint2() {
		return hint2;
	}
	public void setHint2(String hint2) {
		this.hint2 = hint2;
	}
	public String getHint3() {
		return hint3;
	}
	public void setHint3(String hint3) {
		this.hint3 = hint3;
	}
}
