package domen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Termin implements OpstiDomen, Serializable {
	private int id_termina;
	private int id_leta;
	private LocalDate datum;
	private LocalTime vreme;
	private int  ukupanBrojKarata;
	

	public int getId_termina() {
		return id_termina;
	}

	public void setId_termina(int id_termina) {
		this.id_termina = id_termina;
	}

	public int getId_leta() {
		return id_leta;
	}

	public void setId_leta(int id_leta) {
		this.id_leta = id_leta;
	}

	

	
	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public LocalTime getVreme() {
		return vreme;
	}

	public void setVreme(LocalTime vreme) {
		this.vreme = vreme;
	}

	public int getUkupanBrojKarata() {
		return ukupanBrojKarata;
	}

	public void setUkupanBrojKarata(int ukupanBrojKarata) {
		this.ukupanBrojKarata = ukupanBrojKarata;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return "termin";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return "(datum,	vreme,id_leta,ukupan_broj_karata)";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setDate(1, Date.valueOf(datum));
			ps.setTime(2, Time.valueOf(vreme));
			ps.setInt(3, id_leta);
			ps.setInt(4, ukupanBrojKarata);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?,?,?,?)  ";
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
