package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OpstiDomen {
	public String vratiNazivTabele();
	public String vratiKolone();
	public PreparedStatement vratiInsert(PreparedStatement ps);
	public String vratiZnakove();
	public List<OpstiDomen>vratiSelect(ResultSet resultSet);
	public String VratiKoloneUpdate();
	public String getId();
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement);
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement)throws SQLException;
	

	public OpstiDomen vratiPoslednjiPodatak(ResultSet resultSet);
}
