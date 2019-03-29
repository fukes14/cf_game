/**********************************************************
* Program Name   : Story
* Author         : Cameron Fukes
* Date           : April 10, 2018
* Course/Section : CSC-264
*
* Program Description: Displays the story and directions of
*    the game.
*
* Methods:
* Story    - Displays the story and directions of the game.
* Rules    - The rules of the game
* setBegin - Creates and adds the begin button to the background.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Story extends JFrame
{
	//local constants

	//local variable
	private Street1 street;    //The frame that begins the story
	private JLabel background; //The background of the frame
	private JButton begin;     //The begin game option button
	private JLabel story;      //The label displaying the story
	private JLabel rule;       //The label displaying the rules
	private Dimension size;    //The prefered size of the containers

	/**********************************************************
	* Program Name   : Story
	* Author         : Cameron Fukes
	* Date           : April 10, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Displays the story and directions of
	*    the game.
	*
	* BEGIN Story
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Set up the begin button
	*    Set up the rules
	*    Create Label for the frame
	*    Set foreground color of the label
	*    Set font of the label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	*    Add window listener for close
	*       Exit program
	*    END windowlistener
	*    Add background to contentpane
	* END Story
	**********************************************************/
	public Story()
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Set frame title
		setTitle("Starting Story");

		//Set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Set bounds of the frame
		setBounds(100, 100, 900, 850);

		//Set background image
		background = new JLabel(new ImageIcon("paper.jpg"));

		//Create JPanel content pane
		contentPane = new JPanel();

		//Set ContentPane
		setContentPane(contentPane);

		//Set content pane to flow layout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		//Set up the begin button
		setBegin();

		//Set up the rules
		Rules();

		//Create Label for the frame
		story = new JLabel("<html>You wake up to find you are in The Walking " +
			"Dead.<br>You're only way to survive is to find food " +
			"until you reach the Sancturay.<br>To fight the zombies you must " +
			"increase the level of your weapon.<br>Finally, use coins to increase " +
			"your chances at getting into the sanctuary.<br></html>");

		//Set foreground color of the label
		story.setForeground(Color.BLACK);

		//Set font of the label
		story.setFont(new Font("Times New Roman", Font.BOLD, 26));

		//Get the prefered size of the container
		size = story.getPreferredSize();

		//Set bound of the label
		story.setBounds((900 - size.width) / 2, 20, size.width, size.height);

		//Add label to the background
		background.add(story);

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Exit program
				System.exit(0);
			}

		});//END windowlistener

		//Add background to contentpane
		contentPane.add(background);

	}//END Story

	/**********************************************************
	* Program Name   : Rules
	* Author         : Cameron Fukes
	* Date           : April 10, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Displays the Rules of the game.
	*
	* BEGIN Rules
	*    Create Label for the frame
	*    Set foreground color of the label
	*    Set font of the label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	* END Rules
	**********************************************************/
	public void Rules()
	{
		//local constants

		//local variable

		/******************************************/

		//Create Label for the frame
		rule = new JLabel("<html>*The goal is to make it to the forth street<br>" +
								"  and get let into the Sanctuary.<br>" +
							    "*You loose if your energy bar hits 0 or if a zombie <br>" +
							    "  reaches your characture on the left side of the screen.<br>" +
							    "*To prevent a zombie for reaching you, you can search buildings <br>" +
							    "  to increase your weapon level.<br>" +
							    "*Click on the zombie until its gone only if your level is 1 or more.<br>" +
							    "*In order to search houses and cupboards you use up energy<br>" +
							    "  but there is a chance to find food or water to replenish your<br>" +
							    "  energy inside cupboards.<br>" +
							    "*You can only search a cupboard once.<br>" +
							    "*The other way to get energy is by killing zombies.<br>" +
							    "*To exit a home justc click the door.<br>" +
							    "*To find the Sanctuary you must reach the end of the road by going<br>" +
							    "  to the next street.<br>" +
							    "*Have fun and good luck</html>");

		//Set foreground color of the label
		rule.setForeground(Color.WHITE);

		//Set font of the label
		rule.setFont(new Font("Times New Roman", Font.BOLD, 28));

		//Get the prefered size of the container
		size = rule.getPreferredSize();

		//Set bound of the label
		rule.setBounds((900 - size.width) / 2, 150, size.width, size.height);

		//Add label to the background
		background.add(rule);

	}//END Rules

	/**********************************************************
	* Program Name   : setBegin
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the begin
	*    button to the background.
	*
	* BEGIN setBegin
	*    Create object of JButton for the begin option
	*    Add actionListener to begin
	*       Initialize street
	*       Set street visiable true
	*       Set default close operation
	*       Set visiable false
	*       Update the data
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setBegin
	***********************************************************/
	private void setBegin()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the begin option
		begin = new JButton("Press to Begin");

		//Removing the border
		begin.setBorderPainted(false);

		//Add actionListener to begin
		begin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Initialize street
				street = new Street1();

				//Set street visiable true
				street.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set visiable false
				setVisible(false);

				//Update the data
				street.update();
			}

		});//END actionlistener

		//Set font of the Button
		begin.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

		//Get the prefered size of the container
		size = begin.getPreferredSize();

		//Set bounds of the Button
		begin.setBounds((900 - size.width) / 2, 700, size.width, size.height);

		//Add Button into contentPane
		background.add(begin);

	}//END setBegin

}//END QuitMenu