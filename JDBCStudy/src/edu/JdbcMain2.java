package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class JdbcMain2 {
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
	//// World
		
		
		String driver = "com.mysql.cj.jdbc.Driver"; // Driver 생성 (이건 불변)
		String url = "jdbc:mysql://10.125.121.202/sakila"; //DB 명 // default : 3306포트(MySQL)	//localhost : 내 PC // 다른 DB IP로 바꾸면 그거 가져올수도 있음.	
		String sql = "select * from actor"; // SQL 문, 테이블 명
		
	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "musthave","tiger");
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(sql);
		
//		// 출력 포맷 정의 (날짜, 숫자)
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss//aaaa");
		DecimalFormat df = new DecimalFormat("#,#,#,0");
		
		while(rs.next()) {
		System.out.println(String.format("%d|%s|%s|%s|%s",
				rs.getInt("actor_id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				sf.format(rs.getDate("last_update")),
				df.format(rs.getInt("actor_id"))
						));
		}
		
		rs.close();
		st.close();
		con.close();
	}

}