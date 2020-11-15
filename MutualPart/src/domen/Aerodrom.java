package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aerodrom implements OpstiDomen, Serializable {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aerodrom other = (Aerodrom) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	private int id_aerodrom;
	private String naziv;
	

	public int getId_aerodrom() {
		return id_aerodrom;
	}

	public void setId_aerodrom(int id_aerodrom) {
		this.id_aerodrom = id_aerodrom;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return "aerodrom";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		 return " ( naziv ) ";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, naziv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?) ";
	}

	@Override
	public List<OpstiDomen> vratiSelect(ResultSet resultSet) {
		List<OpstiDomen>lsit = new ArrayList<>();
		try {
			while(resultSet.next()) {
				Aerodrom aerodrom = new Aerodrom();
				naziv = resultSet.getString("naziv");
				aerodrom.setNaziv(naziv);
				aerodrom.setId_aerodrom(resultSet.getInt("id_aerodrom"));
				lsit.add(aerodrom);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsit;
	}

	@Override
	public String VratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return " naziv = ? ";
	}

	
	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, naziv);
			preparedStatement.setInt(2, id_aerodrom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_aerodrom";
	}

	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, id_aerodrom);
		return preparedStatement;
	}

	@Override
	public OpstiDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

}
