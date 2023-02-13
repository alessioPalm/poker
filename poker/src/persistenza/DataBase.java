package persistenza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

import modello.Carta;
import modello.Mano;

public class DataBase {

private Connection con;
	
	
	
	public Connection getConnection() throws SQLException {
		if(con == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			
			dataSource.setDatabaseName("poker");
			dataSource.setPortNumber(3306);
			dataSource.setServerName("127.0.0.1");
			dataSource.setUser("root");
			dataSource.setPassword("Alessio2018*");
			
			con = dataSource.getConnection();
		}
		return con;
	}
	
	public void esInsert (Mano mano) throws SQLException {
		String sql = "INSERT INTO `poker`.`mano` () VALUES ()";		
		PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		System.out.println("id è " + rs.getInt(1));
	}
	
public void esInsert (Carta carta ,int id) throws SQLException {
		
		String sql = "INSERT INTO carta(idCarta, valore, seme)" + 
					"VALUES('"+ id +"', '"+carta.getValore()+"', '"+carta.getSeme()+"')"; //get ingresso calco
		
		PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		System.out.println("id è " + rs.getInt(1));
	}
	
	public ArrayList <Carta> findCartaByMano (Mano mano) throws SQLException{
		
		
		String sql = "SELECT c.id, c.idUtente, c.valore, c.seme FROM poker.carta as c WHERE idMano = "+ mano.getId()+" ;" ;
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> listaRisultato = new ArrayList <Carta> ();
		while(rs.next()) {
			Carta carta = new Carta ();

			carta.setValore(rs.getString(3));
			carta.setSeme(rs.getString(4));
			
			
			listaRisultato.add(carta);
		}
		return listaRisultato;
	}
}
