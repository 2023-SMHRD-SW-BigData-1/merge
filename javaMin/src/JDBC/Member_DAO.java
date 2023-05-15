package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Member_DAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Score_DTO sdto = null;

	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@172.30.1.20:1521:xe";
			String db_id = "project";
			String db_pw = "12345";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (Exception e) {
			System.out.println("오류발생");
		}
	}

	public void getClose() {

		try {
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(Member_DTO mdto) {
		int row = 0;

		try {

			getConn();

			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);

			pst.setString(1, mdto.getId());
			pst.setString(2, mdto.getPw());
			pst.setString(3, mdto.getName());
			pst.setInt(4, mdto.getScore());

			row = pst.executeUpdate();

		} catch (Exception e) {

		} finally {
			getClose();
		}
		return row;
	}

	public Member_DTO login(String id, String pw) {
		getConn();
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
		Member_DTO mdto = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);

			rs = pst.executeQuery();
			if (rs.next()) {
				String s_id = rs.getString(1);
				String s_pw = rs.getString(2);
				String s_name = rs.getString(3);
				int s_score = rs.getInt(4);
				mdto = new Member_DTO(s_id, s_pw, s_name, s_score);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return mdto;
	}

	public ArrayList<Score_DTO> rank() {

		ArrayList<Score_DTO> arr = new ArrayList<>();
		getConn();
		String sql = "SELECT NAME, SCORE FROM Member WHERE ROWNUM <=5 ORDER BY SCORE DESC";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String s_name = rs.getString(1);
				int s_score = rs.getInt(2);
				sdto = new Score_DTO(s_name, s_score);
				arr.add(sdto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return arr;
	}

	public void updateScore(String id, int totalScore) {
		getConn();
		String sql="update member set score=? where id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, totalScore);
			pst.setString(2, id);			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
	}

}
