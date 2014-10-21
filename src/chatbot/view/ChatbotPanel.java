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
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(5, 20);
		chatPane = new JScrollPane(chatArea);
		
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
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 15, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -93, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -117, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 75, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 30, SpringLayout.WEST, this);
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				JOptionPane.showMessageDialog(firstButton, "You clicked me and it tickles!! tehe");
			}
		});
	}

}
