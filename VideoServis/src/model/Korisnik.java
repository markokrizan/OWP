package model;

import java.util.ArrayList;
import java.util.Date;

public class Korisnik {
	
	//Kanal ustvari
	
	private int id;
	private boolean obrisan;
	
	public enum Uloga{
		NEPRIJAVLJENI,
		KORISNIK,
		ADMINISTRATOR
	}

	private String korisnickoIme;
	private String lozinka;
	
	//opciono
	private String ime;
	private String prezime;
	
	private String email;
	private String opisKanala;
	private Date datumRegistracije;
	private Uloga uloga;
	private boolean blokiran;
	
	//veze
	private ArrayList<Korisnik> pratioci = new ArrayList<>();
	private ArrayList<LikeDislike> lajkoviVidea = new ArrayList<>();
	private ArrayList<LikeDislike> lajkoviKomenatara = new ArrayList<>();
	
	
	
	

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpisKanala() {
		return opisKanala;
	}

	public void setOpisKanala(String opisKanala) {
		this.opisKanala = opisKanala;
	}

	public Date getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public boolean isBlokiran() {
		return blokiran;
	}

	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Korisnik> getPratioci() {
		return pratioci;
	}

	public void setPratioci(ArrayList<Korisnik> pratioci) {
		this.pratioci = pratioci;
	}

	public ArrayList<LikeDislike> getLajkoviVidea() {
		return lajkoviVidea;
	}

	public void setLajkoviVidea(ArrayList<LikeDislike> lajkoviVidea) {
		this.lajkoviVidea = lajkoviVidea;
	}

	public ArrayList<LikeDislike> getLajkoviKomenatara() {
		return lajkoviKomenatara;
	}

	public void setLajkoviKomenatara(ArrayList<LikeDislike> lajkoviKomenatara) {
		this.lajkoviKomenatara = lajkoviKomenatara;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	
	
	
	
	
	
	
	
}
