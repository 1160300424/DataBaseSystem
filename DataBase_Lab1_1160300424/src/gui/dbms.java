package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class dbms extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbms frame = new dbms();
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
	public dbms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8868\u540D");
		menuBar.add(menu);
		
		JMenuItem mntmClient = new JMenuItem("client");
		menu.add(mntmClient);
		
		JMenuItem mntmPlane = new JMenuItem("plane");
		menu.add(mntmPlane);
		
		JMenuItem mntmFlight = new JMenuItem("flight");
		menu.add(mntmFlight);
		
		JMenuItem mntmAircompany = new JMenuItem("aircompany");
		menu.add(mntmAircompany);
		
		JMenuItem mntmOrder = new JMenuItem("order");
		menu.add(mntmOrder);
		
		JMenuItem mntmOrderdetail = new JMenuItem("orderdetail");
		menu.add(mntmOrderdetail);
		
		JMenuItem mntmAssurance = new JMenuItem("assurance");
		menu.add(mntmAssurance);
		
		JMenuItem mntmTicket = new JMenuItem("ticket");
		menu.add(mntmTicket);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblWelcom = new JLabel("Welcom");
		lblWelcom.setBounds(159, 107, 117, 48);
		lblWelcom.setFont(new Font("Consolas", Font.PLAIN, 14));
		contentPane.add(lblWelcom);		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
