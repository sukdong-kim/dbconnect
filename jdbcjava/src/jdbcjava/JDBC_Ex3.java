package jdbcjava;
import java.io.*;
import java.sql.*;

public class JDBC_Ex3 {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC", "root","brd901as-kim");
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();
 			stmt.executeUpdate("insert into student (name, id, dept) values('�ƹ���', '0893012', '��ǻ�Ͱ���');");
			printTable(stmt);
			stmt.executeUpdate( "update student set id='0189011' where name='�ƹ���'");
			printTable(stmt);
			stmt.executeUpdate("delete from student where name='�ƹ���'");
			printTable(stmt);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} 
}
private static void printTable(Statement stmt) throws SQLException {
		ResultSet srs = stmt.executeQuery("select * from student");
		while (srs.next()) {
			System.out.print(srs.getString("name"));
			System.out.print("\t|\t" + srs.getString("id"));
			System.out.println("\t|\t" + srs.getString("dept"));
		}
	}
}
