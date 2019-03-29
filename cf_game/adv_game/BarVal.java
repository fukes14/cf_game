/**********************************************************
* Program Name   : BarVal
* Author         : Cameron Fukes
* Date           : April 23, 2018
* Course/Section : CSC-264
*
* Program Description: Holds the stats for the progress
*    bar across different frames.
*
* Methods:
* setVal - Checks what value is and sets the energy value
* getVal - Returns the energy value
* reset  - resets the energy value to 75
**********************************************************/
public class BarVal
{
	//class constants

	//class variable
	private static int energy; //The value on the progress bar

	/**********************************************************
	* Program Name   : setVal
	* Author         : Cameron Fukes
	* Date           : April 23, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Checks and sets the energy value.
	*
	* BEGIN setVal
	*    IF in val is less than or equal to 0
	*       Set energy to 0
	*    ELSE IF in val is greater than or equal to 100
	*       Set energy to 100
	*    ELSE
	*       Set energy to temp
	*    END if
	*    Initialize frameQuit
	* END setVal
	***********************************************************/
	public static void setVal(int temp)
	{
		//local constants

		//local variable

		/************************************/

		//IF in val is less than or equal to 0
		if(temp <= 0)
			//Set energy to 0
			energy = 0;
		//ELSE IF in val is greater than or equal to 100
		else if(temp >= 100)
			//Set energy to 100
			energy = 100;
		//ELSE
		else
			//Set energy to temp
			energy = temp;
		//END if

	}//END setVal

	/**********************************************************
	* Program Name   : getVal
	* Author         : Cameron Fukes
	* Date           : April 23, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Returns the energy value.
	*
	* BEGIN getVal
	*    Return energy
	* END getVal
	***********************************************************/
	public static int getVal()
	{
		//local constants

		//local variable

		/************************************/

		//Return energy
		return energy;

	}//END getVal

	/**********************************************************
	* Program Name   : reset
	* Author         : Cameron Fukes
	* Date           : April 23, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Resets the energy value.
	*
	* BEGIN reset
	*    Reset energy
	* END reset
	***********************************************************/
	public static void reset()
	{
		//local constants

		//local variable

		/************************************/

		//Reset energy
		energy = 75;

	}//END reset

}//END BarVal