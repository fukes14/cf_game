/**********************************************************
* Program Name   : QuitMenu
* Author         : Cameron Fukes
* Date           : April 10, 2018
* Course/Section : CSC-264
*
* Program Description: The frame that is displayed if the
*    user wants to quit the program from start frame.
*
* Methods:
* QuitMenuStart - Instantiates instance data and runs the frame.
* setNo         - Creates and adds the no button to the background.
* setYes        - Creates and adds the yes button to the background.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class QuitMenu extends JFrame
{
	//local constants

	//local variable
	private Start frameStart;  //The frame start to return to
	private JLabel background; //The background of the frame
	private JButton no;        //The no option button
	private JButton yes;       //The yes option button
	private JLabel quitLabel;  //The label displaying the question
	private Dimension size;    //The prefered size of the containers

	/**********************************************************
	* Program Name   : QuitMenu
	* Author         : Cameron Fukes
	* Date           : April 10, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Instantiates instance data and runs
	*    the frame that is displayed if the user wants to quit
	*    the program to make sure they do.
	*
	* BEGIN QuitMenu
	*    Set the return frame
	*    Set frame title
	*    Set default close operation
	*    Set bounds of the frame
	*    Set background image
	*    Create JPanel content pane
	*    Set ContentPane
	*    Set content pane to flow layout
	*    Set up the no button
	*    Set up the yes button
	*    Create Label for the frame
	*    Set foreground color to the label
	*    Set font of the label
	*    Get the prefered size of the container
	*    Set bound of the label
	*    Add label to the background
	*    END quit label --
	*    Add window listener for close
	*       Set visiable true
	*       Set default close operation
	*       Set visiable false
	*    END windowlistener
	*    Add background to contentpane
	* END QuitMenu
	**********************************************************/
	public QuitMenu(Start temp)
	{
		//local constants

		//local variable
		JPanel contentPane; //The main pane of the frame

		/******************************************/

		//Set the return frame
		frameStart = temp;

		//Set frame title
		setTitle("Quit Menu");

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

		//Set up the no button
		setNo();

		//Set up the yes button
		setYes();

		//Create Label for the frame
		quitLabel = new JLabel("Do you want to quit?");

		//Set foreground color to the label
		quitLabel.setForeground(Color.BLACK);

		//Set font of the label
		quitLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

		//Get the prefered size of the container
		size = quitLabel.getPreferredSize();

		//Set bound of the label
		quitLabel.setBounds((450 - size.width) / 2, 82, size.width, size.height);

		//Add label to the background
		background.add(quitLabel);

		//Add window listener for close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//Set visiable true
				frameStart.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set visiable false
				setVisible(false);
			}

		});//END windowlistener

		//Add background to contentpane
		contentPane.add(background);

	}//END QuitMenu

	/**********************************************************
	* Program Name   : setNo
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the no
	*    button to the background.
	*
	* BEGIN setNo
	*    Create object of JButton for the no option
	*    Add actionListener to no
	*       Set Start visiable true
	*       Set default close operation
	*       Set visiable false
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setNo
	***********************************************************/
	private void setNo()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton for the no option
		no = new JButton(new ImageIcon("no.jpg"));

		//Removing the border
		no.setBorderPainted(false);

		//Add actionListener to no
		no.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Set Start visiable true
				frameStart.setVisible(true);

				//Set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//Set visiable false
				setVisible(false);
			}

		});//END actionlistener

		//Set font of the Button
		no.setFont(new Font("Times New Roman", Font.BOLD, 26));

		//Get the prefered size of the container
		size = no.getPreferredSize();

		//Set bounds of the Button
		no.setBounds(250, 140, size.width - 35, size.height - 20);

		//Add Button into background
		background.add(no);

	}//END setNo

	/**********************************************************
	* Program Name   : setYes
	* Author         : Cameron Fukes
	* Date           : April 30, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Creates and adds the yes
	*    button to the background.
	*
	* BEGIN setYes
	*    Create object of JButton
	*    Add actionListener to yes
	*       Exit program
	*    END actionlistener
	*    Set font of the Button
	*    Get the prefered size of the container
	*    Set bounds of the Button
	*    Add Button into background
	* END setYes
	***********************************************************/
	private void setYes()
	{
		//local constants

		//local variable

		/************************************/

		//Create object of JButton
		yes = new JButton(new ImageIcon("yes.jpg"));

		//Removing the border
		yes.setBorderPainted(false);

		//Add actionListener to yes
		yes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Exit program
				System.exit(0);
			}

		});//END actionlistener

		//Set font of the Button
		yes.setFont(new Font("Times New Roman", Font.BOLD, 26));

		//Get the prefered size of the container
		size = yes.getPreferredSize();

		//Set bounds of the Button
		yes.setBounds(95, 140, size.width - 35, size.height - 20);

		//Add Button into contentPane
		background.add(yes);

	}//END setYes

}//END QuitMenuStart