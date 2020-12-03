package alexlee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUILogin implements ActionListener {

	private static JPanel panel;
	private static JFrame frame;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel successLabel;

	public static void main(String[] args) {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new GUILogin());
		panel.add(button);

		successLabel = new JLabel();
		successLabel.setBounds(10, 100, 300, 25);
		panel.add(successLabel);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = passwordText.getText();
//		System.out.println(user + " ," + password);
		if (user.equals("Lore") && password.equals("3329600452")) {
			successLabel.setText("Login successful!");
		} else {
			successLabel.setText("Oops... Try again!");
		}

	}

}
