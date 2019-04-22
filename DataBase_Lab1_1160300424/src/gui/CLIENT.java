package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class CLIENT{
	public static void main(String[] args){
		DBMSFrame lexframe = new DBMSFrame();
		lexframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lexframe.setResizable(false);
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menu.setBounds(10, 34, 111, 22);
		lexframe.getContentPane().add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u5220\u9664");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u63D2\u5165");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u67E5\u8BE2");
		menu.add(menuItem_2);
		lexframe.setVisible(true);
		
		
	}
	public CLIENT() {
		
	}
}

	
class DBMSFrame extends JFrame implements ActionListener{
		private JPanel contentPane;
		private JFrame frame;
		private JMenuItem mntmCompany;
		private JMenuItem mntmFlight;
		private JMenu tables;
		private JMenuItem mntmPlane;
		private JMenuItem mntmClient;
		private JMenuItem mntmAssurance;
		private Container mntmOrder;
		private JMenuItem mntmOrderdetail;
		private JButton btnSelect;
		private JComboBox TABLES;
		public DBMSFrame() {
			this.setTitle("DBMS");
			this.setSize(900,800);
			initPanel();
		}
		
		
		public void initPanel() {

			//JFrame.setDefaultLookAndFeelDecorated(true);

	        // 创建及设置窗口
	        frame = new JFrame("HelloWorldSwing");

			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(500, 500, 450, 300);
			
			JMenuBar Table=new JMenuBar();
			setJMenuBar(Table);
			 tables= new JMenu("表名");
			
			Table.add(tables);
			
			 mntmFlight = new JMenuItem("flight");
			mntmFlight.setFont(new Font("Consolas", Font.PLAIN, 14));
			tables.add(mntmFlight);
			
			 mntmCompany = new JMenuItem("company");
			tables.add(mntmCompany);
			mntmCompany.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			 mntmPlane = new JMenuItem("plane");
			tables.add(mntmPlane);
			mntmPlane.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			 mntmClient = new JMenuItem("client");
			tables.add(mntmClient);
			mntmClient.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			 mntmAssurance = new JMenuItem("assurance");
			tables.add(mntmAssurance);
			mntmAssurance.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			 mntmOrder = new JMenuItem("order");
			tables.add(mntmOrder);
			mntmOrder.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			 mntmOrderdetail = new JMenuItem("orderdetail");
			tables.add(mntmOrderdetail);
			mntmOrderdetail.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			JMenuItem mntmTicket = new JMenuItem("ticket");
			tables.add(mntmTicket);
			mntmTicket.setFont(new Font("Consolas", Font.PLAIN, 14));
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			
			 btnSelect = new JButton("select");
			btnSelect.setFont(new Font("Consolas", Font.PLAIN, 14));
			btnSelect.setBounds(331, 10, 93, 23);
			contentPane.add(btnSelect);
			
			 TABLES = new JComboBox();
			TABLES.setBounds(10, 10, 176, 23);
			contentPane.add(TABLES);
			TABLES.addItem("");
			
			
			
		
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	

