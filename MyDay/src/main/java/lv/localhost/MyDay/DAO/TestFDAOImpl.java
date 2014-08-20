package lv.localhost.MyDay.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class TestFDAOImpl {

//	private JdbcTemplate jdbcTemplate;
	
	private Connection conn;

	public TestFDAOImpl(){
		this.conn=null;
	}
	public TestFDAOImpl(DataSource dataSource){
		try {
			this.conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("select id,first_name,last_name,e_mail from Account where id = 1");
			
			String result="def";
			
			while (rs.next()) {
				result = rs.getInt(1) + "/" + rs.getString(2)+ "/" + 
						rs.getString(3)+ "/" +  rs.getString(4);
			}			
			
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
