package jdbcjava;
import java.io.*;
import java.sql.*;

public class JDBC_Ex2 {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		ResultSet srs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC", "root","brd901as-kim");
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();
			/*
			 *
			 * 			srs = stmt.executeQuery("select * from student");
			printData(srs, "name", "id", "dept");
			 */

			srs = stmt.executeQuery("select name, id, dept from student where name='�̹���'"); 
			printData(srs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}
	private static void printData(ResultSet srs, String col1, String col2, String col3)
			 throws SQLException {
		while (srs.next()) {
			if (!col1.equals(""))
				System.out.print(srs.getString("name"));
			if ((!col2.equals("")))
				System.out.print("\t|\t" + srs.getString("id"));
			if ((!col3.equals("")))
				System.out.println("\t|\t" + srs.getString("dept"));
			else 
				System.out.println();
		}
	}
}

