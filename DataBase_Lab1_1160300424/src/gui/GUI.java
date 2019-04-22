package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBMS;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.activation.FileDataSource;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame {

	private JPanel contentPane;
	//private String deleteField;
	private String cmd;
	private JTextField insertField;
	TableName tn = new TableName();
	TableName ln = new TableName();
	private JTextField sqlField;
	static String filePath = "src//gui//file.txt";
	static HashMap<String,ArrayList<String>> map=new HashMap<>();
	private JTextField selectField;
	private JTextField whereField;
	private JTextField groupField;
	private JTextField fromField;
	private JTextField deleteField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		map=readFile(filePath);
		//System.out.println(map);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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

	public static HashMap<String, ArrayList<String>> readFile(String filePath) {

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		String s;

		String[] col;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			while ((s = in.readLine()) != null) {
				ArrayList<String> list = new ArrayList<>();
				col = s.split("\t");
				String key = col[0];
				for (int i = 1;i< col.length; i++) {
					list.add(col[i]);
				}
				map.put(key, list);
			}

			in.close();
		} catch (IOException e) {
			System.out.println(filePath + "NOT FOUND");
		}
		return map;
	}

	public GUI() {
		String tableName;
		String groupName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 918, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTable = new JLabel("table");
		lblTable.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblTable.setBounds(36, 24, 75, 21);
		contentPane.add(lblTable);
		JLabel groupLable= new JLabel("Group");
		groupLable.setFont(new Font("Consolas", Font.PLAIN, 14));
		groupLable.setBounds(277, 24, 75, 21);
		contentPane.add(groupLable);
		
		JEditorPane Result = new JEditorPane();
		Result.setFont(new Font("宋体", Font.PLAIN, 13));
		Result.setBounds(10, 405, 682, 195);
		contentPane.add(Result);
		
		JComboBox groupBox = new JComboBox();
		groupBox.setFont(new Font("Consolas", Font.PLAIN, 14));
		groupBox.setBounds(335, 23, 143, 22);
		contentPane.add(groupBox);
		// 菜单选项监听器

		ItemListener groupListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (ItemEvent.SELECTED == arg0.getStateChange()) {
					String selectedItem = arg0.getItem().toString();
					ln.name = selectedItem;// 获取选择的列的名字
					
				}
			
			}
		};
		groupBox.addItemListener(groupListener);	
		
		JComboBox tableBox = new JComboBox();
		tableBox.setFont(new Font("Consolas", Font.PLAIN, 14));
		tableBox.setBounds(121, 22, 128, 24);
		contentPane.add(tableBox);
		// 菜单选项监听器

		ItemListener aListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (ItemEvent.SELECTED == arg0.getStateChange()) {
					String selectedItem = arg0.getItem().toString();
					tn.name = selectedItem;// 获取选择的表名字
					String result ="Table name is -- "+tn.name+"\n"
							+"And the values are in the order of "+map.get(tn.name)+"\n"+
							 "if you want to insert,please use NULL if a value is empty";
							Result.setText(result);
				}
				
				//ArrayList<String> groups=map.get(tn.name);
				groupBox.removeAllItems();
				
				for(String s:map.get(tn.name)) {
					groupBox.addItem(s);//将所有的列都加入groupBox中
				}
			}
		};
		tableBox.addItemListener(aListener);
		for(String s:map.keySet())
			tableBox.addItem(s);
		/*tableBox.addItem("aircompany");
		tableBox.addItem("flight");
		tableBox.addItem("airplane");
		tableBox.addItem("client");
		tableBox.addItem("assurance");
		tableBox.addItem("ticket");
		tableBox.addItem("order");
		tableBox.addItem("orderdetail");*/
		
		
		insertField = new JTextField();
		insertField.setFont(new Font("宋体", Font.PLAIN, 14));
		insertField.setBounds(196, 84, 337, 34);
		contentPane.add(insertField);
		insertField.setColumns(10);

		
		JLabel label = new JLabel("Insert");
		label.setFont(new Font("Consolas", Font.PLAIN, 14));
		label.setBounds(36, 85, 123, 21);
		contentPane.add(label);

		sqlField = new JTextField();
		sqlField.setFont(new Font("宋体", Font.PLAIN, 14));
		sqlField.setBounds(196, 309, 337, 34);
		contentPane.add(sqlField);
		sqlField.setColumns(10);

		JLabel lblSql = new JLabel("create SQL Command");
		lblSql.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSql.setBounds(36, 313, 154, 25);
		contentPane.add(lblSql);

		JLabel label_1 = new JLabel("WhiteSpace should be placed between words");
		label_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		label_1.setBounds(36, 53, 442, 20);
		contentPane.add(label_1);

		JButton btnInsert = new JButton("Insert Confirm");
		btnInsert.setFont(new Font("Consolas", Font.PLAIN, 14));
		btnInsert.setBounds(538, 22, 154, 33);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {

			

			// insert函数
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = "insert";
				// TODO Auto-generated method stub
				cmd = insertField.getText();
				
				String insertValue;
				String orders[]= (String[])map.get(tn.name).toArray(new String[map.get(tn.name).size()]) ;
				String sql;
				String value[]=cmd.split(" ");
				String values="";
				for(int i=0;i<map.get(tn.name).size();i++) {
					if(i<value.length) {
						values=values+"\""+value[i]+"\",";
					}else {
						values=values+null+",";//用户不输入的地方设为空
					}
				}
				values=values.substring(0,values.length()-1);
				
				if (cmd.equals("")) {
					sql = sqlField.getText();
				} else {
					sql = "insert into " + tn.name + " values " + "(" +values + ")";
				}
				String result ="Rows will be inserted.\n"+ DBMS.update(sql);
				sqlField.setText(sql);
				Result.setText(result);
			}
		});

		JButton btnDelete = new JButton("Delete Confirm");
		btnDelete.setFont(new Font("Consolas", Font.PLAIN, 14));
		btnDelete.setBounds(538, 53, 154, 33);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//String Result="";
				cmd = deleteField.getText();
				String result;
				String sql;
				if (cmd.equals("")) { //用户不输入条件，就默认删除当前整个整个元组
					sql = "delete from " + tn.name;		
					result="You didn't enter any choice.The whole table has been deleted.";
				} else {
					sql = "delete from " + tn.name + " where " +ln.name+" = "+"\""+cmd+"\"";
					result = "You chose to delete "+ln.name+" = "+cmd+" from table "+tn.name+"\n"
							+ "Rows will be deleted.\n"+DBMS.update(sql);
				}
				
				sqlField.setText(sql);
				Result.setText(result);
			}
		});

		JButton btnSelect = new JButton("Select Confirm");
		btnSelect.setFont(new Font("Consolas", Font.PLAIN, 14));
		btnSelect.setBounds(538, 85, 154, 33);
		contentPane.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String select_string=selectField.getText();//得到用户输入的列名
				String where_string =whereField.getText();  //得到用户输入的查询条件
				String group_string=groupField.getText(); 
				
				String []cmd_group=select_string.split(",");
				String from_string=fromField.getText();  
				//得到用户输入的表名，如果为空就默认为用户当前选择的表
				ArrayList<String> attribute=new ArrayList<String>();
				
				if(from_string.equals("")) {
					from_string=tn.name;
				}
				
				if (select_string.equals("")||select_string.equals("*")) {
					select_string="*";
					
					attribute=map.get(tn.name);
				}else{
					cmd_group=select_string.split(",");
					attribute= new ArrayList<String>(Arrays.asList(cmd_group));
				}
						
				String sql="select "+select_string;
				
				sql="select " +select_string+" from "+from_string;
				if(!where_string.equals("")) {
					sql=sql+" where "+where_string;
				}
				if(!group_string.equals("")) {
					sql=sql+" group by "+group_string;
				}
				
				System.out.println(cmd);
								
				String result = DBMS.execute(sql, attribute);
				System.out.println(result);
			    sqlField.setText(sql);
			    Result.setText(result);
			}
		});

		JLabel lblCommandResult = new JLabel("Command Result");
		lblCommandResult.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblCommandResult.setBounds(36, 355, 123, 27);
		contentPane.add(lblCommandResult);
		
		JLabel lblSelect = new JLabel("SELECT");
		lblSelect.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSelect.setBounds(36, 150, 75, 20);
		contentPane.add(lblSelect);
		
		selectField = new JTextField();
		selectField.setFont(new Font("宋体", Font.PLAIN, 14));
		selectField.setBounds(196, 149, 337, 34);
		contentPane.add(selectField);
		selectField.setColumns(10);
		
		JLabel lblWhere = new JLabel("WHERE");
		lblWhere.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblWhere.setBounds(36, 226, 85, 21);
		contentPane.add(lblWhere);
		
		whereField = new JTextField();
		whereField.setFont(new Font("宋体", Font.PLAIN, 14));
		whereField.setBounds(196, 213, 337, 34);
		contentPane.add(whereField);
		whereField.setColumns(10);
		
		JLabel lblGroup = new JLabel("GROUPBY");
		lblGroup.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblGroup.setBounds(36, 262, 104, 21);
		contentPane.add(lblGroup);
		
		JLabel lblNewLabel = new JLabel("DBMS");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 80, 15);
		contentPane.add(lblNewLabel);
		
		groupField = new JTextField();
		groupField.setFont(new Font("宋体", Font.PLAIN, 14));
		groupField.setBounds(196, 249, 337, 34);
		contentPane.add(groupField);
		groupField.setColumns(10);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblFrom.setBounds(36, 180, 104, 21);
		contentPane.add(lblFrom);
		
		fromField = new JTextField();
		fromField.setFont(new Font("宋体", Font.PLAIN, 14));
		fromField.setBounds(196, 180, 337, 34);
		contentPane.add(fromField);
		fromField.setColumns(10);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblDelete.setBounds(36, 114, 75, 26);
		contentPane.add(lblDelete);
		
		deleteField = new JTextField();
		deleteField.setFont(new Font("宋体", Font.PLAIN, 14));
		deleteField.setBounds(196, 117, 337, 34);
		contentPane.add(deleteField);
		deleteField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 342, 716, -12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 392, 902, 2);
		contentPane.add(separator_1);
		
	
					
	}
		


	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
