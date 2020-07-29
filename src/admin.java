import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setResizable(false);
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
	public admin() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You are logged in as Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 30, 234, 22);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(308, 64, 400, 275);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create Executive");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To Create the Applicants for the Visa ");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createExecutive ce=new createExecutive();
				ce.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(70, 64, 203, 36);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteExecutive_1 = new JButton("Delete Executive");
		btnDeleteExecutive_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteExecutive de=new DeleteExecutive();
				de.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To Delete the Applicants for the Visa");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		btnDeleteExecutive_1.setForeground(Color.WHITE);
		btnDeleteExecutive_1.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1.setBounds(70, 127, 203, 36);
		contentPane.add(btnDeleteExecutive_1);
		
		JButton btnDeleteExecutive_1_1 = new JButton("Visa Executive");
		btnDeleteExecutive_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To Initiate Applicant for Visa");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		btnDeleteExecutive_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaHolders vh=new VisaHolders();
				vh.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1_1.setForeground(Color.WHITE);
		btnDeleteExecutive_1_1.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_1.setBounds(70, 200, 203, 36);
		contentPane.add(btnDeleteExecutive_1_1);
		
		JButton btnDeleteExecutive_1_2 = new JButton("Employee");
		btnDeleteExecutive_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To Create,Delete,View,Update Employee Details");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		btnDeleteExecutive_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee emp=new employee();
				emp.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(70, 273, 203, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		JButton btnDeleteExecutive_1_3 = new JButton("Visa Process Status");
		btnDeleteExecutive_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaProcess vp=new VisaProcess();
				vp.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To track the Visa Process of the Applicant");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
				
			}
		});
		btnDeleteExecutive_1_3.setForeground(Color.WHITE);
		btnDeleteExecutive_1_3.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_3.setBounds(70, 337, 203, 36);
		contentPane.add(btnDeleteExecutive_1_3);
		
		JButton btnDeleteExecutive_1_1_1 = new JButton("Need Renewal");
		btnDeleteExecutive_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeedRenewal is=new NeedRenewal();
				is.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setText("To Set Schedule for Visa Interview \n Applicant");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setText("");
			}
		});
		btnDeleteExecutive_1_1_1.setForeground(Color.WHITE);
		btnDeleteExecutive_1_1_1.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_1_1.setBounds(70, 409, 203, 36);
		contentPane.add(btnDeleteExecutive_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Visa Processing System");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(383, 351, 299, 72);
		contentPane.add(lblNewLabel_2);
		
		JButton btnDeleteExecutive_1_1_1_1 = new JButton("First time apply");
		btnDeleteExecutive_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstTime ft=new FirstTime();
				ft.setVisible(true);
				dispose();
			}
		});
		btnDeleteExecutive_1_1_1_1.setForeground(Color.WHITE);
		btnDeleteExecutive_1_1_1_1.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_1_1_1.setBounds(70, 485, 203, 36);
		contentPane.add(btnDeleteExecutive_1_1_1_1);
		
		
	}
}
