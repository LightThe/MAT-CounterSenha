package contador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class SenhaForm {

	private JFrame frmSenha;
	
	//variaveis
	int senha = 0;
	String arquivo = "salvo.txt";
	

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
	private void initialize() {
		frmSenha = new JFrame();
		frmSenha.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		frmSenha.setTitle("Senha");
		frmSenha.setBounds(100, 100, 606, 340);
		frmSenha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSenha.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		final JLabel lblsenha = new JLabel("lbl_senha");
		lblsenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblsenha.setFont(new Font("Dialog", Font.BOLD, 40));
		frmSenha.getContentPane().add(lblsenha);
		
		JButton btnProximo = new JButton("proximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senha++;
				String strSenha = Integer.toString(senha);
				lblsenha.setText(strSenha);
			}
		});
		frmSenha.getContentPane().add(btnProximo);
	}
}
