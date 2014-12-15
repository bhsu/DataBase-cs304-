import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertInto {

	public static void insert(String n, String g, int m, double r, int l, String rd) {
		
		
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/project304";
		String user = "root";
		String password = "Andy51012";

		
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String sql = "INSERT INTO Movies "
					+ "VALUES  ( '"+n+"', '"+g+"',  "+m+", "+r+", "+l+", '"+rd+"')";
			st.executeUpdate(sql);
			
			rs = st.executeQuery("SELECT * from Movies");
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2)
						+ " " + rs.getString(3) + " " + rs.getString(4) + " "
						+ rs.getString(5) + " " + rs.getString(6));
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
	}

	public static void main(String[] args) {
		insert(null, null, 0, 0.0, 0, null);

	}
}