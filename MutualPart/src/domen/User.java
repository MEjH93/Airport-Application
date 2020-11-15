package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User implements OpstiDomen, Serializable{
	private int id;
	private String username;
	private String password;
	private String status;
	public int getIdUsera() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return "user";
	}
	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return " (username, password, status ) ";
	}
	
	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?,?,?) ";
	}
	@Override
	public List<OpstiDomen> vratiSelect(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String VratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OpstiDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
