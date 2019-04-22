package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class dg extends JFrame {

	private JPanel JP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dg frame = new dg();
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
	public dg() {
		int fraWidth = this.getWidth();//frame的宽
		int fraHeight = this.getHeight();//frame的高
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		this.setSize(screenWidth, screenHeight);
		this.setLocation(0, 0);
		float proportionW = screenWidth/fraWidth;
		float proportionH = screenHeight/fraHeight;
		
		modifyComponentSize(this, proportionW,proportionH);
		this.toFront();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JP = new JPanel();
		JP.setPreferredSize(new Dimension(200, 200));
		JP.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(JP);
		
		Container c=getContentPane();
		JTextArea ResultArea = new JTextArea();
		ResultArea.setBounds(0, 155, 434, 106);
		JP.add(ResultArea);
		c.add(JP);
		
		JScrollPane ScrollPane = new JScrollPane(ResultArea);
		ScrollPane.setBounds(0, 257, 2, 100);
		JP.add(ScrollPane);
		ScrollPane.add(ResultArea);
		ScrollPane.setSize(300,180);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
public static void modifyComponentSize(JFrame frame,float proportionW,float proportionH){	
		try 
		{
			Component[] components = frame.getRootPane().getContentPane().getComponents();
			for(Component co:components)
			{
//				String a = co.getClass().getName();//获取类型名称
//				if(a.equals("javax.swing.JLabel"))
//				{
//				}
				float locX = co.getX() * proportionW;
				float locY = co.getY() * proportionH;
				float width = co.getWidth() * proportionW;
				float height = co.getHeight() * proportionH;
				co.setLocation((int)locX, (int)locY);
				co.setSize((int)width, (int)height);
				int size = (int)(co.getFont().getSize() * proportionH);
				Font font = new Font(co.getFont().getFontName(), co.getFont().getStyle(), size);
				co.setFont(font);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}
