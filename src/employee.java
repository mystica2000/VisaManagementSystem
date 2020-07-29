import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
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
	public employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(112, 128, 144));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDelete = new JButton("View");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployee ve=new ViewEmployee();
				ve.setVisible(true);
				dispose();
			}
			
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(317, 242, 203, 36);
		panel.add(btnDelete);
		
		JButton btnCreate_2 = new JButton("Create");
		btnCreate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEmployee ce=new CreateEmployee();
				ce.setVisible(true);
				dispose();
			}
		});
		btnCreate_2.setForeground(Color.WHITE);
		btnCreate_2.setBackground(new Color(100, 149, 237));
		btnCreate_2.setBounds(317, 138, 203, 36);
		panel.add(btnCreate_2);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee de=new DeleteEmployee();
				de.setVisible(true);
				dispose();
			}
		});
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setBackground(new Color(100, 149, 237));
		btnDelete_1.setBounds(317, 363, 203, 36);
		panel.add(btnDelete_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBounds(306, 28, 224, 36);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		panel_2.setBounds(12, 28, 79, 67);
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin a=new admin();
				a.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		panel_2.add(lblNewLabel);
	}
}
