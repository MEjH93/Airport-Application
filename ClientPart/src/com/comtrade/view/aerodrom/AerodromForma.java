package com.comtrade.view.aerodrom;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerKi.KontrolerKi;
import com.comtrade.transfer.TransferKlasa;

import domen.Aerodrom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AerodromForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	List<Aerodrom>list; 
	private int idAerodrom;

	public AerodromForma() throws ClassNotFoundException, IOException {
		list= (List<Aerodrom>) KontrolerKi.getInsatanca().vratiSvePodatke().getServer_objekat_response();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setBounds(60, 104, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(166, 101, 86, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String naziv = tfNaziv.getText();
				Aerodrom aerodrom = new Aerodrom();
				aerodrom.setNaziv(naziv);
				try {
					TransferKlasa transferKlasa = KontrolerKi.getInsatanca().upisiAerodrom(aerodrom);
					setInsert(transferKlasa);
					postaviPodatkeNatabelu();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUnesi.setBounds(31, 187, 89, 23);
		contentPane.add(btnUnesi);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferKlasa transferKlasa = null;
				try {
					String naziv = tfNaziv.getText();
					Aerodrom aerodrom = new Aerodrom();
					aerodrom.setNaziv(naziv);
					aerodrom.setId_aerodrom(idAerodrom);
					transferKlasa = KontrolerKi.getInsatanca().updateAerodroma(aerodrom);
					setUpdate(transferKlasa);
					postaviPodatkeNatabelu();
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, transferKlasa.getPoruka_response());
				}
			}
		});
		btnIzmeni.setBounds(177, 187, 89, 23);
		contentPane.add(btnIzmeni);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aerodrom aerodrom = new Aerodrom();
				aerodrom.setId_aerodrom(idAerodrom);
				try {
				
					TransferKlasa transferKlasa=	KontrolerKi.getInsatanca().obrisiAerodrom(aerodrom);
					//list.remove(aerodrom);
					setDelete(aerodrom);
					postaviPodatkeNatabelu();
					JOptionPane.showMessageDialog(null,transferKlasa.getPoruka_response());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnObrisi.setBounds(320, 187, 89, 23);
		contentPane.add(btnObrisi);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 257, 378, 147);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				String naziv = table.getModel().getValueAt(red, 1).toString();
				tfNaziv.setText(naziv);
				idAerodrom = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		Object[]kolone =new Object[2];
		
		kolone[0]="id";
		kolone[1]="naziv";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		postaviPodatkeNatabelu();
	}

	protected void setDelete(Aerodrom aerodrom) {
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).getId_aerodrom() == aerodrom.getId_aerodrom()) {
				list.remove(i);
			}
		}
		
	}

	protected void postaviPodatkeNatabelu() throws ClassNotFoundException, IOException {
		
		dtm.setRowCount(0);
		Object[]red = new Object[2];
		for(Aerodrom aerodrom : list) {
			red[0]=aerodrom.getId_aerodrom();
			red[1]=aerodrom.getNaziv();
			dtm.addRow(red);
		}
		
	}
	public void setInsert(TransferKlasa transferKlasa) {
		if(transferKlasa != null) {
			Aerodrom aerodr= (Aerodrom)transferKlasa.getServer_objekat_response();
			list.add(aerodr);
		}
	}
	public void setUpdate(TransferKlasa transferKlasa) {
		Aerodrom aerodrom = (Aerodrom) transferKlasa.getServer_objekat_response();
		int id = aerodrom.getId_aerodrom();
		for(int i= 0; i < list.size();i++) {
			if(list.get(i).getId_aerodrom() == id) {
				list.set(i, aerodrom);
			}
		}
		
	}
}
