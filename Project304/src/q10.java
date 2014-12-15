import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q10 {

	public static ArrayList<String> query10() {
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
			rs = st.executeQuery("SELECT W.PNAME " + "FROM WorksIn W "
					+ "WHERE W.MNAME IN " + "(SELECT M.MNAME "
					+ "FROM Movies M " + "WHERE M.RATING > 8)");

			while (rs.next()) {

				results.add(rs.getString(1));

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
		return query10();
	}

}