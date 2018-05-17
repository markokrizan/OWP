package model;

import java.util.ArrayList;
import java.util.Date;

public class Video {
	
	public enum Vidljivost{
		JAVNI,
		UNLISTED,
		PRIVATNI
	}
	
	private int id;
	private boolean obrisan;
	
	//URL
	private String url;
	private String thumbnail;
	
	private String opis;
	private Vidljivost vidljivost;
	private boolean dozvoljeniKomentari;
	
	//broja lajkova i dislajkova
	private boolean vidljivostRejtinga;
	private boolean blokiran;
	private int brojPregleda;
	private Date datumKreiranja;
	
	
	//veze
	private Korisnik vlasnik;
	private ArrayList<LikeDislike> lajkova = new ArrayList<LikeDislike>();
	
	
	

	//videcemo da li ce trebati sa parametrima konstruktor

	public int getId() {
		return id;
	}

	

	public boolean isObrisan() {
		return obrisan;
	}



	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}



	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<LikeDislike> getLajkova() {
		return lajkova;
	}


	public void setLajkova(ArrayList<LikeDislike> lajkova) {
		this.lajkova = lajkova;
	}


	


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public Vidljivost getVidljivost() {
		return vidljivost;
	}


	public void setVidljivost(Vidljivost vidljivost) {
		this.vidljivost = vidljivost;
	}


	public boolean isDozvoljeniKomentari() {
		return dozvoljeniKomentari;
	}


	public void setDozvoljeniKomentari(boolean dozvoljeniKomentari) {
		this.dozvoljeniKomentari = dozvoljeniKomentari;
	}


	public boolean isVidljivostRejtinga() {
		return vidljivostRejtinga;
	}


	public void setVidljivostRejtinga(boolean vidljivostRejtinga) {
		this.vidljivostRejtinga = vidljivostRejtinga;
	}


	public boolean isBlokiran() {
		return blokiran;
	}


	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
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



	public int getBrojPregleda() {
		return brojPregleda;
	}



	public void setBrojPregleda(int brojPregleda) {
		this.brojPregleda = brojPregleda;
	}
	
	
	
	
	
	//METODE
	//1. da sece url - mozda u js-u na frontu odma, valja se
	
	
	
}
