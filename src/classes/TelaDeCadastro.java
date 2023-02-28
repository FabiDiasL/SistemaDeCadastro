package classes;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JPanel panel;
	private JTextField tfAbrir;
	private JTable tbDados;

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
		setBounds(100, 100, 450, 534);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAcoes = new JMenu("Ações");
		menuBar.add(mnAcoes);

		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o/a usuário/senha que deseja salvar!");
				} else {
					Acoes acoes = new Acoes(tfUsuario.getText(), tfSenha.getText());
					acoes.salvar();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnAcoes.add(mntmSalvar);

		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID!");
				} else {

					Acoes acoes = new Acoes(Integer.parseInt(tfId.getText()), tfUsuario.getText(), tfSenha.getText());
					acoes.atualizar();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		mntmAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnAcoes.add(mntmAtualizar);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID!");
				} else {
					Acoes acoes = new Acoes(Integer.parseInt(tfId.getText()));
					acoes.excluir();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mnAcoes.add(mntmExcluir);
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
		panel.setBounds(10, 195, 416, 79);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o/a usuário/senha que deseja salvar!");
				} else {

					Acoes acoes = new Acoes(tfUsuario.getText(), tfSenha.getText());
					acoes.salvar();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		btnSalvar.setBounds(29, 20, 85, 21);
		panel.add(btnSalvar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID!");
				} else {

					Acoes acoes = new Acoes(Integer.parseInt(tfId.getText()), tfUsuario.getText(), tfSenha.getText());
					acoes.atualizar();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		btnAtualizar.setBounds(168, 20, 85, 21);
		panel.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID!");
				} else {

					Acoes acoes = new Acoes(Integer.parseInt(tfId.getText()));
					acoes.excluir();

					tfId.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
				}
			}
		});
		btnExcluir.setBounds(308, 20, 85, 21);
		panel.add(btnExcluir);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Abrir Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 284, 416, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		tfAbrir = new JTextField();
		tfAbrir.setBounds(144, 31, 96, 19);
		panel_1.add(tfAbrir);
		tfAbrir.setColumns(10);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfAbrir.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o ID do usuário que deseja encontrar!");
				} else {
					try {
						Connection conn = Conexao.criaConexaoComMySQL();

						String sql = "select * from `scsenhas` where id = ?;";

						PreparedStatement pstm = conn.prepareStatement(sql);
						pstm.setString(1, tfAbrir.getText());

						ResultSet rset = pstm.executeQuery();

						while (rset.next()) {
							tfId.setText(rset.getString("id"));
							tfUsuario.setText(rset.getString("usuario"));
							tfSenha.setText(rset.getString("senha"));
						}

						rset.close();
						pstm.close();
						conn.close();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
			}
		});
		btnAbrir.setBounds(29, 30, 85, 21);
		panel_1.add(btnAbrir);

		JButton btnListarDados = new JButton("Listar Dados");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Conexao.criaConexaoComMySQL();

					String sql = "select * from `scsenhas`;";

					PreparedStatement pstm = conn.prepareStatement(sql);

					ResultSet rset = pstm.executeQuery();

					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);

					while (rset.next()) {
						modelo.addRow(new Object[] { rset.getString("id"), rset.getString("usuario"),
								rset.getString("senha") });
					}

					rset.close();
					pstm.close();
					conn.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListarDados.setBounds(310, 30, 96, 21);
		panel_1.add(btnListarDados);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 373, 416, 79);
		contentPane.add(scrollPane);

		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Usu\u00E1rio", "Senha" }));
		scrollPane.setViewportView(tbDados);
	}
}