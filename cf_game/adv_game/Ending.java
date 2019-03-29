/**********************************************************
* Program Name   : Ending
* Author         : Cameron Fukes
* Date           : April 28, 2018
* Course/Section : CSC-264
*
* Program Description: The frame that is displayed if the
*    users energy hits 0 for when they loose.
*
* Methods:
* Ending        - Creates the frame to tell the user they lost.
* setStoryLabel - Creates and adds the Story label to the background.
* setNewg       - Creates and adds the new game button to the background.
* setQuit       - Creates and adds the quit button to the background.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ending extends JFrame
{
	//class constants

	//class variable
	private JPanel contentPane; //The Pane that holds all the components
	private Story story;        //The Frame that is displayed for new game
	private JButton quit;       //The quit game option button
	private Dimension size;     //The prefered size of the containers
	private JLabel background;  //The background of the frame
	private JButton newg;       //The new game option button
	private JLabel storyLabel;  //The label displaying the Story

	/**********************************************************
	* Program Name   : Ending
	* Author         : Cameron Fukes
	* Date           : April 28, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates the frame to tell the user
	*    they lost and offers a new game or quit.
	*
	* BEGIN Ending
	*    Reset the energy value
	*    Reset the number of coins
	*    Reset the weapon level
	*    Reset the zombie1 hp
	*    Reset the zombie2 hp
	*    Reset the zombie3 hp
	*    Reset the zombie4 hp
	*    Add window listener for close
	*       Exit program
	*    END windowlistener
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Set up the new game button
	*    Set up the quit button
	*    Set up the story label
	*    Add background to contentpane
	* END Ending
	**********************************************************/
	public Ending()
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Reset the energy value
		BarVal.reset();

		//Reset the number of coins
		Coin.reset();

		//Reset the weapon level
		WepVal.reset();

		//Reset the zombie1 hp
		Zombie1.reset();

		//Reset the zombie2 hp
		Zombie2.reset();

		//Reset the zombie3 hp
		Zombie3.reset();

		//Reset the zombie4 hp
		Zombie4.reset();

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Exit program
				System.exit(0);
			}

		});//END windowlistener

		//Set frame title
		setTitle("Ending Story");

		//Set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Set bounds of the frame
		setBounds(100, 100, 450, 400);

		//Set background image
		background = new JLabel(new ImageIcon("paper.jpg"));

		//Create JPanel content pane
		contentPane = new JPanel();

		//Set ContentPane
		setContentPane(contentPane);

		//Set content pane to flow layout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		//Set up the new game button
		setNewg();

		//Set up the quit button
		setQuit();

		//Set up the story label
		setStoryLabel();

		//Add background to contentpane
		contentPane.add(background);

	}//END Ending

	/**********************************************************
	* Program Name   : setStoryLabel
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the Story label
	*    to the background.
	*
	* BEGIN setStoryLabel
	*    Create Label for the frame
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	* END setStoryLabel
	***********************************************************/
	private void setStoryLabel()
	{
		//local constants

		//local variable

		/************************************/

		//Create Label for the frame
		storyLabel = new JLabel("<html>" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"You Died<br>" +
			"Would you like to play again?</html>");

		//Set foreground color to the label
		storyLabel.setForeground(Color.BLACK);

		//Set font of that label
		storyLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));

		//Get the prefered size of the container
		size = storyLabel.getPreferredSize();

		//Set bound of the label
		storyLabel.setBounds((450 - size.width) / 2, 20, size.width, size.height);

		//Add label to the background
		background.add(storyLabel);

	}//END setStoryLabel

	/**********************************************************
	* Program Name   : setNewg
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the new game
	*    button to the background.
	*
	* BEGIN setNewg
	*    Create object of JButton for the new game option
	*    Removing the border
	*    Add actionListener to new game
	*       Initialize story
	*       Set Story frame visible true
	*       Set default close operation
	*       Set frame visible false
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setNewg
	***********************************************************/
	private void setNewg()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the new game option
		newg = new JButton(new ImageIcon("newg.jpg"));

		//Removing the border
		newg.setBorderPainted(false);

		//Add actionListener to new game
		newg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Initialize story
				story = new Story();

				//Set Story frame visible true
				story.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set frame visible false
				setVisible(false);
			}

		});//END actionlistener

		//Set font of the Button
		newg.setFont(new Font("Times New Roman", Font.BOLD, 20));

		//Get the prefered size of the container
		size = newg.getPreferredSize();

		//Set bounds of the Button
		newg.setBounds((480 - size.width - 30) / 2, 120, size.width - 30, size.height - 18);

		//Add Button into background
		background.add(newg);

	}//END setNewg

	/**********************************************************
	* Program Name   : setQuit
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the quit button
	*    to the background.
	*
	* BEGIN setQuit
	*    Create object of JButton for the quit option
	*    Removing the border
	*    Add actionListener to quit
	*       Exit program
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setQuit
	***********************************************************/
	private void setQuit()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the quit option
		quit = new JButton(new ImageIcon("quit.jpg"));

		//Removing the border
		quit.setBorderPainted(false);

		//Add actionListener to quit
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Exit program
				System.exit(0);
			}

		});//END actionlistener

		//Set font of the Button
		quit.setFont(new Font("Times New Roman", Font.BOLD, 20));

		//Get the prefered size of the container
		size = quit.getPreferredSize();

		//Set bounds of the Button
		quit.setBounds((460 - size.width - 7) / 2, 220, size.width - 30, size.height - 10);

		//Add Button into background
		background.add(quit);

	}//END setQuit

}//END Ending