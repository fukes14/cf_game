/**********************************************************
* Program Name   : Church
* Author         : Cameron Fukes
* Date           : April 20, 2018
* Course/Section : CSC-264
*
* Program Description: The frame that displays the
*    Church the user can search.
*
* Methods:
* Church   - Creates frame to let the user search for supplies.
* setBar   - Creates and adds the progress bar to the background.
* setMenu  - Creates and adds the menu button to the background.
* setDoor  - Creates and adds the door button to the background.
* setC1    - Creates and adds the c1 button to the background.
* setC2    - Creates and adds the c2 button to the background.
* setC3    - Creates and adds the c3 button to the background.
* update   - Updates the progress bar.
* passThis - Creates the different frames that will be displayed.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Church extends JFrame
{
	//class constants
	private final int WATER = 15; //The value for finding water
	private final int FOOD  = 20; //The value for finding food

	//class variable
	private MainMenuC mainMenu;  //The frame start to return to
	private Street2 street;      //The street is the leaves the kitchen
	private Ending ending;       //The ending frame if lost
	private JLabel kit;          //The label that holds the kitchen
	private JLabel background;   //The background of the frame
	private JButton door;        //The door button
	private JButton menu;        //The menu button
	private JButton c1, c2, c3;  //The Different cupboards
	private JLabel topLabel;     //The label that displays information
	private JLabel bottomLabel;  //The label that displays story
	private JProgressBar bar;    //The bar that shows the users energy
	private Dimension size;      //The prefered size of the containers
	private Random rand;         //Creates the chance of finding supplies
	private int chance;          //The chance of finding supplies

	/**********************************************************
	* Program Name   : Church
	* Author         : Cameron Fukes
	* Date           : April 20, 2018
	* Course/Section : CSC-264
	*
	* Program Description: The frame that displays the
	*    Church the user can search.
	*
	* BEGIN Church
	*    Setting reference
	*    Create random number generator
	*    Calling method to start frames
	*    Set frame title
	*    Set default close operation
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Add background to contentpane
	*    Get the prefered size of the container
	*    Set bounds of the frame
	*    Initialize title label
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add Button into contentPane
	*    Initialize topLabel
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add Button into contentPane
	*    Creating the label for the kitchen
	*    Get the prefered size of the container
	*    Set bounds of the frame
	*    Adding the kitchen to the background
	*    Set up the progress bar
	*    Set up the menu button
	*    Set up the door button
	*    Set up the c1 button
	*    Set up the c2 button
	*    Set up the c3 button
	*    Add window listener for close
	*       Exit program
	*    END windowlistener
	* END Church
	**********************************************************/
	public Church(Street2 temp)
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Setting reference
		street = temp;

		//Create random number generator
		rand = new Random();

		//Calling method to start frames
		passThis();

		//Set frame title
		setTitle("Church");

		//Set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Set background image
		background = new JLabel(new ImageIcon("paper.jpg"));

		//Create JPanel content pane
		contentPane = new JPanel();

		//Set ContentPane
		setContentPane(contentPane);

		//Set content pane to flow layout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		//Add background to contentpane
		contentPane.add(background);

		//Get the prefered size of the container
		size = background.getPreferredSize();

		//Set bounds of the frame
		setBounds(100, 100, size.width, size.height - 400);

		//Initialize title label
		bottomLabel = new JLabel();

		//Set foreground color to the label
		bottomLabel.setForeground(Color.BLACK);

		//Set font of that label
		bottomLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = bottomLabel.getPreferredSize();

		//Set bound of the label
		bottomLabel.setBounds(50, 700, size.width, size.height);

		//Add Button into contentPane
		background.add(bottomLabel);

		//Initialize topLabel
		topLabel = new JLabel();

		//Set foreground color to the label
		topLabel.setForeground(Color.BLACK);

		//Set font of that label
		topLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = topLabel.getPreferredSize();

		//Set bound of the label
		topLabel.setBounds(50, 50, size.width, size.height);

		//Add Button into contentPane
		background.add(topLabel);

		//Creating the label for the Church
		kit = new JLabel(new ImageIcon("kitchen.jpg"));

		//Get the prefered size of the container
		size = kit.getPreferredSize();

		//Set bounds of the frame
		kit.setBounds(0, 150, size.width, size.height);

		//Adding the kitchen to the background
		background.add(kit);

		//Set up the progress bar
		setBar();

		//Set up the menu button
		setMenu();

		//Set up the door button
		setDoor();

		//Set up the c1 button
		setC1();

		//Set up the c2 button
		setC2();

		//Set up the c3 button
		setC3();

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Exit program
				System.exit(0);
			}

		});//END windowlistener

	}//END Church

	/**********************************************************
	* Program Name   : setBar
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the progress bar
	*    to the background.
	*
	* BEGIN setBar
	*    Creating the progress bar
	*    Setting the progress bar value
	*    Displaying the percent energy left
	*    Get the prefered size of the container
	*    Set bounds of the bar
	*    Setting the background color
	*    Setting the foreground color
	*    Setting the font
	*    Adding the bar to the background
	* END setBar
	***********************************************************/
	private void setBar()
	{
		//local constants

		//local variable

		/************************************/

		//Creating the progress bar
		bar = new JProgressBar(0);

		//Setting the progress bar value
		bar.setValue(BarVal.getVal());

		//Displaying the percent energy left
		bar.setStringPainted(true);

		//Get the prefered size of the container
		size = bar.getPreferredSize();

		//Set bounds of the bar
		bar.setBounds(550, 700, size.width + 50, size.height + 50);

		//Setting the background color
		bar.setBackground(Color.BLACK);

		//Setting the foreground color
		bar.setForeground(Color.RED);

		//Setting the font
		bar.setFont(new Font("Times New Roman", Font.BOLD, 50));

		//Adding the bar to the background
		background.add(bar);

	}//END setBar

	/**********************************************************
	* Program Name   : setMenu
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the menu button
	*    to the background.
	*
	* BEGIN setMenu
	*    Create object of JButton for the menu option
	*    Removing the border
	*    Add actionListener to menu
	*       Set main menu visiable true
	*       Update main menu
	*       Set default close operation
	*       Set visiable false
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setMenu
	***********************************************************/
	private void setMenu()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the menu option
		menu = new JButton("Main Menu");

		//Removing the border
		menu.setBorderPainted(false);

		//Add actionListener to menu
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Set main menu visiable true
				mainMenu.setVisible(true);

				//Update main menu
				mainMenu.update();

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set visiable false
				setVisible(false);
			}

		});//END actionlistener

		//Set font of the Button
		menu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

		//Get the prefered size of the container
		size = menu.getPreferredSize();

		//Set bounds of the Button
		menu.setBounds(770, 690, size.width, size.height + 50);

		//Add Button into background
		background.add(menu);

	}//END setMenu

	/**********************************************************
	* Program Name   : setDoor
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the door button
	*    to the background.
	*
	* BEGIN setDoor
	*    Create object of JButton and set label on it
	*    Removing the border
	*    Add actionListener to door
	*       Updating the bar class
	*       Reduce energy bar
	*       IF energy is 0
	*          Set ending frame visible true
	*       ELSE IF the energy is not 0
	*          Set street frame visible true
	*          Clear top label
	*          Update the frame
	*       END if
	*       Set default close operation
	*       Set Story frame visible true
	*    END actionlistener
	*    Add mouse listener to door for hovering over button
	*       Mouse has entered
	*          Display the amount of energy costed
	*          Get the prefered size of the container
	*          Set bound of the label
	*       Mouse has exited
	*          Remove cost of searching
	*    END mouse listener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into kit
	* END setDoor
	***********************************************************/
	private void setDoor()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		door = new JButton(new ImageIcon("door.jpg"));

		//Removing the border
		door.setBorderPainted(false);

		//Add actionListener to door
		door.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 10);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);
				}
				//ELSE IF the energy is not 0
				else
				{
					//Set street frame visible true
					street.setVisible(true);

					//Clear top label
					topLabel.setText("");

					//Update the frame
					street.update();

				}//END if

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set Story frame visible true
				setVisible(false);
			}

		});//END actionlistener

		//Add  mouse listener to door for hovering over button
		door.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Costs 10 energy to leave this house");

				//Get the prefered size of the container
				size = bottomLabel.getPreferredSize();

				//Set bound of the label
				bottomLabel.setBounds(50, 700, size.width, size.height);
			}

			//Mouse has exited
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				//Remove cost of searching
				bottomLabel.setText("");
			}

		});//END mouse listener

		//Set font of the Button
		door.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = door.getPreferredSize();

		//Set bounds of the Button
		door.setBounds(720, 160, size.width - 40, size.height - 15);

		//Add Button into kit
		kit.add(door);

	}//END setDoor

	/**********************************************************
	* Program Name   : setC1
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the c1 button
	*    to the background.
	*
	* BEGIN setC1
	*    Create object of JButton and set label on it
	*    Removing the border
	*    Add actionListener to c1
	*       Updating the bar class
	*       Reduce energy bar
	*       Generate chance of getting item
	*       IF chance is 0
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 1
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 2
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the coin class
	*       ELSE IF chance is 3
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the weapon class
	*       ELSE IF chance is higher
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*       END if
	*       IF energy is 0
	*          Set ending frame visible true
	*          Set default close operation
	*         Set Church frame visible false
	*       END if
	*       Disable button
	*    END actionlistener
	*    Add mouse listener to c1 for hovering over button
	*       Mouse has entered
	*          IF button is enabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          ELSE IF disabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          END if
	*       Mouse has exited
	*          Remove cost of searching
	*    END mouse listener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into kit
	* END setc1
	***********************************************************/
	private void setC1()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		c1 = new JButton(new ImageIcon("chest.jpg"));

		//Removing the border
		c1.setBorderPainted(false);

		//Add actionListener to c1
		c1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 5);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//Generate chance of getting item
				chance = rand.nextInt(5);

				//IF chance is 0
				if(chance == 0)
				{
					//Display the result of the search
					topLabel.setText("You found a water bottle!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + WATER);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 1
				else if (chance == 1)
				{
					//Display the result of the search
					topLabel.setText("You found food!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + FOOD);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 2
				else if (chance == 2)
				{
					//Display the result of the search
					topLabel.setText("<html>You found a coin!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the coin class
					Coin.incVal();
				}
				//ELSE IF chance is 3
				else if (chance == 3)
				{
					//Display the result of the search
					topLabel.setText("<html>Your weapon leveled up!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the weapon class
					WepVal.incVal();
				}
				//ELSE IF chance is higher
				else
				{
					//Display the result of the search
					topLabel.setText("Nothing found here");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

				}//END if

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set Church frame visible false
					setVisible(false);

				}//END if

				//Disable button
				c1.setEnabled(false);
			}

		});//END actionlistener

		//Add  mouse listener to c1 for hovering over button
		c1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
				//IF button is enabled
				if(c1.isEnabled())
				{
					//Display the amount of energy costed
					bottomLabel.setText("Costs 5 energy to search this cubbord");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);
				}
				//ELSE IF disabled
				else
				{
					//Display the amount of energy costed
					bottomLabel.setText("Empty");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);

		    	}//END if
		    }

			//Mouse has exited
		    public void mouseExited(java.awt.event.MouseEvent evt)
		    {
				//Remove cost of searching
				bottomLabel.setText("");
		    }

		});//END mouse listener

		//Set font of the Button
		c1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = c1.getPreferredSize();

		//Set bounds of the Button
		c1.setBounds(300, 305, size.width - 40, size.height - 15);

		//Add Button into kit
		kit.add(c1);

	}//END setC1

	/**********************************************************
	* Program Name   : setC2
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the c2 button
	*    to the background.
	*
	* BEGIN setC2
	*    Create object of JButton and set label on it
	*    Removing the border
	*    Add actionListener to c2
	*       Updating the bar class
	*       Reduce energy bar
	*       Generate chance of getting item
	*       IF chance is 0
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 1
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 2
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the coin class
	*       ELSE IF chance is 3
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the weapon class
	*       ELSE IF chance is higher
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*       END if
	*       IF energy is 0
	*          Set ending frame visible true
	*          Set default close operation
	*          Set Church frame visible false
	*       END if
	*       Disable button
	*    END actionlistener
	*    Add mouse listener to c2 for hovering over button
	*       Mouse has entered
	*          IF button is enabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          ELSE IF disabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          END if
	*       Mouse has exited
	*          Remove cost of searching
	*    END mouse listener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into kit
	* END setC2
	***********************************************************/
	private void setC2()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		c2 = new JButton(new ImageIcon("chest.jpg"));

		//Removing the border
		c2.setBorderPainted(false);

		//Add actionListener to c2
		c2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 5);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//Generate chance of getting item
				chance = rand.nextInt(5);

				//IF chance is 0
				if(chance == 0)
				{
					//Display the result of the search
					topLabel.setText("You found a water bottle!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + WATER);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 1
				else if (chance == 1)
				{
					//Display the result of the search
					topLabel.setText("You found food!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + FOOD);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 2
				else if (chance == 2)
				{
					//Display the result of the search
					topLabel.setText("<html>You found a coin!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the coin class
					Coin.incVal();
				}
				//ELSE IF chance is 3
				else if (chance == 3)
				{
					//Display the result of the search
					topLabel.setText("<html>Your weapon leveled up!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the weapon class
					WepVal.incVal();
				}
				//ELSE IF chance is higher
				else
				{
					//Display the result of the search
					topLabel.setText("Nothing found here");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

				}//END if

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set Church frame visible false
					setVisible(false);

				}//END if

				//Disable button
				c2.setEnabled(false);
			}

		});//END actionlistener

		//Add  mouse listener to c2 for hovering over button
		c2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
				//IF button is enabled
				if(c2.isEnabled())
				{
					//Display the amount of energy costed
					bottomLabel.setText("Costs 5 energy to search this cubbord");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);
				}
				//ELSE IF disabled
				else
				{
					//Display the amount of energy costed
					bottomLabel.setText("Empty");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);

				}//END if
		    }

			//Mouse has exited
		    public void mouseExited(java.awt.event.MouseEvent evt)
		    {
				//Remove cost of searching
				bottomLabel.setText("");
		    }

		});//END mouse listener

		//Set font of the Button
		c2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = c2.getPreferredSize();

		//Set bounds of the Button
		c2.setBounds(205, 305, size.width - 40, size.height - 15);

		//Add Button into kit
		kit.add(c2);

	}//END setC2

	/**********************************************************
	* Program Name   : setC3
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the c3 button
	*    to the background.
	*
	* BEGIN setC3
	*    Create object of JButton and set label on it
	*    Removing the border
	*    Add actionListener to c3
	*       Updating the bar class
	*       Reduce energy bar
	*       Generate chance of getting item
	*       IF chance is 0
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 1
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the bar class
	*          Reduce energy bar
	*       ELSE IF chance is 2
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the coin class
	*       ELSE IF chance is 3
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Updating the weapon class
	*       ELSE IF chance is higher
	*          Display the result of the search
	*          Get the prefered size of the container
	*          Set bound of the label
	*       END if
	*       IF energy is 0
	*          Set ending frame visible true
	*          Set default close operation
	*          Set Church frame visible false
	*       END if
	*       Disable button
	*    END actionlistener
	*    Add mouse listener to c3 for hovering over button
	*       Mouse has entered
	*          IF button is enabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          ELSE IF disabled
	*             Display the amount of energy costed
	*             Get the prefered size of the container
	*             Set bound of the label
	*          END if
	*       Mouse has exited
	*           Remove cost of searching
	*    END mouse listener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into kit
	* END setC3
	***********************************************************/
	private void setC3()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		c3 = new JButton(new ImageIcon("chest.jpg"));

		//Removing the border
		c3.setBorderPainted(false);

		//Add actionListener to c3
		c3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 5);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//Generate chance of getting item
				chance = rand.nextInt(5);

				//IF chance is 0
				if(chance == 0)
				{
					//Display the result of the search
					topLabel.setText("You found a water bottle!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + WATER);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 1
				else if (chance == 1)
				{
					//Display the result of the search
					topLabel.setText("You found food!");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + FOOD);

					//Reduce energy bar
					bar.setValue(BarVal.getVal());
				}
				//ELSE IF chance is 2
				else if (chance == 2)
				{
					//Display the result of the search
					topLabel.setText("<html>You found a coin!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the coin class
					Coin.incVal();
				}
				//ELSE IF chance is 3
				else if (chance == 3)
				{
					//Display the result of the search
					topLabel.setText("<html>Your weapon leveled up!" +
						"<br>Go to menu to see your inventory.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the weapon class
					WepVal.incVal();
				}
				//ELSE IF chance is higher
				else
				{
					//Display the result of the search
					topLabel.setText("Nothing found here");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

				}//END if

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set Church frame visible false
					setVisible(false);

				}//END if

				//Disable button
				c3.setEnabled(false);
			}

		});//END actionlistener

		//Add  mouse listener to c3 for hovering over button
		c3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//IF button is enabled
				if(c3.isEnabled())
				{
					//Display the amount of energy costed
					bottomLabel.setText("Costs 5 energy to search this cubbord");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);
				}
				//ELSE IF disabled
				else
				{
					//Display the amount of energy costed
					bottomLabel.setText("Empty");

					//Get the prefered size of the container
					size = bottomLabel.getPreferredSize();

					//Set bound of the label
					bottomLabel.setBounds(50, 700, size.width, size.height);

				}//END if
			}

			//Mouse has exited
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				//Remove cost of searching
				bottomLabel.setText("");
			}

		});//END mouse listener

		//Set font of the Button
		c3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = c3.getPreferredSize();

		//Set bounds of the Button
		c3.setBounds(110, 307, size.width - 40, size.height - 15);

		//Add Button into kit
		kit.add(c3);

	}//END setC3

	/**********************************************************
	* Program Name   : update
	* Author         : Cameron Fukes
	* Date           : April 28, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Updates the progress bar.
	*
	* BEGIN update
	*    Update bar
	* END update
	***********************************************************/
	public void update()
	{
		//Update bar
		bar.setValue(BarVal.getVal());

	}//END update

	/**********************************************************
	* Program Name   : passThis
	* Author         : Cameron Fukes
	* Date           : April 23, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates the different frames that
	*    will be displayed.
	*
	* BEGIN passThis
	*    Initialize mainMenu
	*    Initialize ending
	* END passThis
	***********************************************************/
	public void passThis()
	{
		//Initialize mainMenu
		mainMenu = new MainMenuC(this);

		//Initialize ending
		ending = new Ending();

	}//END passThis

}//END Church