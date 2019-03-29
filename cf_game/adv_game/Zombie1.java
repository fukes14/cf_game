/**********************************************************
* Program Name   : Zombie1
* Author         : Cameron Fukes
* Date           : May 2, 2018
* Course/Section : CSC-264
*
* Program Description: Holds the stats for the number
*    of hit points the zombie has.
*
* Methods:
* incVal - Increases the number of coins
* getVal - Returns the number of hit points
* reset  - resets the number of hit points to 10
**********************************************************/
public class Zombie1
{
	//class constants

	//class variable
	private static int hp; //The number of hit points

	/**********************************************************
	* Program Name   : hit
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Take away hp on each click equal
	*    to the weapon level.
	*
	* BEGIN hit
	*    Take away hp on each click equal to the weapon level
	*    IF hp < 0
	*       Set hp to 0
	*    END if
	* END hit
	***********************************************************/
	public static void hit()
	{
		//local constants

		//local variable

		/************************************/

		//Take away hp on each click equal to the weapon level
		hp = hp - WepVal.getVal();

		//IF hp < 0
		if(hp < 0)
			//Set hp to 0
			hp = 0;
		//END if

	}//END hit

	/**********************************************************
	* Program Name   : getVal
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Returns the number of hit points.
	*
	* BEGIN getVal
	*    Return number of hit points
	* END getVal
	***********************************************************/
	public static int getVal()
	{
		//local constants

		//local variable

		/************************************/

		//Return number of hit points
		return hp;

	}//END getVal

	/**********************************************************
	* Program Name   : reset
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Resets the number of hit points.
	*
	* BEGIN reset
	*    Reset number of hit points
	* END reset
	***********************************************************/
	public static void reset()
	{
		//local constants

		//local variable

		/************************************/

		//Reset number of hit points
		hp = 10;

	}//END reset

}//END Zombie1