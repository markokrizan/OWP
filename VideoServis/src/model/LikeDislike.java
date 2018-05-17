package model;

import java.util.Date;

public class LikeDislike {

	private int id;
	//ako je true like, ako je false dislike
	private boolean like;
	private Date datumKreiranja;
	
	//veza je sa komentarom ili videom, mozda najbolje da bude sa druge strane kroz kolekciju
	
	
	
	public LikeDislike() {
		
	}



	public int getiD() {
		return id;
	}



	public void setiD(int id) {
		this.id = id;
	}



	public boolean isLike() {
		return like;
	}



	public void setLike(boolean like) {
		this.like = like;
	}



	public Date getDatumKreiranja() {
		return datumKreiranja;
	}



	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}




	
	
}
