package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Komentar;


public class KomentarDAL {
	
	public static ArrayList<Komentar> getAll(){
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<Komentar> komentari = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {

			String query = "SELECT * FROM komentari WHERE obrisan = 0";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// citanje rezultata upita
			while (rset.next()) {
			
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String sadrzaj = rset.getString("sadrzaj");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				int id_korisnika = rset.getInt("id_korisnika");
				int id_videa = rset.getInt("id_videa");
				
				
				
				
				Komentar k = new Komentar();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setSadrzaj(sadrzaj);
				k.setDatumKreiranja(datum_kreiranja);
				
				//vidi koje ce biti od koristi
				k.setId_vlasnika(id_korisnika);
				k.setId_videa(id_videa);
				
				//k.setVlasnik(KorisnikDAL.GetById(id_korisnika));
				//k.setVideo(VideoDAL.GetById(id_videa));
				
				
				
				komentari.add(k);
				
				
				
				
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return komentari;
		
		
	}
	
	public static Komentar GetById(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM komentari WHERE id = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String sadrzaj = rset.getString("sadrzaj");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				int id_korisnika = rset.getInt("id_korisnika");
				int id_videa = rset.getInt("id_videa");
				
			
				Komentar k = new Komentar();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setSadrzaj(sadrzaj);
				k.setDatumKreiranja(datum_kreiranja);
				
				//vidi koje ce biti od koristi
				k.setId_vlasnika(id_korisnika);
				k.setId_videa(id_videa);
				
				//k.setVlasnik(KorisnikDAL.GetById(id_korisnika));
				//k.setVideo(VideoDAL.GetById(id_videa));
				
				return k;
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
		
	public static Komentar GetByVideoId(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM komentari WHERE id_videa = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String sadrzaj = rset.getString("sadrzaj");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				int id_korisnika = rset.getInt("id_korisnika");
				int id_videa = rset.getInt("id_videa");
				
			
				Komentar k = new Komentar();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setSadrzaj(sadrzaj);
				k.setDatumKreiranja(datum_kreiranja);
				
				//vidi koje ce biti od koristi
				k.setId_vlasnika(id_korisnika);
				k.setId_videa(id_videa);
				
				//k.setVlasnik(KorisnikDAL.GetById(id_korisnika));
				//k.setVideo(VideoDAL.GetById(id_videa));
				
				return k;
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
	
	public static Komentar GetByKorisnikId(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM komentari WHERE id_korisnika = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String sadrzaj = rset.getString("sadrzaj");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				int id_korisnika = rset.getInt("id_korisnika");
				int id_videa = rset.getInt("id_videa");
				
			
				Komentar k = new Komentar();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setSadrzaj(sadrzaj);
				k.setDatumKreiranja(datum_kreiranja);
				
				//vidi koje ce biti od koristi
				k.setId_vlasnika(id_korisnika);
				k.setId_videa(id_videa);
				
				//k.setVlasnik(KorisnikDAL.GetById(id_korisnika));
				//k.setVideo(VideoDAL.GetById(id_videa));
				
				return k;
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
	
	
	
	public static boolean Create(Komentar komentar) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO komentari (obrisan, sadrzaj, datum_kreiranja, id_korisnika, id_videa) VALUES (?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
		
			
			pstmt.setBoolean(1, komentar.isObrisan());
			pstmt.setString(2, komentar.getSadrzaj());
			pstmt.setObject(3, komentar.getDatumKreiranja());
			pstmt.setInt(4, komentar.getId_vlasnika());
			pstmt.setInt(5, komentar.getId_videa());
			
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
	
	public static boolean Update(Komentar komentar) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			
			
			String query = "UPDATE komentari SET" +
							"obrisan = ?" +
							"sadrzaj = ?" +
							"datum_kreiranja = ?" +
							"id_korisnika = ?" +
							"id_videa = ?" + 
							"WHERE ID = ?";
							

			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, komentar.isObrisan());
			pstmt.setString(2, komentar.getSadrzaj());
			pstmt.setObject(3, komentar.getDatumKreiranja());
			pstmt.setInt(4, komentar.getId_vlasnika());
			pstmt.setInt(5, komentar.getId_videa());
			
			pstmt.setInt(6, komentar.getId());
			
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
	
	public static boolean Delete(Komentar komentar) {
		komentar.setObrisan(true);
		boolean obrisan = Update(komentar);
		return obrisan;
	}


}
