package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.LikeDislike;

public class LikeDislikeDAL {
	
	public static ArrayList<LikeDislike> getAll(){
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<LikeDislike> lajkovi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {

			String query = "SELECT * FROM lajkovi";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// citanje rezultata upita
			while (rset.next()) {
			
				int id = rset.getInt("id");
				boolean lajk = rset.getBoolean("lajk");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				LikeDislike l = new LikeDislike();
				l.setiD(id);
				l.setLike(lajk);
				l.setDatumKreiranja(datum_kreiranja);
				
				lajkovi.add(l);
				
				
				
				
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return lajkovi;
		
		
	}
	
	
	
	public static LikeDislike GetById(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM lajkovi WHERE id = ?"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean lajk = rset.getBoolean("lajk");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				LikeDislike l = new LikeDislike();
				l.setiD(id);
				l.setLike(lajk);
				l.setDatumKreiranja(datum_kreiranja);
			
				
				return l;
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return null;
	}
	
	
	public static ArrayList<LikeDislike> GetByVideoId(int ID) {
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<LikeDislike> lajkovi = new ArrayList<>();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM lajkovi WHERE id IN (SELECT lajk_id FROM video_lajkovi WHERE video_id = ?)"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			while (rset.next()) {
				int id = rset.getInt("id");
				boolean lajk = rset.getBoolean("lajk");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				LikeDislike l = new LikeDislike();
				l.setiD(id);
				l.setLike(lajk);
				l.setDatumKreiranja(datum_kreiranja);
			
				lajkovi.add(l);
				return lajkovi;
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return null;
	}
	
	public static ArrayList<LikeDislike> GetByKomentarId(int ID) {
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<LikeDislike> lajkovi = new ArrayList<>();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM lajkovi WHERE id IN (SELECT lajk_id FROM komentar_lajkovi WHERE komentar_id = ?)"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			while (rset.next()) {
				int id = rset.getInt("id");
				boolean lajk = rset.getBoolean("lajk");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				LikeDislike l = new LikeDislike();
				l.setiD(id);
				l.setLike(lajk);
				l.setDatumKreiranja(datum_kreiranja);
			
				lajkovi.add(l);
				return lajkovi;
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return null;
	}
		
	
	
	public static boolean Create(LikeDislike lajk) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO lajkovi (lajk, datum_kreiranja) VALUES (?, ?)";

			pstmt = conn.prepareStatement(query);
		
			
			pstmt.setBoolean(1, lajk.isLike());
			pstmt.setObject(3, lajk.getDatumKreiranja());
			
			System.out.println(pstmt);
			// izvrsavanje naredbe i prihvatanje rezultata (INSERT, UPDATE, DELETE), jednom za svaki SQL upit
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			// zatvaranje naredbe i rezultata
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	
	public static boolean Update(LikeDislike lajk) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			
			
			String query = "UPDATE lajkovi SET" +
							"lajk = ?" +
							"datum_kreiranja = ?" +
							"WHERE ID = ?";
							

			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, lajk.isLike());
			pstmt.setObject(2, lajk.getDatumKreiranja());
			pstmt.setInt(3, lajk.getiD());
			
			System.out.println(pstmt);
			// izvrsavanje naredbe i prihvatanje rezultata (INSERT, UPDATE, DELETE), jednom za svaki SQL upit
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			// zatvaranje naredbe i rezultata
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	
	


}
