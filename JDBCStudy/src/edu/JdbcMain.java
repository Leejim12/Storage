package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcMain{

	private static List<BoardDTO> getData(ResultSet rs) throws SQLException {
		List<BoardDTO> list = new ArrayList<>();
		
		// Collection 추출
		while(rs.next()) { 
					list.add(new BoardDTO(
							rs.getInt("num"),
							rs.getString("title"),
							rs.getString("content")));
		}
		return list;
	}

	// 출력문
	private static void printData(List<BoardDTO> list) {
		for (BoardDTO b : list) {
			System.out.println(b.toString());
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/musthave";
		String sql = "select * from board";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "musthave","tiger");
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(sql);


		List<BoardDTO> list = null;
		try {
			list = getData(rs); //불러오기
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rs.close();
		st.close();
		con.close();

		printData(list);
	}

}
