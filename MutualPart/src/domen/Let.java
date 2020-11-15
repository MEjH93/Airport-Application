package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Let implements OpstiDomen, Serializable {
	private int id_let;
	private int id_avio;
	private String polazak;
	private String dolazak;
	

	public int getId_let() {
		return id_let;
	}

	public void setId_let(int id_let) {
		this.id_let = id_let;
	}

	public int getId_avio() {
		return id_avio;
	}

	public void setId_avio(int id_avio) {
		this.id_avio = id_avio;
	}

	public String getPolazak() {
		return polazak;
	}

	public void setPolazak(String polazak) {
		this.polazak = polazak;
	}

	public String getDolazak() {
		return dolazak;
	}

	public void setDolazak(String dolazak) {
		this.dolazak = dolazak;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " let ";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		
		return " (mesto_polaska,	mesto_dolaska,id_aviokomanije) ";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setString(1, polazak);
			ps.setString(2, dolazak);
			ps.setInt(3, id_avio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values(?,?,?) ";
	}

	@Override
	public List<OpstiDomen> vratiSelect(ResultSet resultSet) {
	List<OpstiDomen>list = new ArrayList<>();
	try {
		while(resultSet.next()) {
				Let let = new Let();
				let.setDolazak(resultSet.getString("mesto_dolaska"));
				let.setPolazak(resultSet.getString("mesto_polaska"));
				let.setId_avio(resultSet.getInt("id_aviokomanije"));
				let.setId_let(resultSet.getInt("id_let"));
				list.add(let);	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public String VratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpstiDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

}
