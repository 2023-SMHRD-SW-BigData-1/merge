package JDBC;

public class DTO {
	
	private String id;
	// 비밀번호
	private String pw;
	// 이름
	private String name;
	// 나이
	private int score;
	
	// 2. 메소드
	public DTO(String id, String pw, String name, int score) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score =score;
	}
	
	
	

}
