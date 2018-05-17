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

public class KorisnikDAL {
	
	
	public static ArrayList<Korisnik> getAll(){
		//ConnectionManager.open();
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<Korisnik> korisnici = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {

			String query = "SELECT * FROM korisnici WHERE obrisan = 0";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// citanje rezultata upita
			while (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String kor_ime = rset.getString("kor_ime");
				String lozinka = rset.getString("lozinka");
				String ime = rset.getString("ime");
				String prezime = rset.getString("prezime");
				String email = rset.getString("email");
				String opis = rset.getString("opis");
				Date datum_registracije = rset.getDate("datum_registracije");
				Uloga uloga = Uloga.valueOf(rset.getString("uloga"));
				boolean blokiran = rset.getBoolean("blokiran");
				
				Korisnik k = new Korisnik();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setKorisnickoIme(kor_ime);
				k.setLozinka(lozinka);
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setEmail(email);
				k.setOpisKanala(opis);
				k.setDatumRegistracije(datum_registracije);
				k.setUloga(uloga);
				k.setBlokiran(blokiran);
				
				korisnici.add(k);
				
				
				
				
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return korisnici;
		
		
	}
	
	public static Korisnik Get(String korIme) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM korisnici WHERE kor_ime = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, korIme);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String kor_ime = rset.getString("kor_ime");
				String lozinka = rset.getString("lozinka");
				String ime = rset.getString("ime");
				String prezime = rset.getString("prezime");
				String email = rset.getString("email");
				String opis = rset.getString("opis");
				Date datum_registracije = rset.getDate("datum_registracije");
				Uloga uloga = Uloga.valueOf(rset.getString("uloga"));
				boolean blokiran = rset.getBoolean("blokiran");
				
				Korisnik k = new Korisnik();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setKorisnickoIme(kor_ime);
				k.setLozinka(lozinka);
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setEmail(email);
				k.setOpisKanala(opis);
				k.setDatumRegistracije(datum_registracije);
				k.setUloga(uloga);
				k.setBlokiran(blokiran);
				
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
	
	public static Korisnik GetById(int ID) {
		
		Connection conn = ConnectionManager.getConnection();


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			

			String query = "SELECT * FROM korisnici WHERE id = ? AND obrisan = 0"; 

		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ID);
			System.out.println(pstmt);

			rset = pstmt.executeQuery();


			if (rset.next()) {
				int id = rset.getInt("id");
				boolean obrisan = rset.getBoolean("obrisan");
				String kor_ime = rset.getString("kor_ime");
				String lozinka = rset.getString("lozinka");
				String ime = rset.getString("ime");
				String prezime = rset.getString("prezime");
				String email = rset.getString("email");
				String opis = rset.getString("opis");
				Date datum_registracije = rset.getDate("datum_registracije");
				Uloga uloga = Uloga.valueOf(rset.getString("uloga"));
				boolean blokiran = rset.getBoolean("blokiran");
				
				Korisnik k = new Korisnik();
				k.setId(id);
				k.setObrisan(obrisan);
				k.setKorisnickoIme(kor_ime);
				k.setLozinka(lozinka);
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setEmail(email);
				k.setOpisKanala(opis);
				k.setDatumRegistracije(datum_registracije);
				k.setUloga(uloga);
				k.setBlokiran(blokiran);
				
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
		
	public static boolean Create(Korisnik korisnik) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO korisnici (obrisan, kor_ime, lozinka, ime, prezime, email, opis, datum_registracije, uloga, blokiran) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, korisnik.isObrisan());
			pstmt.setString(2, korisnik.getKorisnickoIme());
			pstmt.setString(3, korisnik.getLozinka());
			pstmt.setString(4, korisnik.getIme());
			pstmt.setString(5, korisnik.getPrezime());
			pstmt.setString(6, korisnik.getEmail());
			pstmt.setString(7, korisnik.getOpisKanala());
			//trebao bi da prebaci java.util.date u date format sql-a - radi driver / getDate trazi java.sql.Date
			pstmt.setObject(8, korisnik.getDatumRegistracije());
			pstmt.setString(9, korisnik.getUloga().toString());
			pstmt.setBoolean(10, korisnik.isBlokiran());
			
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
	
	public static boolean Update(Korisnik korisnik) {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			
			
			String query = "UPDATE korisnici SET" +
							"obrisan = ?" +
							"kor_ime = ?" +
							"lozinka = ?" +
							"ime = ?" +
							"prezime = ?" +
							"email = ?" +
							"opis = ?" + 
							"datum_registracije = ?" +
							"uloga = ?" + 
							"blokiran = ?" + 
							"WHERE ID = ?";
							

			pstmt = conn.prepareStatement(query);
			
			pstmt.setBoolean(1, korisnik.isObrisan());
			pstmt.setString(2, korisnik.getKorisnickoIme());
			pstmt.setString(3, korisnik.getLozinka());
			pstmt.setString(4, korisnik.getIme());
			pstmt.setString(5, korisnik.getPrezime());
			pstmt.setString(6, korisnik.getEmail());
			pstmt.setString(7, korisnik.getOpisKanala());
			pstmt.setObject(8, korisnik.getDatumRegistracije());
			pstmt.setString(9, korisnik.getUloga().toString());
			pstmt.setBoolean(10, korisnik.isBlokiran());
			
			pstmt.setInt(11, korisnik.getId());
			
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
	
	public static boolean Delete(Korisnik korisnik) {
		korisnik.setObrisan(true);
		boolean obrisan = Update(korisnik);
		return obrisan;
	}
		
		
		
		
	
	
	

}
