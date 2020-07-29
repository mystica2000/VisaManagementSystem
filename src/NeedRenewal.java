import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Choice;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NeedRenewal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NeedRenewal frame = new NeedRenewal();
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
	public NeedRenewal() {
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(342, 28, 177, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Need Renewal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(362, 161, 117, 22);
		contentPane.add(choice);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel.setBounds(10, 7, 45, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Emp ID");
		lblNewLabel_2.setBounds(366, 106, 55, 16);
		contentPane.add(lblNewLabel_2);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin a=new admin();
				a.setVisible(true);
				dispose();
			}
			
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(131, 334, 634, 45);
		contentPane.add(lblNewLabel_3);
		
		
		JButton btnDeleteExecutive_1_2 = new JButton("Change");
		btnDeleteExecutive_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst2=con.prepareStatement("select * from applicant where eid=?");
					  pst2.setString(1, choice.getSelectedItem());
					 ResultSet rs2=pst2.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs2));
			
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst2=con.prepareStatement("select date_visa,instay from applicant where eid=?");
					  pst2.setString(1, choice.getSelectedItem());
					 ResultSet rs1=pst2.executeQuery();
					 Date date_visa=null;
					 String instay=null;
					 while(rs1.next())
					 {
				 	  date_visa = rs1.getDate("date_visa");
				 	  instay=rs1.getString("instay");
					 }

					if(date_visa==null)
					{
						JOptionPane.showMessageDialog(new JFrame(),"Nothing to renew");
					}
					else
					{

						lblNewLabel_3.setText("The Visa Issued on "+date_visa+" And the Validity is about "+instay);
						int result=JOptionPane.showConfirmDialog(new JFrame(),"Sure want to change","Delete Employee",
								JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						
						if(result==JOptionPane.YES_OPTION)
						{

							try {
							PreparedStatement pst=con.prepareStatement("update applicant set renew=? where eid=?");
							pst.setString(1, "yes");
							pst.setString(2, choice.getSelectedItem());
							int res=pst.executeUpdate();
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(new JFrame(),"Nothing to renew");
								System.out.println(e1);
							}
						}

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

								
			}
		});
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(390, 
				421, 89, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 238, 823, 45);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
			  PreparedStatement pst=con.prepareStatement("select eid from applicant where renew=? and ishave=?");
			  pst.setString(1, "yes");
			  pst.setString(2, "no");
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
				
	}
}
