package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testString {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/dairy_report_db?serverTimezone=JST";
		String name = "root";
		String pw = "root";


		try(Connection con = DriverManager.getConnection(url,name,pw);
			Statement stmt = con.createStatement()){

			String sql = "SELECT * FROM memberinfo;";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String rId = rs.getString(1);
				String rPw = rs.getString(2);

				System.out.println(rId + ":" + rPw);
			}

		}
		catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



	}

}
