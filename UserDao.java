package com.ty.userapplication.dao;

import java.sql.CallableStatement; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.ty.userapplication.entity.User;
import com.ty.userapplication.exception.UserUndefined;

public class UserDao {

	private static String url="jdbc:postgresql://localhost:5432/User";
	private static String userName="postgres";
	private static String password="root";
	private static String driver="org.postgresql.Driver";
	
	private static Connection con=null;
	
//public static String insertUser(User user) {
//	
//	if(user!=null) {
//	
//		try {
//			Class.forName(driver);
//			
//			con=DriverManager.getConnection(url, userName, password);
//			
//			String sql="call insert_user(?,?,?,?,?)";
//			
//			CallableStatement cstm=con.prepareCall(sql);
//			cstm.setInt(1, user.getId());
//			cstm.setString(2, user.getName());
//			cstm.setString(3, user.getEmail());
//			cstm.setLong(4, user.getPhone());
//			cstm.setString(5, user.getPassword());
//			
//			cstm.execute();
//			
//			return "Record  is Inserted";
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(con!=null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}else {
//		throw new UserUndefined();
//	}
//	return "";
//  }

//public static void fetchUserById(int id) {
//	   
//	try {
//		Class.forName(driver);
//		
//		con= DriverManager.getConnection(url, userName, password);
//		
//		String sql="call fetch_user_by_id(?,?,?,?)";
//		CallableStatement cstm=con.prepareCall(sql);
//		cstm.setInt(1, id);
//		
//		cstm.registerOutParameter(1, Types.INTEGER);
//		cstm.registerOutParameter(2, Types.VARCHAR);
//		cstm.registerOutParameter(3, Types.VARCHAR);
//		cstm.registerOutParameter(4, Types.BIGINT);
//		
//		cstm.execute();
//		
//		System.out.println(" id : "+cstm.getInt(1));
//		System.out.println(" name : "+cstm.getString(2));
//		System.out.println(" email : "+cstm.getString(3));
//		System.out.println(" phone : "+cstm.getLong(4));
//		
//	System.out.println("Record Fetched..");
//		
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	finally {
//		if(con!=null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	  }
// 
//    }

//public static String deleteUser(int id) {
//	
//	try {
//		Class.forName(driver);
//		
//		con = DriverManager.getConnection(url, userName, password);
//		
//		String sql="call delete_user(?)";
//		
//		CallableStatement cstm=con.prepareCall(sql);
//		cstm.setInt(1, id);
//		
//		cstm.execute();
//		
//		return "Record Deleted";
//		
//	}	
//	catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}
//	finally {
//	 if(con!=null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	
//	}
//	return "error";
//	
//	
//  }


	public static String updateUser(int id,String name,String email,long phone,String password) {
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userName, password);
			
			String sql="call update_user(?)";
			
			CallableStatement cstm=con.prepareCall(sql);
    		cstm.setInt(1, id);
    		cstm.setString(2, name);
    		cstm.setString(3, email);
    		cstm.setLong(4, phone);
    		cstm.setString(5, password);
			
			cstm.execute();
			
			return "Record Updates";
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
		return "";
	}
}
