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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DeleteExecutive extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteExecutive frame = new DeleteExecutive();
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
	public DeleteExecutive() {
		setForeground(Color.WHITE);
		setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Visa Processing System");
		lblNewLabel.setBounds(116, 21, 463, 55);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(223, 115, 177, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Applicant");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Applicant ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(77, 191, 122, 43);
		contentPane.add(lblNewLabel_1_1);
		
		table = new JTable();
		table.setBounds(77, 355, 561, -64);
		contentPane.add(table);
		

		Choice choice = new Choice();
		choice.setBounds(223, 201, 152, 22);
		contentPane.add(choice);
		
		
		String str;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
			  PreparedStatement pst=con.prepareStatement("select eid from applicant");
			 ResultSet rs=pst.executeQuery();
			 while(rs.next())
			 {
				 choice.add(rs.getString(1));
			 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst=con.prepareStatement("select * from applicant where eid=?");
					  pst.setString(1, choice.getSelectedItem());
					 ResultSet rs=pst.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
				int result=JOptionPane.showConfirmDialog(new JFrame(),"Sure want to delete","Delete Employee",
						JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
				
				if(result==JOptionPane.YES_OPTION)
				{
					  PreparedStatement pst1=con.prepareStatement("delete from applicant where eid=?");
					  pst1.setString(1, choice.getSelectedItem());
					  int rs1=pst1.executeUpdate();
					  table_1.removeAll();
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(77, 408, 203, 36);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setBounds(393, 408, 203, 36);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Redirection r=new Redirection();
				r.admin();
				dispose();
		}});
		
		contentPane.add(btnCancel);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 284, 676, 83);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
}
