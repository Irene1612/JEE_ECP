package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.daos.VotoDao;
import models.entities.Voto;
import models.utils.NivelEstudios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements
		VotoDao {

	private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

	private Voto create(ResultSet resultSet) {
		Voto voto;
		try {
			if (resultSet != null && resultSet.next()) {
				voto = new Voto(resultSet.getString(Voto.USUARIO_IP),
						NivelEstudios.values()[resultSet.getInt(Voto.NIVEL_ESTUDIOS)], resultSet.getInt(Voto.VALORACION));
				return voto;
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s INT, %s VARCHAR(255), "
			+ "%s INT, PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.NIVEL_ESTUDIOS,
				Voto.USUARIO_IP, Voto.VALORACION, Voto.ID);
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s',%d)";

	@Override
    public void create(Voto voto) {
        this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.NIVEL_ESTUDIOS, Voto.USUARIO_IP, Voto.VALORACION, voto.getNivelEstudios(), voto.getUsuarioIP(), voto.getValoracion()));
        voto.setId(this.autoId());
    }

	@Override
	public Voto read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				Voto.TABLE, id));
		return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s=%d, %s='%s', %s=%d WHERE ID=%d";

	@Override
	public void update(Voto voto) {
		this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.NIVEL_ESTUDIOS, voto.getNivelEstudios(),
				Voto.USUARIO_IP, voto.getUsuarioIP(), Voto.VALORACION, voto.getValoracion(), voto.getId()));
	}

	@Override
	public void deleteById(Integer id) {
		Voto votoDB = this.read(id);
		if (votoDB != null) {
			this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
		}
	}

	@Override
	public List<Voto> findAll() {
		List<Voto> list = new ArrayList<Voto>();
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL,
				Voto.TABLE));
		Voto voto = this.create(resultSet);
		while (voto != null) {
			list.add(voto);
			voto = this.create(resultSet);
		}
		return list;
	}
}
