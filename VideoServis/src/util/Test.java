package util;

import java.sql.Connection;
import java.util.ArrayList;

import dal.ConnectionManager;
import dal.KorisnikDAL;
import model.Korisnik;

public class Test {
	
	
	
	public static void main(String[] args) {
		ArrayList<Korisnik> list = KorisnikDAL.getAll();
		
		for(Korisnik k : list) {
			System.out.println(k.getId() + " " + k.getIme());
			
		}
		
		
	}
	
	
	

}
