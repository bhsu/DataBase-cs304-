import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q1 {

	public static ArrayList<String> query1() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<String> results = new ArrayList<String>();

		String url = "jdbc:mysql://localhost:3306/project304";
		String user = "root";
		String password = "Andy51012";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * from Movies");

			while (rs.next()) {

				results.add(rs.getString(1) + " " + rs.getString(2) + " "
						+ rs.getInt(3) + " " + rs.getFloat(4) + " "
						+ rs.getInt(5) + " " + rs.getInt(6));

			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DataBase.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DataBase.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return results;
	}

	public static ArrayList<String> main(String[] args) {

		return query1();
	}

}
