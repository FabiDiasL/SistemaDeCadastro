package classesDeConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JLabel lbSenha;
	private JPasswordField pfSenha;

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
		setBounds(100, 100, 327, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUsuario = new JLabel("USUÁRIO");
		lbUsuario.setForeground(new Color(0, 0, 255));
		lbUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbUsuario.setBounds(10, 55, 85, 37);
		contentPane.add(lbUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfUsuario.setBounds(97, 55, 150, 31);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lbSenha = new JLabel("SENHA");
		lbSenha.setForeground(Color.BLUE);
		lbSenha.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbSenha.setBounds(10, 115, 85, 37);
		contentPane.add(lbSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(97, 115, 150, 31);
		contentPane.add(pfSenha);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnAcessar.setForeground(new Color(0, 0, 255));
		btnAcessar.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		btnAcessar.setBounds(97, 186, 150, 31);
		contentPane.add(btnAcessar);
	}
}
