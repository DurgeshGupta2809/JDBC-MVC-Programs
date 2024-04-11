package com.ty.userapplication.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import com.ty.userapplication.exception.UserUndefined;

public class FetchDao {

	private static String url="jdbc:postgresql://localhost:5432/User";
	private static String user="postgres";
	private static String password="root";
	private static String driver="org.postgresql.Driver";
	
	public static Connection con=null;
	
	public static void fetchUserById(int id) {
	   
		try {
			Class.forName(driver);
			
			con= DriverManager.getConnection(url, user, password);
			
			String sql="call fetch_user_by_id(?,?,?,?)";
			CallableStatement cstm=con.prepareCall(sql);
			cstm.setInt(1, id);
			
			cstm.registerOutParameter(1, Types.INTEGER);
			cstm.registerOutParameter(2, Types.VARCHAR);
			cstm.registerOutParameter(3, Types.VARCHAR);
			cstm.registerOutParameter(4, Types.BIGINT);
			
			cstm.execute();
			
			System.out.println(" id : "+cstm.getInt(1));
			System.out.println(" name : "+cstm.getString(2));
			System.out.println(" email : "+cstm.getString(3));
			System.out.println(" phone : "+cstm.getLong(4));
			
		//	System.out.println("Record Fetched..");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	 
   }
}
