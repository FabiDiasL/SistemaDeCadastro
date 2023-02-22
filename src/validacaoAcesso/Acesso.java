package validacaoAcesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import classesDeConexao.Conexao;
import tela.TelaDeAcesso;

public class Acesso {
	{
		TelaDeAcesso telaDeAcesso = new TelaDeAcesso();
		
		try {
			Connection conn = Conexao.criaConexaoComMySQL();

			String sql = "select * from `scsenhas` where usuario = ? and senha = ?;";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, telaDeAcesso.getTfUsuario().getText());
			pstm.setString(2, new String(telaDeAcesso.getPfSenha().getPassword()));

			ResultSet rset = pstm.executeQuery();

			if (rset.next()) {
				JOptionPane.showMessageDialog(telaDeAcesso, "Usuário encontrado");
			} else {
				JOptionPane.showMessageDialog(telaDeAcesso, "Usuário não encontrado");
			}
			
			rset.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
