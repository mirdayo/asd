package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnectionPool {
	protected String id;
	protected String pw;
	protected String url;
	
	protected static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	

	
	ConnectionPool(){
		id="root";
		pw="1234";
		url="jdbc:mysql://localhost:3306/bookdb";
		
		try {
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(url,id,pw);
				System.out.println("ConnectionPool Connection 생성");
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
