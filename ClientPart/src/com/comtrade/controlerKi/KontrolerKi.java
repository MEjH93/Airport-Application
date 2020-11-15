package com.comtrade.controlerKi;

import java.io.IOException;
import java.util.List;

import com.comtrade.komunikacija.Koumikacija;
import com.comtrade.transfer.TransferKlasa;

import domen.Aerodrom;
import domen.Aviokompanija;
import domen.Konstante;
import domen.Let;
import domen.Operacije;
import domen.Rezervacija;
import domen.Termin;
import domen.User;

public class KontrolerKi {
	private static KontrolerKi instanca;
	private KontrolerKi() {
		
	}
	public static KontrolerKi getInsatanca() {
		if(instanca == null) {
			instanca = new KontrolerKi();
		}
		return instanca;
	}
	public TransferKlasa sacuvajUser(User user) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(user);
		transferKlasa.setOperacija(Operacije.SACUVAJ_USERA);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa login(User user) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(user);
		transferKlasa.setOperacija(Operacije.LOGIN_USERA);
		return vrati(transferKlasa);
		
		
	}
	
	public TransferKlasa vratiSvePodatke() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_SVE_AERODROME);
		return vrati(transferKlasa);
	}
	public TransferKlasa upisiAerodrom(Aerodrom aerodrom) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(aerodrom);
		transferKlasa.setOperacija(Operacije.SACUVAJ_AERODROM);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa vrati(TransferKlasa transferKlasa) throws ClassNotFoundException, IOException {
		Koumikacija.getInstanca().send(transferKlasa);
		TransferKlasa transferKlasa2 = Koumikacija.getInstanca().read();
		return transferKlasa2;
	}
	public TransferKlasa updateAerodroma(Aerodrom aerodrom) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(aerodrom);
		transferKlasa.setOperacija(Operacije.UPDATE_AERODROM);
		return vrati(transferKlasa);
	}
	public TransferKlasa obrisiAerodrom(Aerodrom aerodrom) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(aerodrom);
		transferKlasa.setOperacija(Operacije.BRISANJE_AERODROM);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa upisiAviokompaniju(Aviokompanija aviokomanija) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(aviokomanija);
		transferKlasa.setOperacija(Operacije.SACUVAJ_AVIOKOMPANIJA);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa vratiSveAviokompanije() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_SVE_AVIOKOMPANIJE);
		return vrati(transferKlasa);
		
		
	}
	public TransferKlasa upisiLet(Let let) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(let);
		transferKlasa.setOperacija(Operacije.SACUVAJ_LET);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa vratiSveLetove() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_SVE_LETOVE);
		return vrati(transferKlasa);
	}
	public TransferKlasa upisiTermin(Termin termin) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(termin);
		transferKlasa.setOperacija(Operacije.SACUVAJ_TERMIN);
		return vrati(transferKlasa);
		
	}
	public TransferKlasa vratiTermine() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_SVE_TERMINE);
		return vrati(transferKlasa);
	}
	public TransferKlasa upisiRezervaciju(Rezervacija rezervacija) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_objekat_request(rezervacija);
		transferKlasa.setOperacija(Operacije.SACUVAJ_REZERVACIJU);
		return vrati(transferKlasa);
		
		
	}

}
