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
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstTime extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstTime frame = new FirstTime();
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
	public FirstTime() {
		setForeground(new Color(112, 128, 144));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(345, 24, 177, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Update VISA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Emp ID");
		lblNewLabel_2.setBounds(298, 122, 55, 16);
		contentPane.add(lblNewLabel_2);
		
		Choice choice = new Choice();
		choice.setBounds(388, 118, 117, 22);
		contentPane.add(choice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 192, 811, 73);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnDeleteExecutive_1_2 = new JButton("Change");
		btnDeleteExecutive_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst2=con.prepareStatement("select * from applicant where eid=?");
					  pst2.setString(1, choice.getSelectedItem());
					 ResultSet rs2=pst2.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs2));
			
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
				

						int result=JOptionPane.showConfirmDialog(new JFrame(),"Sure want to change","Update Employee",
								JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						
						if(result==JOptionPane.YES_OPTION)
						{

							try {
									PreparedStatement pst=con.prepareStatement("update applicant set date_visa=? where eid=?");
									java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
									pst.setTimestamp(1, date);
									pst.setString(2, choice.getSelectedItem());
									int res=pst.executeUpdate();
								}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(new JFrame(),"Nothing to Update");
								System.out.println(e1);
							}
						}

					}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(407, 363, 89, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin a=new admin();
				a.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel_3.setBounds(10, 12, 45, 55);
		contentPane.add(lblNewLabel_3);
		
		btnDeleteExecutive_1_2.setForeground(Color.WHITE);
		btnDeleteExecutive_1_2.setBackground(new Color(100, 149, 237));
		btnDeleteExecutive_1_2.setBounds(407, 363, 89, 36);
		contentPane.add(btnDeleteExecutive_1_2);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
			  PreparedStatement pst=con.prepareStatement("select eid from applicant where renew=? and ishave=?");
			  pst.setString(1, "no");
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
