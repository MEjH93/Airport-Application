package com.comtrade.proxy.logovanje;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.comtrade.controlerKi.KontrolerKi;
import com.comtrade.view.MedjuForma;
import com.comtrade.view.rezervacija.RezervacijaFroma;

import domen.User;

public class ProxyLogin implements IProxy {
	private static final String ADMIN ="admin";
	private static final String USER ="user";

	@Override
	public void login(User user) throws ClassNotFoundException, IOException {
		User user2 = (User) KontrolerKi.getInsatanca().login(user).getServer_objekat_response();
		if (user2.getUsername() != null && user2.getPassword() != null && user2.getStatus().equals(ADMIN)) {
			MedjuForma medjuForma = new MedjuForma();
			medjuForma.setVisible(true);
		} else if (user2.getUsername() != null && user2.getPassword() != null && user2.getStatus().equals(USER)) {
			RezervacijaFroma rezervacijaFroma = new RezervacijaFroma(user2);
			rezervacijaFroma.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Neuspesno logavnje");
		}

	}
}
