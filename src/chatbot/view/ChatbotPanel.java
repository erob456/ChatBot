package chatbot.view;

import java.awt.Color;
import javax.swing.JPanel;
import chatbot.controller.ChatbotAppController;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;

	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JScrollPane textArea;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		firstButton = new JButton("Click my button. It will make you click ;D");
		firstTextField = new JTextField(25);
		firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
		baseLayout = new SpringLayout();
		chatPane = new JScrollPane();
		textArea = new JScrollPane();
		
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		
		
	}

	private void setupLayout()
	{
		JLabel lblChatbotLabel = new JLabel("Chat Bot");
		baseLayout.putConstraint(SpringLayout.SOUTH, lblChatbotLabel, 0, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, lblChatbotLabel, -179, SpringLayout.EAST, this);
		lblChatbotLabel.setBackground(Color.DARK_GRAY);
		lblChatbotLabel.setForeground(Color.ORANGE);
		lblChatbotLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblChatbotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblChatbotLabel);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -117, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 34, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 122, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -27, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 90, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 40, SpringLayout.WEST, this);
		
		chatArea = new JTextArea(5, 20);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 1, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -33, SpringLayout.EAST, this);
		add(chatArea);
		
		JTextArea textArea = new JTextArea(5, 20);
		baseLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 2, SpringLayout.EAST, chatPane);
		add(textArea);
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText(firstTextField.getText());
				
			}
		});
	}
}
