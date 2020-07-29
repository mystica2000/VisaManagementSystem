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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(112, 128, 144));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Visa Processing System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setBounds(190, 22, 463, 55);
		contentPane_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(313, 115, 177, 34);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Employee ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(190, 191, 146, 36);
		contentPane_1.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(112, 128, 144));
		textField.setBounds(355, 191, 201, 35);
		contentPane_1.add(textField);
		
		table = new JTable();
		table.setBounds(77, 355, 561, -64);
		contentPane_1.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(227, 369, 329, 46);
		contentPane_1.add(lblNewLabel_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lofi","root","root");
					  PreparedStatement pst=con.prepareStatement("select * from employee where eid=?");
					  pst.setString(1, textField.getText());
					 ResultSet rs=pst.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
				int result=JOptionPane.showConfirmDialog(new JFrame(),"Sure want to delete","Delete Employee",
						JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
				
				if(result==JOptionPane.YES_OPTION)
				{
					  PreparedStatement pst1=con.prepareStatement("delete from employee where eid=?");
					  pst1.setString(1, textField.getText());
					  int rs1=pst1.executeUpdate();
					  table_1.removeAll();
					  lblNewLabel_2.setText("Deleted SuccessFully");
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(130, 442, 203, 36);
		contentPane_1.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Redirection rd=new Redirection();
				rd.employee();
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setBounds(465, 442, 203, 36);
		contentPane_1.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 282, 849, 61);
		contentPane_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBackground(new Color(112, 128, 144));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Redirection rd=new Redirection();
				rd.employee();
				dispose();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel_3.setBounds(30, 33, 45, 55);
		contentPane_1.add(lblNewLabel_3);
		
		
	}
}
