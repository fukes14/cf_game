/**********************************************************
* Program Name   : Start
* Author         : Cameron Fukes
* Date           : April 10, 2018
* Course/Section : CSC-264
*
* Program Description: Starts the program and is the first
*    frame the user sees.
*
* Methods:
* main     - Initializes the first frame of the program
* Start    - The frame that is displayed when the program starts.
* setNewg  - Creates and adds the new game button to the background.
* setQuit  - Creates and adds the quit button to the background.
* passThis - Creates the different frames that will be displayed.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame
{
	//local constants

	//local variable
	private QuitMenuStart quitB; //The quit game frame
	private Story story;         //The Story frame
	private JLabel background;   //The background image
	private Dimension size;      //The prefered size of the containers
	private JButton newg;        //The new game option
	private JButton quit;        //The quit game option
	private JLabel title;        //The title label

	/**********************************************************
	* Program Name   : main
	* Author         : Cameron Fukes
	* Date           : April 10, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Initializes the first frame Of the
	*    program.
	*
	* BEGIN main
	*    Initialize frame
	*    Set frame visible true
	* END main
	**********************************************************/
	public static void main(String[] args)
	{
		//local constants

		//local variable
		Start frame; //The first frame

		/******************************************/

		//Initialize frame
		frame = new Start();

		//Set frame visible true
		frame.setVisible(true);

	}//END main

	/**********************************************************
	* Program Name   : Start
	* Author         : Cameron Fukes
	* Date           : April 10, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Instantiates instance data and runs
	*    the frame that is displayed when the program starts.
	*
	* BEGIN Start
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Set up the new game button
	*    Set up the quit button
	*    Initialize title label
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	*    Add window listener for close
	*       Close aplication
	*    END windowlistener
	*    Add background to contentpane
	* END Start
	**********************************************************/
	public Start()
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Calling method to start frames
		passThis();

		//Set frame title
		setTitle("Scavanger");

		//Set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Set bounds of the frame
		setBounds(100, 100, 450, 420);

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

		//Initialize title label
		title = new JLabel("Scavangers");

		//Set foreground color to the label
		title.setForeground(Color.BLACK);

		//Set font of that label
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = title.getPreferredSize();

		//Set bound of the label
		title.setBounds((450 - size.width) / 2, 50, size.width, size.height);

		//Add label to the background
		background.add(title);

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Close aplication
				System.exit(0);
			}

		});//END windowlistener

		//Add background to contentpane
		contentPane.add(background);

	}//END Start

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
		newg.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = newg.getPreferredSize();

		//Set bounds of the Button
		newg.setBounds((450 - size.width + 30) / 2, 125, size.width - 30, size.height - 18);

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
	*       Set quit visiable true
	*       Set default close operation
	*       Set visiable false
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
				//Set quit visiable true
				quitB.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set visiable false
				setVisible(false);
			}

		});//END actionlistener

		//Set font of the Button
		quit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = quit.getPreferredSize();

		//Set bounds of the Button
		quit.setBounds((450 - size.width + 30) / 2, 220, size.width - 30, size.height - 10);

		//Add Button into background
		background.add(quit);

	}//END setQuit

	/**********************************************************
	* Program Name   : passThis
	* Author         : Cameron Fukes
	* Date           : April 23, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates the different frames that
	*     will be displayed.
	*
	* BEGIN passThis
	*    Initialize story
	*    Initialize quit
	* END passThis
	***********************************************************/
	public void passThis()
	{
		//Initialize story
		story = new Story();

		//Initialize quit
		quitB = new QuitMenuStart(this);

	}//END passThis

}//END Start