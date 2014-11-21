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

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		firstButton = new JButton("Click my button. It will make you click ;D");
		firstTextField = new JTextField(25);
		firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -544, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -88, SpringLayout.EAST, this);
		chatPane = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, 0, SpringLayout.SOUTH, chatPane);
		chatArea = new JTextArea(5, 20);
		
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}

	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(500, 700);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		
		
	}

	private void setupLayout()
	{
		
		chatArea = new JTextArea(5, 20);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 25, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 15, SpringLayout.WEST, firstButton);
		chatArea.setEditable(false);
		add(chatArea);
		JLabel lblChatbotLabel = new JLabel("Chat Bot");
		baseLayout.putConstraint(SpringLayout.NORTH, lblChatbotLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, lblChatbotLabel, 155, SpringLayout.WEST, this);
		lblChatbotLabel.setBackground(Color.DARK_GRAY);
		lblChatbotLabel.setForeground(Color.ORANGE);
		lblChatbotLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblChatbotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblChatbotLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 90, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 40, SpringLayout.WEST, this);
		
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setWrapStyleWord(true);
		baseLayout.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, chatPane);
		add(textArea);
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
				firstTextField.requestFocus();
							
			}
		});
	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
		
	}
}
