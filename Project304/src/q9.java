import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q9 {

	public static ArrayList<String> query9() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/project304";
		String user = "root";
		String password = "Andy51012";

		ArrayList<String> results = new ArrayList<String>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT C.CNAME, C.ADDRESS "
					+ "FROM Customer C " + "WHERE C.CNAME IN "
					+ "(SELECT P.CNAME " + "FROM Purchase P "
					+ "WHERE P.FNAME = 'Popcorns' )");

			
			while (rs.next()) {

				results.add(rs.getString(1) + " " + rs.getString(2));

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
		return query9();
	}

}