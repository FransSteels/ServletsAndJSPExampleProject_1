package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Financieel implements Serializable {
	private Connection con;
	private Statement stmt;
	private String result;

	public Financieel() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fbsfinancial", "root",
				"flapdakda2");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

	}

	public void addExpences(String Name, int amount, String date, String project)
			throws SQLException {
		stmt.execute("INSERT INTO expensesandincommings VALUES (null, '" + Name
				+ "' , CURDATE() , '" + date + "' ," + amount + ", '" + project
				+ "' )");
		stmt.close();
	}

	public int delete(int projectnumber) throws SQLException {
		return stmt
				.executeUpdate("DELETE FROM expensesandincommings WHERE expensesandincommings_id = "
						+ projectnumber);
	}
	public void addUser(String Name, int Tel, String eMail, String dateOfBirth) throws SQLException{
		stmt.execute("INSERT INTO user VALUES ('"+Name+"','" +Tel +"', '"+eMail+"', '"+dateOfBirth+"')");
		stmt.close();
	}
	public void deleteUser(String Name) throws SQLException{
		stmt.execute("DELETE FROM user WHERE Name='"+ Name+ "'");
		stmt.close();
	}

	public Connection getCon() {
		return con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public String getResult() {
		return result;
	}


	public void setResult() throws Exception {
		ResultSet rs = stmt.executeQuery("SELECT*FROM expensesandincommings");
		ResultSetMetaData mdt = rs.getMetaData();
		int x = mdt.getColumnCount();
		StringBuilder restemp = new StringBuilder();

		rs.afterLast();
		while (rs.previous()) {
			int count = 0;
			restemp.append("<pre>");
			for (int i = 0; i < x; i++) {
				restemp.append(rs.getString(i + 1) + "	");
				count++;
				if (count == x) {
					restemp.append("</pre>");
				}
			}
		}
		stmt.close();
		this.result = restemp.toString();
	}

}
