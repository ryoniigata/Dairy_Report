package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

	String url = "jdbc:mysql://localhost/dairy_report_db?serverTimezone=JST";
	String dName = "root";
	String dPw = "root";

	public boolean loginJudge(String id, String pw){

		String sql = "SELECT * FROM memberinfo WHERE id = '" + id +
						"' and pw = '" + pw + "';";
		boolean result = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try(Connection con = DriverManager.getConnection(url,dName,dPw);
			Statement stmt = con.createStatement()) {

			result = stmt.execute(sql);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return result;

	}

}
