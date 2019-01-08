package it.therickys93.wikiserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.utils.Configurations;

public class WikiDatabase {

	private Connection conn;
	
	public void open() throws SQLException{
		this.conn = DriverManager.getConnection(Configurations.dbConnectionString(), Configurations.dbUsername(), Configurations.dbPassword());
	}
	
	public void close() throws SQLException {
		this.conn.close();
	}
	
	public boolean insert(Led led, String user_id) throws SQLException{
		int rows = 0;
		PreparedStatement st = this.conn.prepareStatement("INSERT INTO connections (name,key,pin,user_id) VALUES (?,?,?,?)");
		st.setString(1, led.getName());
		st.setString(2, led.getKey());
		st.setInt(3, led.getPosition());
		st.setString(4, user_id);
		rows = st.executeUpdate();
		st.close();
		if(rows > 0){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean insertMessage(String endpoint, String message, String type) throws SQLException{
		int rows = 0;
		PreparedStatement st = this.conn.prepareStatement("INSERT INTO messages (endpoint,message,type) VALUES (?,?,?)");
		st.setString(1, endpoint);
		st.setString(2, message);
		st.setString(3, type);
		rows = st.executeUpdate();
		st.close();
		if(rows > 0){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean insertMessageWithUserID(String endpoint, String message, String type, String user_id) throws SQLException{
		int rows = 0;
		PreparedStatement st = this.conn.prepareStatement("INSERT INTO messages (endpoint,message,type,user_id) VALUES (?,?,?,?)");
		st.setString(1, endpoint);
		st.setString(2, message);
		st.setString(3, type);
		st.setString(4, user_id);
		rows = st.executeUpdate();
		st.close();
		if(rows > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public void insertRequestMessage(String endpoint, String message) throws SQLException {
		String type = "request";
		insertMessage(endpoint, message, type);
	}
	
	public void insertRequestMessageWithUserID(String endpoint, String message, String user_id) throws SQLException {
		String type = "request";
		insertMessageWithUserID(endpoint, message, type, user_id);
	}
	
	public void insertResponseMessage(String endpoint, String message) throws SQLException {
		String type = "response";
		insertMessage(endpoint, message, type);
	}
	
	public void insertResponseMessageWithUserID(String endpoint, String message, String user_id) throws SQLException {
		String type = "response";
		insertMessageWithUserID(endpoint, message, type, user_id);
	}
	
	public boolean remove(String name, String user_id) throws SQLException{
		int rows = 0;
		PreparedStatement st;
		if(user_id != null){
			st = this.conn.prepareStatement("DELETE FROM connections WHERE name = ? AND user_id = ?");
			st.setString(1, name);
			st.setString(2, user_id);
		} else {
			st = this.conn.prepareStatement("DELETE FROM connections WHERE name = ? AND user_id IS NULL");
			st.setString(1, name);
		}
		rows = st.executeUpdate();
		st.close();
		if(rows > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public int count(String name, String user_id) throws SQLException{
		int count = 0;
		PreparedStatement st;
		if(user_id != null){
			st = this.conn.prepareStatement("SELECT COUNT(*) FROM connections WHERE key = ? AND user_id = ?"); 
			st.setString(1, name);
			st.setString(2, user_id);
		} else {
			st = this.conn.prepareStatement("SELECT COUNT(*) FROM connections WHERE key = ? AND user_id IS NULL"); 
			st.setString(1, name);
		}
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			count = rs.getInt(1);
		}
		rs.close();
		st.close();
		return count;
	}
	
	public Led get(String name, String user_id) throws SQLException{
		Led led = null;
		PreparedStatement st;
		if(user_id != null){
			st = this.conn.prepareStatement("SELECT * FROM connections WHERE name = ? AND user_id = ?");
			st.setString(1, name);
			st.setString(2, user_id);
		} else {
			st = this.conn.prepareStatement("SELECT * FROM connections WHERE name = ? AND user_id IS NULL");
			st.setString(1, name);
		}
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
		    led = new Led();
		    led.setName(rs.getString(2));
		    led.setKey(rs.getString(3));
		    led.setPosition(rs.getInt(4));
		}
		rs.close();
		st.close();
		return led;
	}
	
	public String getConnections(String user_id) throws SQLException {
		String response = "";
		PreparedStatement st;
		if(user_id != null){
			st = this.conn.prepareStatement("SELECT * FROM connections WHERE user_id = ?");
			st.setString(1, user_id);
		} else {
			st = this.conn.prepareStatement("SELECT * FROM connections WHERE user_id IS NULL");
		}
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			response += rs.getString(2) + " collegato in " + rs.getString(3) + " alla presa " + rs.getInt(4) + "\n";
		}
		rs.close();
		st.close();
		return response;
	}
	
}
