package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.event.ListSelectionEvent;

public class DBMS {
	public static Connection connectToMySQL() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student?" + "useUnicode=true&characterEncoding=utf8"
				+ "&serverTimezone=GMT%2B8&useSSL=false";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "18846086044";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("连接成功");
		return con;
	}

	StackTraceElement[] stacks = new Throwable().getStackTrace();

	public static String getTraceInfo() {
		StringBuffer stringBuffer = new StringBuffer();
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		stringBuffer.append("Exception in [class: ").append(stacks[1].getClassName()).append("][method: ")
				.append(stacks[1].getMethodName()).append("][line: ").append(stacks[1].getLineNumber() + "]");
		return stringBuffer.toString();
	}

	public static String execute(String sql, ArrayList<String> attribute) {
		String result = "";
		try {
			System.out.println(sql);
			System.out.println(attribute);
			Connection con = connectToMySQL();
			
			Statement st =con.createStatement();
			ResultSet rs;
			for (String s : attribute) {
					result=result+"\t"+s;
			}
			result=result+"\n";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String line_result = "";
				for (String s : attribute) {
					String tmp = rs.getString(s);
					line_result =line_result + "\t" + tmp;
				}
				line_result = line_result + "\n";
				result = result + line_result;
			}

			st.close();
			con.close();
		} catch (SQLException e) {
			result = "QueryError" + e.getSQLState() + "\nReasons:" + e.getMessage() + "\n";
			result = result + getTraceInfo();
		}
		System.out.println(result);
		return result;
	}

	public static String update(String sql) {
		String result = "";
		try {

			Connection con = connectToMySQL();
			PreparedStatement ps;
			Statement st = con.createStatement();
			int rs = st.executeUpdate(sql);
			if (rs != 0)
				result = "Success. " + rs + " Rows Have Been Affected";
			else
				result = "Fail. 0 Rows Have Been Affected";
			st.close();
			con.close();
		} catch (SQLException e) {

			result = "QueryError" + e.getSQLState() + "\nReasons:" + e.getMessage() + "\n";
			result = result + getTraceInfo();
		}

		return result;
	}
	public static String query(String sql, String[] attribute) {
		String result = "";
		try {
			System.out.println(sql);
			System.out.println(attribute);
			Connection con = connectToMySQL();
			
			Statement st =con.createStatement();
			ResultSet rs;
			
			result=result+"\n";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String line_result = "";
				for (String s : attribute) {
					String tmp = rs.getString(s);
					line_result =line_result + "\t" + tmp;
				}
				line_result = line_result + "\n";
				result = result + line_result;
			}

			st.close();
			con.close();
		} catch (SQLException e) {
			result = "QueryError" + e.getSQLState() + "\nReasons:" + e.getMessage() + "\n";
			result = result + getTraceInfo();
		}
		System.out.println(result);
		return result;
	}


}
