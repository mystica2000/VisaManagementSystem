import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 398, 464);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\login.jpg").getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT)));
		panel.add(label);
		JFrame j=new JFrame();
		
		JButton button = new JButton("SignIn");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.print("WHAT");
				String user=textField.getText();
				String pass=passwordField.getText();
				if(user.equals("admin2047") && pass.equals("qwerty"))
				{
					System.out.print("Sucessful Login");
				    JOptionPane.showMessageDialog(j,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);     
					admin a=new admin();
					a.setVisible(true);
				}
				else
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
						System.out.println("Connection SucessFull");
    
						PreparedStatement statement = con.prepareStatement("select * from accountuser where userid = ? and pass=? ;");    
						statement.setString(1, user);
						statement.setString(2, pass);
						ResultSet rs = statement.executeQuery();
						
						while(rs.next())
						{
							Emppage ep=new Emppage(user,pass);
							ep.setVisible(true);
							dispose();
						}
						con.close();  
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(494, 364, 157, 36);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Visa Processing System");
		lblNewLabel.setFont(new Font("Eras Medium ITC", lblNewLabel.getFont().getStyle(), 19));
		lblNewLabel.setBounds(451, 31, 264, 56);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(465, 163, 212, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(465, 130, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setBounds(465, 232, 74, 14);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(465, 279, 212, 36);
		contentPane.add(passwordField);
	}
}
