package JDBC;

public class Score_DTO {
	private String name;
	private int score;

	public Score_DTO(String s_name, int s_score) {
		super();
		this.name = s_name;
		this.score = s_score;

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
		this.score = score;
	}
}
