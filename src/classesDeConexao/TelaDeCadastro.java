package classesDeConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;

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
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("ID");
		lbId.setBounds(10, 49, 45, 13);
		contentPane.add(lbId);
		
		JLabel lbUsuario = new JLabel("USUÁRIO");
		lbUsuario.setBounds(10, 88, 45, 13);
		contentPane.add(lbUsuario);
		
		JLabel lbSenha = new JLabel("SENHA");
		lbSenha.setBounds(10, 133, 45, 13);
		contentPane.add(lbSenha);
		
		tfId = new JTextField();
		tfId.setBounds(81, 46, 96, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(81, 85, 192, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(81, 130, 192, 19);
		contentPane.add(tfSenha);
	}
}
