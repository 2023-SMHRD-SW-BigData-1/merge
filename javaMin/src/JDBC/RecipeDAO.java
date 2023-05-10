package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

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

	public int RecipeNumber(){
		getConn();
		String sql="select max(num) from question";
		int result=0;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.next();
			result=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getClose();
		}
		return result;
	}

	public String[] getRecipe(int i) {
		String result[]=new String[6];
		int cnt=0;
		getConn();
		String sql="select list from recipe where num=? order by count";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, i);
			rs=pst.executeQuery();
			while(rs.next()) {
				result[cnt]=rs.getString(1);
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getClose();
		}
		return result;
	}

	public RecipeDTO getRDTP(int i) {
		getConn();
		RecipeDTO result=null;
		String sql="select answer,hint1,hint2,hint3 from question where num=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, i);
			rs=pst.executeQuery();
			rs.next();
			String ans=rs.getString(1);
			String hint1=rs.getString(2);
			String hint2=rs.getString(3);
			String hint3=rs.getString(4);
			result=new RecipeDTO(ans, hint1, hint2, hint3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}




}
