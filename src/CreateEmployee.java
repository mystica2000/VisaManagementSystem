import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee frame = new CreateEmployee();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateEmployee() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(299, 42, 225, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Create Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Redirection rd=new Redirection();
				rd.employee();
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel.setBounds(10, 21, 45, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("EmployeeID");
		lblNewLabel_2.setBounds(245, 120, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(112, 128, 144));
		textField.setBounds(363, 114, 165, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pass");
		lblNewLabel_2_1_1.setBounds(245, 170, 63, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(112, 128, 144));
		textField_2.setBounds(363, 164, 165, 26);
		contentPane.add(textField_2);
		textField_2.setText(new Validation().generatePassword());
		String user=textField.getText();
		String pass=textField_2.getText();
		JButton btnDeleteExecutive_1_2 = new JButton("Save");
		
		btnDeleteExecutive_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validation v=new Validation();
				if(v.validateEmail(textField_1.getText()))
				{
				textField_2.setText(v.generatePassword());
				String user=textField.getText();
				String pass=textField_2.getText();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					System.out.println("Connection SucessFull");

					PreparedStatement statement = con.prepareStatement("insert into accountuser (userid,pass)values(?,?)");    
					statement.setString(1, user);
					statement.setString(2,pass);
					int rs = statement.executeUpdate();
					
					con.close();
					JOptionPane.showMessageDialog(new JFrame(),"Inserted Successfully","Alert",JOptionPane.INFORMATION_MESSAGE);  
					
					EmailSend se=new EmailSend(user,textField_1.getText(),pass);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Already Present User ID","Alert",JOptionPane.ERROR_MESSAGE);  
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(),"Check the Email","Alert",JOptionPane.ERROR_MESSAGE);  
				}
			}
		});
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(122, 438, 203, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		JButton btnDeleteExecutive_1_2_1 = new JButton("cancel");
		btnDeleteExecutive_1_2_1.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2_1.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2_1.setBounds(497, 438, 203, 36);
		contentPane.add(btnDeleteExecutive_1_2_1);
		
		btnDeleteExecutive_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Redirection rd=new Redirection();
				rd.employee();
			}
						});

		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 263, 846, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
			  PreparedStatement pst1=con1.prepareStatement("select * from accountuser");
			 ResultSet rs1=pst1.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs1));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1_1.setBounds(245, 231, 63, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(112, 128, 144));
		textField_1.setBounds(363, 225, 165, 26);
		contentPane.add(textField_1);
	}
}
