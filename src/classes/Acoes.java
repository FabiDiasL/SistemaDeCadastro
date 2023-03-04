package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Acoes {

	private int id;
	private String usuario;
	private String senha;

	public Acoes(int id) {
		this.id = id;
	}

	public Acoes(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Acoes(int id, String usuario, String senha) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}

	public void salvar() {
		try {
			Connection conn = Conexao.criaConexaoComMySQL();
			String sql = "insert into `scsenhas`(usuario, senha) values (?, ?);";

			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario);
			pstm.setString(2, senha);
			pstm.execute();

			pstm.close();
			conn.close();

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void atualizar() {
		try {
			Connection conn = Conexao.criaConexaoComMySQL();
			String sql = "update `scsenhas` set usuario = ?, senha = ? where id = ?;";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, senha);
			pstm.setInt(3, id);

			pstm.execute();

			pstm.close();
			conn.close();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void excluir() {
		try {
			Connection conn = Conexao.criaConexaoComMySQL();
			String sql = "delete from `scsenhas` where id = ?;";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.execute();

			pstm.close();
			conn.close();

			JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}