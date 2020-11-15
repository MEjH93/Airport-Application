package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.view.aerodrom.AerodromForma;
import com.comtrade.view.aviokomanija.AvioKompanijaForma;
import com.comtrade.view.let.LetForma;
import com.comtrade.view.termin.TerminForma;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MedjuForma extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MedjuForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAerodrom = new JButton("Aerodrom");
		btnAerodrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AerodromForma aerodromForma = null;
				try {
					aerodromForma = new AerodromForma();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				aerodromForma.setVisible(true);
				
			}
		});
		btnAerodrom.setBounds(50, 60, 89, 23);
		contentPane.add(btnAerodrom);
		
		JButton btnAvioKompanija = new JButton("Avio kompanija");
		btnAvioKompanija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AvioKompanijaForma avioKomanija = null;
				try {
					avioKomanija = new AvioKompanijaForma();
					avioKomanija.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//dispose();
				
			}
		});
		btnAvioKompanija.setBounds(226, 60, 123, 23);
		contentPane.add(btnAvioKompanija);
		
		JButton btnTermin = new JButton("Termin");
		btnTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerminForma terminForma = null;
				try {
					terminForma = new TerminForma();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terminForma.setVisible(true);
			}
		});
		btnTermin.setBounds(50, 154, 89, 23);
		contentPane.add(btnTermin);
		
		JButton btnLet = new JButton("Let");
		btnLet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LetForma letForma = null;
				try {
					letForma = new LetForma();
					letForma.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLet.setBounds(226, 154, 123, 23);
		contentPane.add(btnLet);
	}
}
