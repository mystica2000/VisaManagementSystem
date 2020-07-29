import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UpdateEmployeee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployeee frame = new UpdateEmployeee(null,null);
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
	
	class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
	
	
	public UpdateEmployeee(String user, String pass) {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 721);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setForeground(new Color(255, 255, 255));
		datePicker.getJFormattedTextField().setBackground(new Color(112, 128, 144));
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\javafx2\\src\\application\\lofi\\img\\back.png"));
		lblNewLabel.setBounds(12, 28, 45, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(284, 28, 225, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Creation");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(112, 128, 144));
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBounds(145, 95, 575, 494);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" ID");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(141, 25, 95, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(112, 128, 144));
		textField.setBounds(286, 22, 194, 20);
		panel_1.add(textField);
		textField.setText(user);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(141, 85, 95, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DOB");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setBounds(141, 154, 95, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1.setBounds(141, 221, 95, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(112, 128, 144));
		textField_1.setColumns(10);
		textField_1.setBounds(286, 82, 194, 20);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		panel_2.setBounds(286, 137, 194, 36);
		panel_2.add(datePicker);
		panel_1.add(panel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(286, 220, 277, 51);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Email ID");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(141, 374, 55, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(112, 128, 144));
		textField_2.setBounds(286, 372, 194, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(141, 443, 55, 16);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(112, 128, 144));
		textField_3.setColumns(10);
		textField_3.setBounds(286, 441, 194, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setBounds(141, 303, 95, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		Validation v=new Validation();
		
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(112, 128, 144));
		textField_4.setBounds(286, 300, 194, 20);
		textField_4.setText(pass);
		panel_1.add(textField_4);
		
		
		
		
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				
				try {
					
					
				String eid=textField.getText();
				String ename=textField_1.getText();
				String email=textField_2.getText();
				String phone=textField_3.getText();
				String passgen=v.generatePassword();
				String  address=textArea.getText();
				Date selectedDate = (Date) datePicker.getModel().getValue();
				int flag=0;
				if(v.dob(selectedDate)==false)
				{
					JOptionPane.showMessageDialog(frame,"Enter dob carefully");
				}
				else
				{
					flag++;
				}
				if(v.validateEmail(email)==false)
				{
					JOptionPane.showMessageDialog(frame,"Enter email carefully");
				}
				else
				{
					flag++;
				}
				if(v.validatePhone(phone)==false)
				{
					JOptionPane.showMessageDialog(frame,"Enter phone carefully");
				}
				else
				{
					flag++;
				}
				if(flag==3) {
				System.out.println("You made it");
				addEmployee(eid,ename,passgen,address,email,phone,selectedDate);
				}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame,"Something Left Out");
				}
			}
		});
		btnSaveChanges.setForeground(Color.WHITE);
		btnSaveChanges.setBackground(new Color(100, 149, 237));
		btnSaveChanges.setBounds(181, 634, 203, 36);
		contentPane.add(btnSaveChanges);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setBounds(505, 634, 203, 36);
		contentPane.add(btnCancel);
	}
	public static void addEmployee(String eid,String name,String pass,String address,String email,String phone,Date entry)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/lofi","root","root");  
			String sql="insert into employee"+"(eid,name,pass,address,email,phone,dob)"+ "values (?,?,?,?,?,?,?)";
			PreparedStatement mystmt = null;
			mystmt=con.prepareStatement(sql);
			mystmt.setString(1,eid);
			mystmt.setString(2,name);
			mystmt.setString(3, pass);
			mystmt.setString(4,address);
			mystmt.setString(5,email);
			mystmt.setString(6, phone);
			java.sql.Date sqlDate = new java.sql.Date(entry.getTime());
			mystmt.setDate(7,(java.sql.Date) sqlDate);
			mystmt.execute();
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		}  
}

