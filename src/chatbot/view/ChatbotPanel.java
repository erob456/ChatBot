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

/**
 * This is the class for the GUI element of the chatbot.
 * @author erob7388
 * 
 */
public class ChatbotPanel extends JPanel
{
	/**
	 * Declaration and construction of the elements in the Panel.
	 */
	private ChatbotAppController baseController;

	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;

	/**
	 * The base controller declares the variables.
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		JLabel lblChatbotLabel = new JLabel("Chat Bot");
		firstButton = new JButton("Click my button.");
		firstTextField = new JTextField(25);
		firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(5, 20);
		chatPane = new JScrollPane(chatArea);
		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	/**
	 * The setupPane sets the characteristics of the chatPane section.
	 */
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		chatArea.setBackground(Color.DARK_GRAY);
		chatArea.setForeground(Color.ORANGE);
		chatArea.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

	}

	/**
	 * The setupPanel creates the base layout for the window that appears when run.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(500, 500);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);

	}

	/**
	 * The setupLayout declares the placement of each of the items on the window.
	 */
	private void setupLayout()
	{

		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 21, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 153, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 95, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 176, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 145, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 123, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 30, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 73, SpringLayout.WEST, this);

	}

	/**
	 * These listeners check for when the button is clicked then sets the chatArea text. 
	 */
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				chatArea.setText(chatArea.getText());
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
				firstTextField.requestFocus();

			}
		});
	}

	/**
	 * Sets text from the input into the output section.
	 * @param userInput
	 */
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);

	}
}
