package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerKi.KontrolerKi;
import com.comtrade.proxy.logovanje.IProxy;
import com.comtrade.proxy.logovanje.ProxyLogin;
import com.comtrade.transfer.TransferKlasa;

import domen.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RegistracijaLogovanje extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JPasswordField pfPassword1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaLogovanje frame = new RegistracijaLogovanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistracijaLogovanje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(93, 23, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(218, 23, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(93, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 46, 104, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textField.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
			
				IProxy iProxy = new ProxyLogin();
				try {
					iProxy.login(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(365, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(32, 149, 422, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Registracija");
		lblNewLabel_2.setBounds(134, 11, 110, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(61, 58, 71, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(61, 107, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(61, 152, 46, 14);
		panel.add(lblNewLabel_5);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(175, 55, 86, 20);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(176, 104, 85, 20);
		panel.add(pfPassword);
		
		pfPassword1 = new JPasswordField();
		pfPassword1.setBounds(175, 149, 85, 20);
		panel.add(pfPassword1);
		
		JButton btnNewButton_1 = new JButton("Registracija");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				String password1 = String.copyValueOf(pfPassword1.getPassword());
				if(password.equals(password1)) {
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setStatus("user");
					try {
						TransferKlasa tk= KontrolerKi.getInsatanca().sacuvajUser(user);
						String poruka = tk.getPoruka_response();
						ocistiFildove();
						JOptionPane.showMessageDialog(null,poruka);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(172, 180, 89, 23);
		panel.add(btnNewButton_1);
	}
	public void ocistiFildove() {
		tfUsername.setText("");
		pfPassword.setText("");
		pfPassword1.setText("");
	}
}
