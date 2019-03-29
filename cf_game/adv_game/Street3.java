/**********************************************************
* Program Name   : Street3
* Author         : Cameron Fukes
* Date           : April 20, 2018
* Course/Section : CSC-264
*
* Program Description: The frame that holds the 2
*    places to explore.
*
* Methods:
* Street3       - Instantiates instance data and runs the frame.
* setC1         - Creates and adds the c1 button to the background.
* setC3         - Creates and adds the c3 button to the background.
* setNextStreet - Creates and adds the next street button to the background.
* setMenu       - Creates and adds the menu button to the background.
* update        - Updates the frames components.
* passThis      - Creates the different frames that will be displayed.
* attack        - Creates and adds the attack button to the background.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Street3 extends JFrame
{
	//class constants

	//class variable
	private MainMenuS3 mainMenu; //The menu the user chooses options from
	private Street4 street;      //The next street the user can explore
	private JProgressBar bar;    //The bar that shows the users energy
	private Dimension size;      //The prefered size of the containers
	private Ending ending;       //The ending frame if lost
	private Kitchen5 k4;         //The 5 kitchen
	private Appt appt;           //The appartment
	private JLabel background;   //The background of the frame
	private JLabel stre;         //The street background
	private JButton nextStreet;  //The option to do to the next street
	private JButton menu;        //The menu button
	private JButton c1;          //The different houses button
	private JButton c3;          //The different houses button
	private JLabel topLabel;     //The label displaying the story
	private JLabel bottomLabel;  //The label displaying the information
	private JButton zom;         //An attacking zombie
	private Timer timerStart;    //Timer for starting attack
	private Timer timerZom;      //Timer that moves the zombie
	private int moves;           //Spaces to move
	private Random rand;         //Creates the time until attack
	private int time;            //Time until attack
	private Street2 streetP;     //Frame to return to past street
	private JButton prevStreet;  //The option to do to the prev street

	/**********************************************************
	* Program Name   : Street3
	* Author         : Cameron Fukes
	* Date           : April 20, 2018
	* Course/Section : CSC-264
	*
	* Program Description: The frame that holds 2
	*    places to explore.
	*
	* BEGIN Street3
	*    Setting return value
	*    Calling method to start frames
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Add background to contentpane
	*    Get the prefered size of the container
	*    Set bounds of the frame
	*    Initialize bottom label
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label into background
	*    Initialize topLabel
	*    Set foreground color to the label
	*    Set font of that label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label into background
	*    Creating the Street image
	*    Get the prefered size of the container
	*    Set bounds of the frame
	*    Add street label to background
	*    Creating the progress bar
	*    Setting the progress bar value
	*    Displaying the percent energy left
	*    Get the prefered size of the container
	*    Set bounds of the bar
	*    Setting the background color
	*    Setting the foreground color
	*    Setting the font
	*    Adding the bar to the background
	*    Set up the menu button
	*    Set up the nextStreet button
	*    Set up the c1 button
	*    Set up the c3 button
	*    Create random number generator
	*    Generate the time until attack
	*    Action listener for when to start attack
	*       Decriment the time
	*       IF time is less than 1
	*          Start attack
	*          Stop timer
	*       END if
	*    END action listener
	*    Create timer to listen for attack
	*    Start attack timer
	*    Add window listener for close
	*       Exit program
	*    END windowlistener
	* END Street3
	**********************************************************/
	public Street3(Street2 temp)
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Setting return value
		streetP = temp;

		//Calling method to start frames
		passThis();

		//Set frame title
		setTitle("Street 3");

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

		//Initialize bottom label
		bottomLabel = new JLabel();

		//Set foreground color to the label
		bottomLabel.setForeground(Color.BLACK);

		//Set font of that label
		bottomLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

		//Get the prefered size of the container
		size = bottomLabel.getPreferredSize();

		//Set bound of the label
		bottomLabel.setBounds(50, 700, size.width, size.height);

		//Add label into background
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

		//Add label into background
		background.add(topLabel);

		//Creating the Street image
		stre = new JLabel(new ImageIcon("street.jpg"));

		//Get the prefered size of the container
		size = stre.getPreferredSize();

		//Set bounds of the frame
		stre.setBounds(0, 150, size.width, size.height);

		//Add street label to background
		background.add(stre);

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

		//Set up the menu button
		setMenu();

		//Set up the nextStreet button
		setNextStreet();

		//Set up the prevStreet button
		setPreStreet();

		//Set up the c1 button
		setC1();

		//Set up the c3 button
		setC3();

		//Create random number generator
		rand = new Random();

		//Generate the time until attack
		time = 1;// rand.nextInt(10) + 5;

		//Action listener for when to start attack
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//Decriment the time
				time--;

				//IF time is less than 1
				if (time < 1)
				{
					//Tell the user how to kill zombies
					topLabel.setText("<html>Zombie attack!<br>" +
						"Find a weapon and click it to kill it " +
						"or you will be eaten.</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Start attack
					attack();

					//Stop timer
					timerStart.stop();

				}//END if
			}
		};//END action listener

		//Create timer to listen for attack
        timerStart = new Timer(1000, listener);

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Exit program
				System.exit(0);
			}

		});//END windowlistener

	}//END Street3

	/**********************************************************
	* Program Name   : attack
	* Author         : Cameron Fukes
	* Date           : May 1, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the attack button
	*    to the background.
	*
	* BEGIN attack
	*    Spaces to moves
	*    Action listener for updating the zombie
	*       Decriment moves
	*       Get the prefered size of the container
	*       Set the updating bounds of the button
	*       IF moves is less than 1
	*          Set ending frame visible true
	*          Set frame visiable false
	*          Stop timer
	*       END if
	*       Add Button into stre
	*    END action listener
	*    Create timer to move zombie
	*    Start timer to move zombie
	*    Create object of JButton
	*    Removing the border
	*    Add actionListener to zom
	*       Remove health based on wep level
	*       Display the amount of energy costed
	*       Get the prefered size of the container
	*       Set bound of the label
	*       IF zombie hp is 0
	*          Tell the user they killed the zombie
	*          Get the prefered size of the container
	*          Set bound of the label
	*          Stop the zombie movement
	*          Remove the zombie from frame
	*       END if
	*       IF weapon level is 0
	*          Tell the user they cant kill the zombie without a weapon
	*          Get the prefered size of the container
	*          Set bound of the label
	*       END if
	*    END actionlistener
	*    Add  mouse listener to zom for hovering over button
	*       Mouse has entered
	*          Display the amount of energy costed
	*          Get the prefered size of the container
	*          Set bound of the label
	*       Mouse has exited
	*          Remove cost of searching
	*    END mouse listener
	* END attack
	***********************************************************/
	private void attack()
	{
		//local constants

		//local variable

		/************************************/

		//Spaces to moves
   		moves = 750;

		//Action listener for updating the zombie
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
				//IF zom the button is enabled
				if(zom.isEnabled())
				{
					//Decriment moves
					moves--;

					//Get the prefered size of the container
					size = zom.getPreferredSize();

					//Set the updating bounds of the button
					zom.setBounds(moves, 390, size.width - 50, size.height - 20);

				}//END if

                //IF moves is less than 1
                if(moves < 1)
                {
					//Set ending frame visible true
					ending.setVisible(true);

					//Set frame visiable false
					setVisible(false);

                    //Stop timer
                    timerZom.stop();

                }//END if

                //Add Button into stre
				stre.add(zom);
            }
        };//END action listener

		//Create timer to move zombie
        timerZom = new Timer(10, listener);

        //Start timer to move zombie
        timerZom.start();

		//Create object of JButton
		zom = new JButton(new ImageIcon("zombie.jpg"));

		//Removing the border
		zom.setBorderPainted(false);

		//Add actionListener to zom
		zom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Remove health based on wep level
				Zombie3.hit();

				//Display the amount of energy costed
				bottomLabel.setText("Zombie hp: " + Zombie3.getVal());

				//Get the prefered size of the container
				size = bottomLabel.getPreferredSize();

				//Set bound of the label
				bottomLabel.setBounds(50, 700, size.width, size.height);

				//IF zombie hp is 0
				if(Zombie3.getVal() <= 0)
				{
					//Tell the user they killed the zombie
					topLabel.setText("<html>You defeated the zombie!</html>");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

					//Updating the bar class
					BarVal.setVal(BarVal.getVal() + 30);

					//Set energy bar
					bar.setValue(BarVal.getVal());

					//Stop the zombie movement
					timerZom.stop();

					//Disable the button
                    zom.setEnabled(false);

					//Remove the zombie from frame
					zom.setVisible(false);

				}//END if

				//IF weapon level is 0
				if(WepVal.getVal() == 0)
				{
					//Tell the user they cant kill the zombie without a weapon
					topLabel.setText("You need to search for a weapon if you " +
						"want to kill the zombie.");

					//Get the prefered size of the container
					size = topLabel.getPreferredSize();

					//Set bound of the label
					topLabel.setBounds(50, 50, size.width, size.height);

				}//END if
			}

		});//END actionlistener

		//Add  mouse listener to zom for hovering over button
		zom.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Zombie hp: " + Zombie3.getVal());

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

	}//END attack

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
	*       IF energy is 0
	*          Set ending frame visible true
	*          Set default close operation
	*          Set Street frame visible false
	*       ELSE IF not 0
	*          Set k4 visiable
	*          Update the frame
	*          IF timerStart is still going
	*             Stop timerStart
	*          ELSE IF timeStart is done
	*             Stop timerZom
	*          END if
	*       END if
	*       Set default close operation
	*       Set street frame visible false
	*    END actionlistener
	*    Add  mouse listener to c1 for hovering over button
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
	*    Add Button into stre
	* END setC1
	***********************************************************/
	private void setC1()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		c1 = new JButton(new ImageIcon("h5.jpg"));

		//Removing the border
		c1.setBorderPainted(false);

		//Add actionListener to c1
		c1.addActionListener(new ActionListener()
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

					//IF timerStart is not done
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set street frame visible false
					setVisible(false);
				}
				//ELSE IF the energy is not 0
				else
				{
					//Set k4 frame visible true
					k4.setVisible(true);

					//Update the frame
					k4.update();

					//IF timerStart is still going
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

				}//END if

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set this frame visible false
				setVisible(false);
			}

		});//END actionlistener

		//Add  mouse listener to c1 for hovering over button
		c1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Costs 10 energy to search this house");

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
		c1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = c1.getPreferredSize();

		//Set bounds of the Button
		c1.setBounds(250, 172, size.width - 40, size.height - 15);

		//Add Button into stre
		stre.add(c1);

	}//END setC1

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
	*       IF energy is 0
	*          Set ending frame visible true
	*          Set default close operation
	*          Set street frame visible false
	*       ELSE IF not 0
	*          Set church visiable
	*          Update the frame
	*          IF timerStart is still going
	*             Stop timerStart
	*          ELSE IF timeStart is done
	*             Stop timerZom
	*          END if
	*       END if
	*       Set default close operation
	*       Set street frame visible false
	*    END actionlistener
	*    Add  mouse listener to c3 for hovering over button
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
	*    Add Button into stre
	* END setC3
	***********************************************************/
	private void setC3()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton and set label on it
		c3 = new JButton(new ImageIcon("appt.jpg"));

		//Removing the border
		c3.setBorderPainted(false);

		//Add actionListener to c3
		c3.addActionListener(new ActionListener()
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

					//IF timerStart is not done
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set street frame visible false
					setVisible(false);
				}
				//ELSE IF not 0
				else
				{
					//Set church visiable
					appt.setVisible(true);

					//Update the frame
					appt.update();

					//IF timerStart is still going
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

				}//END if

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set street frame visible false
				setVisible(false);
			}

		});//END actionlistener

		//Add  mouse listener to c3 for hovering over button
		c3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Costs 10 energy to search this house");

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
		c3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

		//Get the prefered size of the container
		size = c3.getPreferredSize();

		//Set bounds of the Button
		c3.setBounds(490, 104, size.width - 40, size.height - 15);

		//Add Button into stre
		stre.add(c3);

	}//END setC3

	/**********************************************************
	* Program Name   : setNextStreet
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the next street button
	*    to the background.
	*
	* BEGIN setNextStreet
	*    Create object of JButton
	*    Removing the border
	*    Add actionListener to nextStreet
	*       Updating the bar class
	*       Reduce energy bar
	*       IF energy is 0
	*          Set ending frame visible true
	*       ELSE IF the energy is not 0
	*          Set street frame visible true
	*          IF timerStart is still going
	*             Stop timerStart
	*          ELSE IF timeStart is done
	*             Stop timerZom
	*          END if
	*       END if
	*       Set default close operation
	*       Set Story frame visible true
	*    END actionlistener
	*    Add  mouse listener to nextStreet for hovering over button
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
	*    Add Button into stre
	* END setNextStreet
	***********************************************************/
	private void setNextStreet()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton
		nextStreet = new JButton(new ImageIcon("nextstreet.jpg"));

		//Removing the border
		nextStreet.setBorderPainted(false);

		//Add actionListener to nextStreet
		nextStreet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 20);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);

					//IF timerStart is not done
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set street frame visible false
					setVisible(false);
				}
				//ELSE IF the energy is not 0
				else
				{
					//Set street frame visible true
					street.setVisible(true);

					//IF timerStart is still going
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Update the street
					street.update();

				}//END if

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set Story frame visible true
				setVisible(false);
			}

		});//END actionlistener

		//Add  mouse listener to nextStreet for hovering over button
		nextStreet.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Costs 20 energy to leave this street");

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
		nextStreet.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

		//Get the prefered size of the container
		size = nextStreet.getPreferredSize();

		//Set bounds of the Button
		nextStreet.setBounds(800, 220, size.width - 40, size.height - 15);

		//Add Button into stre
		stre.add(nextStreet);

	}//END setNextStreet

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
	*       IF timerStart is still going
	*          Stop timerStart
	*       ELSE IF timeStart is done
	*          Stop timerZom
	*       END if
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

				//IF timerStart is still going
				if(time >= 1)
				{
					//Stop timerStart
					timerStart.stop();
				}
				//ELSE IF timeStart is done
				else
				{
					//Stop timerZom
					timerZom.stop();

				}//END if

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
	* Program Name   : setPreStreet
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the preveous street button
	*    to the background.
	*
	* BEGIN setPreStreet
	*    Create object of JButton
	*    Removing the border
	*    Add actionListener to nextStreet
	*       Updating the bar class
	*       Reduce energy bar
	*       IF energy is 0
	*          Set ending frame visible true
	*       ELSE IF the energy is not 0
	*          Set street frame visible true
	*          IF timerStart is still going
	*             Stop timerStart
	*          ELSE IF timeStart is done
	*             Stop timerZom
	*          END if
	*       END if
	*       Set default close operation
	*       Set Story frame visible true
	*    END actionlistener
	*    Add  mouse listener to nextStreet for hovering over button
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
	*    Add Button into stre
	* END setPreStreet
	***********************************************************/
	private void setPreStreet()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton
		prevStreet = new JButton(new ImageIcon("prevstreet.jpg"));

		//Removing the border
		prevStreet.setBorderPainted(false);

		//Add actionListener to prevStreet
		prevStreet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Updating the bar class
				BarVal.setVal(BarVal.getVal() - 20);

				//Reduce energy bar
				bar.setValue(BarVal.getVal());

				//IF energy is 0
				if(BarVal.getVal() == 0)
				{
					//Set ending frame visible true
					ending.setVisible(true);

					//IF timerStart is not done
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					//Set street frame visible false
					setVisible(false);
				}
				//ELSE IF the energy is not 0
				else
				{
					//Set street frame visible true
					streetP.setVisible(true);

					//IF timerStart is still going
					if(time >= 1)
					{
						//Stop timerStart
						timerStart.stop();
					}
					//ELSE IF timeStart is done
					else
					{
						//Stop timerZom
						timerZom.stop();

					}//END if

					//Update the street
					streetP.update();

				}//END if

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set Story frame visible true
				setVisible(false);
			}

		});//END actionlistener

		//Add mouse listener to nextStreet for hovering over button
		prevStreet.addMouseListener(new java.awt.event.MouseAdapter()
		{
			//Mouse has entered
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				//Display the amount of energy costed
				bottomLabel.setText("Costs 20 energy to leave this street");

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
		prevStreet.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

		//Get the prefered size of the container
		size = prevStreet.getPreferredSize();

		//Set bounds of the Button
		prevStreet.setBounds(125, 200, size.width - 40, size.height - 15);

		//Add Button into stre
		stre.add(prevStreet);

	}//END setPreStreet

	/**********************************************************
	* Program Name   : update
	* Author         : Cameron Fukes
	* Date           : April 28, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Updates the frames components.
	*
	* BEGIN update
	*    Update bar
	*    IF timerStart is not done
	*       Start timerStart
	*    ELSE IF timeStart is done
	*       Start timerZom
	*    END if
	* END update
	***********************************************************/
	public void update()
	{
		//Update bar
		bar.setValue(BarVal.getVal());

		//IF timerStart is not done
		if(time >= 1)
		{
			//Start timerStart
			timerStart.start();
		}
		//ELSE IF timeStart is done
		else
		{
			//Start timerZom
			timerZom.start();

		}//END if

	}//END update

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
	*    Initialize mainMenu
	*    Initialize next street
	*    Initialize kitchen1
	*    Initialize kitchen2
	*    Initialize kitchen3
	*    Initialize ending
	* END passThis
	***********************************************************/
	public void passThis()
	{
		//Initialize mainMenu
		mainMenu = new MainMenuS3(this);

		//Initialize next street
		street = new Street4(this);

		//Initialize kitchen5
		k4 = new Kitchen5(this);

		//Initialize appt
		appt = new Appt(this);

		//Initialize ending
		ending = new Ending();

	}//END passThis

}//END Street3