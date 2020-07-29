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
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;

public class createExecutive extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createExecutive frame = new createExecutive();
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
	public createExecutive() {
		setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Visa Processing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(112, 128, 144));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Applicant ID");
		lblNewLabel_1.setBounds(84, 74, 169, 43);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Applicant Stay");
		lblNewLabel_1_1.setBounds(84, 143, 164, 43);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_1);
		
		Choice choice = new Choice();
		choice.setBounds(275, 87, 195, 22);
		choice.setBackground(new Color(112, 128, 144));
		panel_1.add(choice);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
		  PreparedStatement pst=con.prepareStatement("select * from accountuser where userid<>'admin'");
		 ResultSet rs=pst.executeQuery();
		 while(rs.next())
		 {
			 choice.add(rs.getString(1));
		 }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Choice choice_1 = new Choice();
		choice_1.setBackground(new Color(112, 128, 144));
		choice_1.setBounds(275, 152, 195, 22);
		choice_1.add("USA");
		choice_1.add("England");
		choice_1.add("Canada");
		
		panel_1.add(choice_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Already Traveled");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(84, 198, 164, 43);
		panel_1.add(lblNewLabel_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(112, 128, 144));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(275, 210, 54, 24);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setBackground(new Color(112, 128, 144));
		rdbtnNo.setBounds(349, 210, 54, 24);
		panel_1.add(rdbtnNo);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Intended Stay");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(84, 254, 164, 43);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(112, 128, 144));
		textField.setBounds(290, 268, 41, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		Choice choice_1_1 = new Choice();
		choice_1_1.setBackground(new Color(112, 128, 144));
		choice_1_1.setBounds(337, 268, 93, 22);
		choice_1_1.add("Year(S)");
		choice_1_1.add("Month(S)");
		choice_1_1.add("Day(S)");
		panel_1.add(choice_1_1);
		
		Choice choice_1_2 = new Choice();
		choice_1_2.setBackground(new Color(112, 128, 144));
		choice_1_2.setBounds(275, 320, 195, 22);
		choice_1_2.add("H1B");
		choice_1_2.add("Resident");
		choice_1_2.add("Tourist");
		panel_1.add(choice_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Type of VISA");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(84, 308, 164, 43);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(139, 364, 203, 36);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 String eid=choice.getSelectedItem();
			 String place=choice_1.getSelectedItem();
			 String rad;
			 if(rdbtnNewRadioButton.isSelected())
			 {
				 rad="yes";
			 }
			 else
			 {
				 rad="no";
			 }
			 System.out.println(rad);
			 String stay=textField.getText()+" "+choice_1_1.getSelectedItem();
			 String ishave="no";
			 String renew="no";
			 String interview="no";
			 String type=choice_1_2.getSelectedItem();
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst1=con1.prepareStatement("insert into applicant(eid,stay,travelbefore,instay,visatype,ishave,renew,interview) values(?,?,?,?,?,?,?,?)");
					  pst1.setString(1, eid);
					  pst1.setString(2, place);
					  pst1.setString(3, rad);
					  pst1.setString(4, stay);
					  pst1.setString(5, type);
					  pst1.setString(6, ishave);
					  pst1.setString(7, renew);
					  pst1.setString(8, interview);
					  int rs1=pst1.executeUpdate();
						JOptionPane.showMessageDialog(new JFrame(),"Done Inserted","Alert",JOptionPane.INFORMATION_MESSAGE);  
						
				}
				catch(Exception eq)
				{
					JOptionPane.showMessageDialog(new JFrame(),"Something wrong","Alert",JOptionPane.ERROR_MESSAGE);  
					System.out.println(eq);
				}
			
			
			}
		});
		btnSaveChanges.setForeground(Color.WHITE);
		btnSaveChanges.setBackground(new Color(100, 149, 237));
		panel_1.add(btnSaveChanges);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(436, 364, 203, 36);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(100, 149, 237));
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Redirection r=new Redirection();
				r.admin();
				dispose();
			}
			
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(275, 11, 177, 34);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Create Applicant");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_2.add(lblNewLabel_1_2);
		
			}
}
