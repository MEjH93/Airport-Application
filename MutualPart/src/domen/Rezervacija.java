package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Rezervacija implements OpstiDomen, Serializable {
	private int	id_rezervacija;
	private int broj_karata;
	private int id_usera;
	private int id_termin;
	

	public int getId_rezervacija() {
		return id_rezervacija;
	}

	public void setId_rezervacija(int id_rezervacija) {
		this.id_rezervacija = id_rezervacija;
	}

	public int getBroj_karata() {
		return broj_karata;
	}

	public void setBroj_karata(int broj_karata) {
		this.broj_karata = broj_karata;
	}

	public int getId_usera() {
		return id_usera;
	}

	public void setId_usera(int id_usera) {
		this.id_usera = id_usera;
	}

	public int getId_termin() {
		return id_termin;
	}

	public void setId_termin(int id_termin) {
		this.id_termin = id_termin;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return "rezervacija";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return "(	broj_karata,	id_usera,	id_termin)";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setInt(1, broj_karata);
			ps.setInt(2, id_usera);
			ps.setInt(3, id_termin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values ( ?,?,?) ";
	}

	@Override
	public List<OpstiDomen> vratiSelect(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
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
