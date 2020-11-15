package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aviokompanija implements OpstiDomen, Serializable{
	private int id_aviokompanije;
	private int id_aerodrom;
	private String naziv;

	public int getId_aviokompanije() {
		return id_aviokompanije;
	}

	public void setId_aviokompanije(int id_aviokompanije) {
		this.id_aviokompanije = id_aviokompanije;
	}

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
		return "aviokomapnije";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return "( naziv, id_aerodrom )";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, naziv);
			ps.setInt(2, id_aerodrom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		 return " values ( ? , ? ) ";
	}

	@Override
	public List<OpstiDomen> vratiSelect(ResultSet resultSet) {
		List<OpstiDomen> listaviokompanija = new ArrayList<>();
		try {
			while(resultSet.next()) {
				int id = resultSet.getInt("id_avio_kompanije");
				String naziv = resultSet.getString("naziv");
				int id_aerod=  resultSet.getInt("id_aerodrom");
				Aviokompanija aviokompanija = new Aviokompanija();
				aviokompanija.setId_aerodrom(id_aerod);
				aviokompanija.setId_aviokompanije(id);
				aviokompanija.setNaziv(naziv);
				listaviokompanija.add(aviokompanija);
						
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaviokompanija;
	}

	@Override
	public String VratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_avio_kompanije";
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
		Aviokompanija aviokompanija = new Aviokompanija();
		try {
			if(resultSet.next()) {
						
				String naziv = resultSet.getString("naziv");
				int id_avio = resultSet.getInt("id_avio_kompanije");
				int id_aero = resultSet.getInt("id_aerodrom");
				aviokompanija.setId_aerodrom(id_aero);
				aviokompanija.setId_aviokompanije(id_avio);
				aviokompanija.setNaziv(naziv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aviokompanija;
	}

	@Override
	public String toString() {
		return "Aviokompanija [id_aviokompanije=" + id_aviokompanije + ", id_aerodrom=" + id_aerodrom + ", naziv="
				+ naziv + "]";
	}

}
