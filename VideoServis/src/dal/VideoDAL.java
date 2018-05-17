package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Korisnik;
import model.Korisnik.Uloga;
import model.Video;
import model.Video.Vidljivost;

public class VideoDAL {
	
	public static ArrayList<Video> getAll(){
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<Video> klipovi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {

			String query = "SELECT * FROM klipovi WHERE obrisan = 0";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// citanje rezultata upita
			while (rset.next()) {
			
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String url = rset.getString("url");
				String thumbnail = rset.getString("thumbnail");
				String opis = rset.getString("opis");
				Vidljivost vidljivost = Vidljivost.valueOf(rset.getString("vidljivost"));
				boolean dozvoljeni_komentari = rset.getBoolean("dozvoljeni_komentari");
				boolean vidljivost_rejtinga = rset.getBoolean("vidljivost_rejtinga");
				boolean blokiran = rset.getBoolean("blokiran");
				int broj_pregleda = rset.getInt("broj_pregleda");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				
				
				Video v = new Video();
				v.setId(id);
				v.setObrisan(obrisan);
				v.setUrl(url);
				v.setThumbnail(thumbnail);
				v.setOpis(opis);
				v.setVidljivost(vidljivost);
				v.setDozvoljeniKomentari(dozvoljeni_komentari);
				v.setVidljivostRejtinga(vidljivost_rejtinga);
				v.setBlokiran(blokiran);
				v.setBrojPregleda(broj_pregleda);
				v.setDatumKreiranja(datum_kreiranja);
				
				klipovi.add(v);
				
				
				
				
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return klipovi;
		
		
	}
	
	public static Video Get(String URL) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM klipovi WHERE url = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, URL);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String url = rset.getString("url");
				String thumbnail = rset.getString("thumbnail");
				String opis = rset.getString("opis");
				Vidljivost vidljivost = Vidljivost.valueOf(rset.getString("vidljivost"));
				boolean dozvoljeni_komentari = rset.getBoolean("dozvoljeni_komentari");
				boolean vidljivost_rejtinga = rset.getBoolean("vidljivost_rejtinga");
				boolean blokiran = rset.getBoolean("blokiran");
				int broj_pregleda = rset.getInt("broj_pregleda");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				
				
				Video v = new Video();
				v.setId(id);
				v.setObrisan(obrisan);
				v.setUrl(url);
				v.setThumbnail(thumbnail);
				v.setOpis(opis);
				v.setVidljivost(vidljivost);
				v.setDozvoljeniKomentari(dozvoljeni_komentari);
				v.setVidljivostRejtinga(vidljivost_rejtinga);
				v.setBlokiran(blokiran);
				v.setBrojPregleda(broj_pregleda);
				v.setDatumKreiranja(datum_kreiranja);
				
				return v;
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
	
	public static Video GetById(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM klipovi WHERE id = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String url = rset.getString("url");
				String thumbnail = rset.getString("thumbnail");
				String opis = rset.getString("opis");
				Vidljivost vidljivost = Vidljivost.valueOf(rset.getString("vidljivost"));
				boolean dozvoljeni_komentari = rset.getBoolean("dozvoljeni_komentari");
				boolean vidljivost_rejtinga = rset.getBoolean("vidljivost_rejtinga");
				boolean blokiran = rset.getBoolean("blokiran");
				int broj_pregleda = rset.getInt("broj_pregleda");
				Date datum_kreiranja = rset.getDate("datum_kreiranja");
				
				
				
				Video v = new Video();
				v.setId(id);
				v.setObrisan(obrisan);
				v.setUrl(url);
				v.setThumbnail(thumbnail);
				v.setOpis(opis);
				v.setVidljivost(vidljivost);
				v.setDozvoljeniKomentari(dozvoljeni_komentari);
				v.setVidljivostRejtinga(vidljivost_rejtinga);
				v.setBlokiran(blokiran);
				v.setBrojPregleda(broj_pregleda);
				v.setDatumKreiranja(datum_kreiranja);
				
				return v;
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
		
	public static boolean Create(Video video) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO klipovi (obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			
		
			
			pstmt.setBoolean(1, video.isObrisan());
			pstmt.setString(2, video.getUrl());
			pstmt.setString(3, video.getThumbnail());
			pstmt.setString(4, video.getOpis());
			pstmt.setString(5, video.getVidljivost().toString());
			pstmt.setBoolean(6, video.isDozvoljeniKomentari());
			pstmt.setBoolean(7, video.isVidljivostRejtinga());
			pstmt.setBoolean(8, video.isBlokiran());
			pstmt.setInt(9, video.getBrojPregleda());
			pstmt.setObject(10, video.getDatumKreiranja());
			
			
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
	
	public static boolean Update(Video video) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			
			
			String query = "UPDATE klipovi SET" +
							"obrisan = ?" +
							"url = ?" +
							"thumbnail = ?" +
							"opis = ?" +
							"vidljivost = ?" +
							"dozvoljeni_komentari = ?" +
							"vidljivost_rejtinga = ?" + 
							"blokiran = ?" +
							"broj_pregleda = ?" + 
							"datum_kreiranja = ?" + 
							"WHERE ID = ?";
							

			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, video.isObrisan());
			pstmt.setString(2, video.getUrl());
			pstmt.setString(3, video.getThumbnail());
			pstmt.setString(4, video.getOpis());
			pstmt.setString(5, video.getVidljivost().toString());
			pstmt.setBoolean(6, video.isDozvoljeniKomentari());
			pstmt.setBoolean(7, video.isVidljivostRejtinga());
			pstmt.setBoolean(8, video.isBlokiran());
			pstmt.setInt(9, video.getBrojPregleda());
			pstmt.setObject(10, video.getDatumKreiranja());
			
			pstmt.setInt(11, video.getId());
			
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
	
	public static boolean Delete(Video video) {
		video.setObrisan(true);
		boolean obrisan = Update(video);
		return obrisan;
	}

}
