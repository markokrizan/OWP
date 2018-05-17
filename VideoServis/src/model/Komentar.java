package model;

import java.util.ArrayList;
import java.util.Date;

public class Komentar {

	
	private int id;
	private boolean obrisan;
	private String Sadrzaj;
	private Date datumKreiranja;
	
	
	//veze
	
	//da postoji i samo ovako veza
	private int id_vlasnika;
	private int id_videa;
	
	private Korisnik vlasnik;
	private Video video;
	private ArrayList<LikeDislike> lajkova = new ArrayList<LikeDislike>();
	
	public Komentar() {
		
	}

	//get set id
	
	
	

	public String getSadrzaj() {
		return Sadrzaj;
	}

	public ArrayList<LikeDislike> getLajkova() {
		return lajkova;
	}

	public void setLajkova(ArrayList<LikeDislike> lajkova) {
		this.lajkova = lajkova;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public void setSadrzaj(String sadrzaj) {
		Sadrzaj = sadrzaj;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public Korisnik getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Korisnik vlasnik) {
		this.vlasnik = vlasnik;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getId_vlasnika() {
		return id_vlasnika;
	}

	public void setId_vlasnika(int id_vlasnika) {
		this.id_vlasnika = id_vlasnika;
	}

	public int getId_videa() {
		return id_videa;
	}

	public void setId_videa(int id_videa) {
		this.id_videa = id_videa;
	}
	
	
	
}
