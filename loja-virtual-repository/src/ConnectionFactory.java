import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private String jdbcUrl = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	private DataSource dataSource;
	private int maxPoolSize = 15;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(jdbcUrl);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);
		comboPooledDataSource.setMaxPoolSize(maxPoolSize);
		this.dataSource = comboPooledDataSource; 
	}

	public Connection recuperarConexao() throws SQLException {
		return dataSource.getConnection();
	}

}
