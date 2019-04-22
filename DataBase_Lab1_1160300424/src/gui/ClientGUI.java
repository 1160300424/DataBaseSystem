package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.DBMS;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;


public class ClientGUI extends JFrame {

  private JPanel contentPane;  
  private String textfield ;
  TableName tn = new TableName();
  private JTextField sqlField;
  static HashMap<String, ArrayList<String>> Table_Column = new HashMap<>();
  TableName cn = new TableName();
  private JTextField stuId;
  private JTextField stuName;
  private JTextField agefrom;
  private JTextField ageto;
  private JTextField classno;
  private JTextField studept;
  private JTextField stuaddress;
  private JTextField stugender;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ClientGUI frame = new ClientGUI();
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
  public ClientGUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 719, 641);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JEditorPane displayarea = new JEditorPane();
    displayarea.setBounds(10, 328, 683, 278);
    contentPane.add(displayarea);
    
    sqlField = new JTextField();
    sqlField.setBounds(121, 234, 574, 42);
    contentPane.add(sqlField);
    sqlField.setColumns(10);
    
    JLabel lblSql = new JLabel("SQL语句");
    lblSql.setBounds(43, 245, 72, 18);
    contentPane.add(lblSql);
    
    JButton btnSelect = new JButton("查询");
    btnSelect.setFont(new Font("宋体", Font.PLAIN, 20));
    
    btnSelect.setBounds(584, 31, 92, 107);
    contentPane.add(btnSelect);
    
    JCheckBox chckbxStudentID = new JCheckBox("学号");
    chckbxStudentID.setFont(new Font("宋体", Font.PLAIN, 14));
    chckbxStudentID.setBounds(36, 30, 65, 28);
    contentPane.add(chckbxStudentID);
    
    stuId = new JTextField();
    stuId.setBounds(121, 31, 123, 27);
    contentPane.add(stuId);
    stuId.setColumns(10);
    
    JCheckBox chckbxStudentname = new JCheckBox("姓名");
    chckbxStudentname.setBounds(36, 73, 65, 28);
    chckbxStudentname.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(chckbxStudentname);
    
    stuName = new JTextField();
    stuName.setBounds(121, 74, 123, 27);
    contentPane.add(stuName);
    stuName.setColumns(10);
    
    JCheckBox chckbxAgeFrom = new JCheckBox("年龄");
    chckbxAgeFrom.setFont(new Font("宋体", Font.PLAIN, 14));
    chckbxAgeFrom.setBounds(36, 170, 65, 28);
    contentPane.add(chckbxAgeFrom);
    
    agefrom = new JTextField();
    agefrom.setBounds(198, 172, 46, 26);
    contentPane.add(agefrom);
    agefrom.setColumns(10);
    
    JLabel lblTo = new JLabel("到");
    lblTo.setFont(new Font("宋体", Font.PLAIN, 14));
    lblTo.setBounds(177, 172, 32, 24);
    contentPane.add(lblTo);
    
    ageto = new JTextField();
    ageto.setBounds(121, 173, 46, 24);
    contentPane.add(ageto);
    ageto.setColumns(10);
    
    JCheckBox chckbxClass = new JCheckBox("班级");
    chckbxClass.setBounds(307, 30, 72, 27);
    chckbxClass.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(chckbxClass);
    
    JCheckBox chckbxDept = new JCheckBox("系别");
    chckbxDept.setFont(new Font("宋体", Font.PLAIN, 14));
    chckbxDept.setBounds(307, 73, 58, 28);
    contentPane.add(chckbxDept);
    
    JCheckBox chckbxAddress = new JCheckBox("地址");
    chckbxAddress.setFont(new Font("宋体", Font.PLAIN, 14));
    chckbxAddress.setBounds(307, 120, 58, 28);
    contentPane.add(chckbxAddress);
    
    classno = new JTextField();
    classno.setBounds(384, 31, 142, 27);
    contentPane.add(classno);
    classno.setColumns(10);
    
    studept = new JTextField();
    studept.setBounds(384, 74, 142, 28);
    contentPane.add(studept);
    studept.setColumns(10);
    
    stuaddress = new JTextField();
    stuaddress.setBounds(384, 121, 142, 28);
    contentPane.add(stuaddress);
    stuaddress.setColumns(10);
    
    JCheckBox chckbxGender = new JCheckBox("性别");
    chckbxGender.setFont(new Font("宋体", Font.PLAIN, 14));
    chckbxGender.setBounds(36, 121, 65, 27);
    contentPane.add(chckbxGender);
    
    stugender = new JTextField();
    stugender.setBounds(121, 123, 123, 25);
    contentPane.add(stugender);
    stugender.setColumns(10);
    
    JLabel labelID = new JLabel("学号");
    labelID.setBounds(24, 291, 42, 33);
    labelID.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelID);
    JLabel labelName = new JLabel("姓名");
    labelName.setBounds(111, 290, 50, 37);
    labelName.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelName);
    JLabel labelGender = new JLabel("性别");
    labelGender .setBounds(187, 295, 46, 28);
    labelGender .setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelGender );
    JLabel labelAge = new JLabel("年龄");
    labelAge.setBounds(260, 291, 39, 33);
    labelAge.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelAge);
    JLabel labelDept = new JLabel("系别");
    labelDept.setBounds(333, 294, 79, 33);
    labelDept.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelDept);
    JLabel labelClass= new JLabel("班级");
    labelClass.setBounds(395, 292, 92, 34);
    labelClass.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelClass);
    JLabel labelAdd= new JLabel("地址");
    labelAdd.setBounds(473, 295, 52, 33);
    labelAdd.setFont(new Font("宋体", Font.PLAIN, 14));
    contentPane.add(labelAdd);
    
    btnSelect.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String sql ="select * from student where ";
      if(chckbxStudentID.isSelected()) {
        String id=stuId.getText();
        if(id.contains("%")) {
        	sql=sql+"( sid like \'"+id+"\' ) and ";
        }else {
        	sql=sql+"( sid = \'"+id+"\' ) and ";
        }
      }
      if(chckbxStudentname.isSelected()) {
       String name=stuName.getText();
       if(name.contains("%")) {
       	sql=sql+"( sname like \'"+name+"\' ) and ";
       }else {
       	sql=sql+"( sname = \'"+name+"\' ) and ";
       }
      }
      if(chckbxGender.isSelected()) {
       String gender=stugender.getText();
       sql=sql+"( sgender = \'"+gender+"\' ) and ";
      }
      if(chckbxAgeFrom.isSelected()) {
       String from=agefrom.getText();
       sql=sql+"( sage >= \'"+from+"\' ) and ";
      }
      if (chckbxDept.isSelected()) {
        String to=ageto.getText();
       
        sql=sql+"( sage <= \'"+to+"\' ) and ";
      }
      if(chckbxClass.isSelected()) {
    	  String class_num=chckbxClass.getText();
    	  if(class_num.contains("%")) {
    		 sql=sql+"( sclass like \'"+class_num+"\' ) and "; 
    	  }else {
    		  sql=sql+"( sclass = \'"+class_num+"\' ) and "; 
    	  }
      }if(chckbxAddress.isSelected()) {
    	  String addr=chckbxAddress.getText();
    	  if(addr.contains("%")) {
     		 sql=sql+"( saddr like \'"+addr+"\' ) and "; 
     	  }else {
     		  sql=sql+"( saddr = \'"+addr+"\' ) and "; 
     	  }
      }
        sql=sql.substring(0, sql.length()-4);
        String []attribute= {"sid","sname","sgender","sage","sdept","sclass","saddr"};
      	String result=DBMS.query(sql,attribute);
        sqlField.setText(sql);
        displayarea.setText(result);
       }
     });
    
        
  }
  
}
