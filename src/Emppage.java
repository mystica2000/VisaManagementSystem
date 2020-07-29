import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Emppage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emppage frame = new Emppage(null,null);
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
	 * @param pass 
	 * @param user 
	 */
	public Emppage(String user, String pass) {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRequestForRenewal = new JButton("Request For Renewal");
		btnRequestForRenewal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					PreparedStatement pst=con.prepareStatement("update applicant set renew=? where eid=? and renew=?");
							pst.setString(1, "yes");
							pst.setString(2, user);
							pst.setString(3, "no");
							int res=pst.executeUpdate();
							if(res==0)
							{
							JOptionPane.showMessageDialog(new JFrame(),"Requested for Renewal");
							}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(),"Cant renew ");
							}
				} catch (Exception e1) {
						JOptionPane.showMessageDialog(new JFrame(),"Nothing to renew");
						System.out.println(e1);
				}
			}
		});
		btnRequestForRenewal.setForeground(Color.WHITE);
		btnRequestForRenewal.setBackground(new Color(100, 149, 237));
		btnRequestForRenewal.setBounds(167, 68, 203, 36);
		contentPane.add(btnRequestForRenewal);
		
		JLabel lblYouAreLogged = new JLabel("You are logged in as "+user);
		lblYouAreLogged.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYouAreLogged.setBounds(10, 11, 234, 22);
		contentPane.add(lblYouAreLogged);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployeee ue=new UpdateEmployeee(user,pass);
				ue.setVisible(true);
				dispose();
			}
		});
		btnUpdateDetails.setForeground(Color.WHITE);
		btnUpdateDetails.setBackground(new Color(100, 149, 237));
		btnUpdateDetails.setBounds(167, 142, 203, 36);
		contentPane.add(btnUpdateDetails);
	}
}
