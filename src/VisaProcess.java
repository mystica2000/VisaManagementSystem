import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaProcess extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaProcess frame = new VisaProcess();
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
	public VisaProcess() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(340, 32, 177, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Process Bending");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(655, 32, 130, 20);
		contentPane.add(choice);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Redirection r=new Redirection();
				r.admin();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel_3.setBounds(10, 32, 45, 55);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 859, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDeleteExecutive_1_2 = new JButton("Search");
		btnDeleteExecutive_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.getSelectedItem().contentEquals("Renewal"))
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");  
						 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
						  PreparedStatement pst=con.prepareStatement("select * from applicant where renew=? and ishave=?");
						  pst.setString(1,"yes");
						  pst.setString(2,"no");
						 ResultSet rs=pst.executeQuery();
						 table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if(choice.getSelectedItem().contentEquals("New"))
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");  
						 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
						  PreparedStatement pst=con.prepareStatement("select * from applicant where ishave=? and renew=?");
						  pst.setString(1,"no");
						  pst.setString(2,"no");
						 ResultSet rs=pst.executeQuery();
						 table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(676, 80, 100, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		choice.add("Renewal");
		choice.add("New");
			}
}
