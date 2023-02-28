package classesDeConexao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeCadastro() {
		setResizable(false);
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("ID");
		lbId.setForeground(new Color(0, 0, 255));
		lbId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbId.setBounds(10, 49, 45, 13);
		contentPane.add(lbId);
		
		JLabel lbUsuario = new JLabel("USUÁRIO");
		lbUsuario.setForeground(new Color(0, 0, 255));
		lbUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbUsuario.setBounds(10, 88, 84, 19);
		contentPane.add(lbUsuario);
		
		JLabel lbSenha = new JLabel("SENHA");
		lbSenha.setForeground(new Color(0, 0, 255));
		lbSenha.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbSenha.setBounds(10, 133, 71, 16);
		contentPane.add(lbSenha);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(130, 49, 96, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(130, 88, 192, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(130, 130, 192, 19);
		contentPane.add(tfSenha);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 248, 416, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Conexao.criaConexaoComMySQL();
					String sql = "insert into `scsenhas`(usuario, senha) values (?, ?);";
					
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setString(1, tfUsuario.getText());
					pstm.setString(2, tfSenha.getText());
					pstm.execute();
					
					pstm.close();
					conn.close();
					
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");	
					
					tfUsuario.setText("");
					tfSenha.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnSalvar.setBounds(29, 20, 85, 21);
		panel.add(btnSalvar);
	}
}
