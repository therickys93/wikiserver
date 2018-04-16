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
	
	public void insert(Led led) throws SQLException{
		PreparedStatement st = this.conn.prepareStatement("INSERT INTO connections (name,key,pin) VALUES (?,?,?)");
		st.setString(1, led.getName());
		st.setString(2, led.getKey());
		st.setInt(3, led.getPosition());
		st.executeUpdate();
		st.close();
	}
	
	private void insertMessage(String endpoint, String message, String type) throws SQLException{
		PreparedStatement st = this.conn.prepareStatement("INSERT INTO messages (endpoint,message,type) VALUES (?,?,?)");
		st.setString(1, endpoint);
		st.setString(2, message);
		st.setString(3, type);
		st.executeUpdate();
		st.close();
	}
	
	public void insertRequestMessage(String endpoint, String message) throws SQLException {
		String type = "request";
		insertMessage(endpoint, message, type);
	}
	
	public void insertResponseMessage(String endpoint, String message) throws SQLException {
		String type = "response";
		insertMessage(endpoint, message, type);
	}
	
	public void remove(String name) throws SQLException{
		PreparedStatement st = this.conn.prepareStatement("DELETE FROM connections WHERE name = ?");
		st.setString(1, name);
		st.executeUpdate();
		st.close();
	}
	
	public int count(String name) throws SQLException{
		int count = 0;
		PreparedStatement st = this.conn.prepareStatement("SELECT COUNT(*) FROM connections WHERE key = ?"); 
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			count = rs.getInt(1);
		}
		rs.close();
		st.close();
		return count;
	}
	
	public Led get(String name) throws SQLException{
		Led led = null;
		PreparedStatement st = this.conn.prepareStatement("SELECT * FROM connections WHERE name = ?");
		st.setString(1, name);
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
	
}
