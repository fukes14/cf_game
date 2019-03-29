/**********************************************************
* Program Name   : MainMenuA
* Author         : Cameron Fukes
* Date           : April 20, 2018
* Course/Section : CSC-264
*
* Program Description: The frame that is displayed when
*    the menu in Church is selected.
*
* Methods:
* MainMenuA - The frame that is displayed when Church menu is selected.
* setStats  - Creates and adds the stats label to the background.
* setResume - Creates and adds the resume button to the background.
* setNewg   - Creates and adds the new game button to the background.
* setQuit   - Creates and adds the quit button to the background.
* update    - Updates the frames data.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainMenuA extends JFrame
{
	//class constants
	final int WIDTH = 800; //The width of the frame

	//class variable
	private QuitMenu frameQuit; //The quit game frame
	private Story story;        //The Story frame
	private Appt k3;            //The frame to resume to
	private JLabel background;  //The background image
	private Dimension size;     //The prefered size of the containers
	private JButton newg;       //The new game option
	private JButton quit;       //The quit game option
	private JButton resume;     //The resume game option
	private JLabel title;       //The title label
	private JLabel stats;       //Displays the inventory

	/**********************************************************
	* Program Name   : MainMenuA
	* Author         : Cameron Fukes
	* Date           : April 20, 2018
	* Course/Section : CSC-264
	*
	* Program Description: The frame that is displayed when
	*    the menu in Church is selected.
	*
	* BEGIN MainMenuA
	*    Setting reference value
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Set up the stats label
	*    Set up the resume button
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
	* END MainMenuA
	**********************************************************/
	public MainMenuA(Appt temp)
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Setting reference value
		k3 = temp;

		//Set frame title
		setTitle("Main Menu");

		//Set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Set bounds of the frame
		setBounds(100, 100, WIDTH, 400);

		//Set background image
		background = new JLabel(new ImageIcon("paper.jpg"));

		//Create JPanel content pane
		contentPane = new JPanel();

		//Set ContentPane
		setContentPane(contentPane);

		//Set content pane to flow layout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		//Set up the stats label
		setStats();

		//Set up the resume button
		setResume();

		//Set up the new game button
		setNewg();

		//Set up the quit button
		setQuit();

		//Initialize title label
		title = new JLabel("Scavangers");

		//Set foreground color to the label
		title.setForeground(Color.BLUE);

		//Set font of that label
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = title.getPreferredSize();

		//Set bound of the label
		title.setBounds((WIDTH - size.width) / 2, 40, size.width, size.height - 10);

		//Add label to the background
		background.add(title);

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Set Church frame visible true
				k3.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set frame visible false
				setVisible(false);
			}

		});//END windowlistener

		//Add background to contentpane
		contentPane.add(background);

	}//END MainMenuA

	/**********************************************************
	* Program Name   : setStats
	* Author         : Cameron Fukes
	* Date           : May 1, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the stats
	*    label to the background.
	*
	* BEGIN setStats
	*    Initialize stats label
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	* END setStats
	***********************************************************/
	private void setStats()
	{
		//local constants

		//local variable

		/************************************/

		//Initialize stats label
		stats = new JLabel("<html>Coins       : " + Coin.getVal() +
			"<br>Weapon level: " + WepVal.getVal() +
			"</html>");

		//Set foreground color to the label
		stats.setForeground(Color.BLACK);

		//Set font of that label
		stats.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = stats.getPreferredSize();

		//Set bound of the label
		stats.setBounds(580, 150, size.width, size.height);

		//Add label to the background
		background.add(stats);

	}//END setStats

	/**********************************************************
	* Program Name   : setResume
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the resume
	*    button to the background.
	*
	* BEGIN setResume
	*    Create object of JButton for the resume option
	*    Removing the border
	*    Add actionListener to resume
	*       Set Church frame visible true
	*       Set default close operation
	*       Set frame visible false
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setResume
	***********************************************************/
	private void setResume()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the resume option
		resume = new JButton(new ImageIcon("resume.jpg"));

		//Removing the border
		resume.setBorderPainted(false);

		//Add actionListener to resume
		resume.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Set Church frame visible true
				k3.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set frame visible false
				setVisible(false);
			}

		});//END actionlistener

		//Set font of the Button
		resume.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

		//Get the prefered size of the container
		size = resume.getPreferredSize();

		//Set bounds of the Button
		resume.setBounds((WIDTH - size.width) / 2, 20, size.width - 40, size.height - 20);
		//Add Button into background
		background.add(resume);

	}//END setResume

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
		newg.setBounds((WIDTH - size.width) / 2, 140, size.width - 40, size.height - 18);

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
		quit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = quit.getPreferredSize();

		//Set bounds of the Button
		quit.setBounds((WIDTH - size.width) / 2, 230, size.width - 40, size.height - 10);

		//Add Button into background
		background.add(quit);

	}//END setQuit

	/**********************************************************
	* Program Name   : update
	* Author         : Cameron Fukes
	* Date           : May 1, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Updates the frames data.
	*
	* BEGIN update
	*    Update data
	* END update
	***********************************************************/
	public void update()
	{
		//Update data
		stats.setText("<html>Coins       : " + Coin.getVal() +
			"<br>Weapon level: " + WepVal.getVal() +
			"</html>");

	}//END update

}//END MainMenuA