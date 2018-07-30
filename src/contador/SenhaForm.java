package contador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.SystemColor;

public class SenhaForm {
	private JFrame frmSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhaForm window = new SenhaForm();
					window.frmSenha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SenhaForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	int senha = 0;
	private void initialize() {
//		/*variáveis*/
//		String arquivo = "salvo.txt";
//		Path arqv;
//		
//		/*manipulação de arquivo*/
//		JFileChooser fileDialog = new JFileChooser();	//instancia o seletor de arquivo
//		int resulta = fileDialog.showOpenDialog(null);	//abre o seletor para o usuario
//		
//		/*avaliação do resultado do seletor de arquivo*/
//		if(resulta == JFileChooser.APPROVE_OPTION){		//se o arquivo foi selecionado
//			arquivo = fileDialog.getSelectedFile().getPath();	//recebe a path do arquivo selecionado
//			JOptionPane.showMessageDialog(null, "Foi selecionado: "+arquivo);	//mostra na tela, só pela didática
//		}
//		else if(resulta == JFileChooser.CANCEL_OPTION){	//se o usuário cancelou a seleção
//			String msg = "Você não selecionou nenhum arquivo, digite a última senha atendida para continuar";
//			senha = Integer.parseInt(JOptionPane.showInputDialog(msg)); //solicita o int para o usuario
//		}
//		else if(resulta == JFileChooser.ERROR_OPTION){	//se ocorreu um erro com o troço todo
//			String msg = "Ocorreu um erro com o arquivo. Por favor digite a ultima senha que foi atendida para continuar";
//			senha = Integer.parseInt(JOptionPane.showInputDialog(msg)); //solicita o int para o usuario
//		}
		
		try {
			String dialog = JOptionPane.showInputDialog("Digite a última senha atendida para continuar \n(Deixe em branco para iniciar a partir de zero)");
			if(dialog==null || dialog.equals("")){
				senha = 0;
			}
			else{
				senha = Integer.parseInt(dialog);
			}
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			senha = 0;
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			senha = 0;
		}
		
		/*segue o baile*/
		frmSenha = new JFrame();
		frmSenha.getContentPane().setBackground(Color.BLACK);
		frmSenha.setBackground(SystemColor.control);
		frmSenha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSenha.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String msg = "<html>Tem certeza que deseja encerrar o programa? <br /><b>ATENÇÃO:</b> <br />Lembre-se de utilizar a senha <b>"+senha+"</b> <br />na próxima vez que iniciar o programa</html>";
				JLabel lblMsg = new JLabel(msg);
				lblMsg.setFont(new Font("sans", Font.PLAIN, 14));
				JOptionPane.showConfirmDialog(frmSenha, lblMsg, "Deseja Sair?", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		frmSenha.setTitle("Senha");
		frmSenha.setBounds(100, 100, 606, 340);
		
		String start = "000";
		if(senha!=0) { start = String.format("%03d", senha); }
		frmSenha.getContentPane().setLayout(null);
		
		final JLabel lblsenha = new JLabel(start);
		lblsenha.setForeground(Color.RED);
		lblsenha.setBackground(SystemColor.control);
		lblsenha.setBounds(0, 0, 606, 197);
		lblsenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblsenha.setFont(new Font("Dialog", Font.BOLD, 99));
		frmSenha.getContentPane().add(lblsenha);
		
		JButton btnProximo = new JButton("proximo");
		btnProximo.setBackground(Color.GRAY);
		btnProximo.setBounds(320, 209, 272, 90);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senha++;
				String strSenha = String.format("%03d", senha);
				lblsenha.setText(strSenha);
			}
		});
		frmSenha.getContentPane().add(btnProximo);
	}
}
