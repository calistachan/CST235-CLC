package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import utilities.AppLogger;
import utilities.DBconnect;

public class UsersDAO implements DAOInterface<User> {

	@Override
	public void createItem(User item) throws SQLException {
		// initialize default connect to null  
		Connection conn = null;
		try {
			//gain a connection to the database
			conn = DBconnect.getConnection();
			String sql = String.format("Insert (`username`, `password`) INTO `users` VALUES('%s', '%s')", item.getUsername(),item.getPassword());
			//create statement object to interact with database
			Statement stmt = conn.createStatement();
			//execute the sql statement against connection
			stmt.executeUpdate(sql);
		} catch(Exception e){
			AppLogger.error(e);
			throw e;
		} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch(Exception ex) {
					AppLogger.error(ex);
					}	
				}
		}
	}

	@Override
	public User readItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
		
			conn = DBconnect.getConnection();
			String sql = String.format("SELECT * FROM `users` WHERE `user_id` = %d", id);
			PreparedStatement prestmt = conn.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			rs.next();
			User user = new User();
			
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			rs.close();
			return user;
		} catch(Exception e){
			AppLogger.error(e);
			throw e;
		} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch(Exception ex) {
					AppLogger.error(ex);
					}	
				}
		}
		
	}

	@Override
	public List<User> readList() throws SQLException {
		Connection conn = null;
		ArrayList<User> userList =  new ArrayList<User>();
		try {	
			conn = DBconnect.getConnection();
			String sql = String.format("SELECT * FROM `users`");
			PreparedStatement prestmt = conn.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while(rs.next()){
				userList.add(new User(rs.getString("username"), rs.getString("password")));
			} 
			rs.close();
			return userList;
		} catch(Exception e){
			AppLogger.error(e);
			throw e;
		} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch(Exception ex) {
					AppLogger.error(ex);
					}	
				}
		}
	}

	@Override
	public void updateItem(User item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
