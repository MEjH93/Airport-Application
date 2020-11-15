package com.comtrade.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.comtrade.transfer.TransferKlasa;

import domen.Konstante;

public class Koumikacija {
	private static Koumikacija koumikacija;
	private Socket socket;
	private Koumikacija() {
		try {
			socket = new Socket(Konstante.IP_ADRESA.getIpAdresa() , Konstante.PORT.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Koumikacija getInstanca() {
		if(koumikacija == null) {
			koumikacija = new Koumikacija();
		}
		return koumikacija;
	}
	public void send(TransferKlasa transferKlasa) {
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferKlasa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public TransferKlasa read() throws ClassNotFoundException, IOException {
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		return (TransferKlasa) objectInputStream.readObject();
	}

}
