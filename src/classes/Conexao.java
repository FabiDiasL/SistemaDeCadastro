package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sistemacadastro";

	public static Connection criaConexaoComMySQL() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

	public static void main(String[] args) throws Exception {

		Connection con = criaConexaoComMySQL();

		if (con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}
}