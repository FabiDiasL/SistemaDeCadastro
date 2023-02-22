package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import validacaoAcesso.Acesso;

public class TelaDeAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public JPasswordField getPfSenha() {
		return pfSenha;
	}
	
	public void setTfUsuario(JTextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public void setPfSenha(JPasswordField pfSenha) {
		this.pfSenha = pfSenha;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAcesso frame = new TelaDeAcesso();
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
	public TelaDeAcesso() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 68, 76, 29);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.BLUE);
		lblSenha.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblSenha.setBounds(20, 110, 76, 29);
		contentPane.add(lblSenha);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tfUsuario.setBounds(117, 76, 96, 27);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(117, 118, 96, 27);
		contentPane.add(pfSenha);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Acesso();
			}
		});

		btnAcessar.setBackground(new Color(192, 192, 192));
		btnAcessar.setForeground(new Color(0, 0, 255));
		btnAcessar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAcessar.setBounds(117, 179, 96, 31);
		contentPane.add(btnAcessar);
	}	
}