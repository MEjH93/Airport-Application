package com.comtrade.view.let;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerKi.KontrolerKi;

import domen.Aviokompanija;
import domen.Let;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class LetForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfPolazak;
	private JTextField tfDolazak;

	private List<Aviokompanija>list;
	private JComboBox cbAvio;
	private int id_Avio;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public LetForma() throws ClassNotFoundException, IOException {
		list = (List<Aviokompanija>) KontrolerKi.getInsatanca().vratiSveAviokompanije().getServer_objekat_response();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("polazak");
		lblNewLabel.setBounds(67, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("dolazak");
		lblNewLabel_1.setBounds(67, 135, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Aviokompanija");
		lblNewLabel_2.setBounds(67, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		 cbAvio = new JComboBox();
		 cbAvio.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String naziv =cbAvio.getSelectedItem().toString();
		 		for(Aviokompanija aviokompanija: list) {
		 			if(naziv.equals(aviokompanija.getNaziv())){
		 				id_Avio= aviokompanija.getId_aviokompanije();
		 			}
		 		}
		 	}
		 });
		cbAvio.setBounds(158, 8, 125, 20);
		contentPane.add(cbAvio);
		
		tfPolazak = new JTextField();
		tfPolazak.setBounds(158, 58, 125, 20);
		contentPane.add(tfPolazak);
		tfPolazak.setColumns(10);
		
		tfDolazak = new JTextField();
		tfDolazak.setColumns(10);
		tfDolazak.setBounds(158, 132, 125, 20);
		contentPane.add(tfDolazak);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polazak = tfPolazak.getText();
				String dolazak = tfDolazak.getText();
				Let let = new Let();
				let.setDolazak(dolazak);
				let.setPolazak(polazak);
				let.setId_avio(id_Avio);
				try {
					KontrolerKi.getInsatanca().upisiLet(let);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUnesi.setBounds(67, 184, 89, 23);
		contentPane.add(btnUnesi);
		postaviUKombo();
	}

	private void postaviUKombo() {
		// TODO Auto-generated method stub
		for(Aviokompanija aviokompanija : list) {
			cbAvio.addItem(aviokompanija.getNaziv());
		}
		
	}
}
