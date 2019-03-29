/**********************************************************
* Program Name   : WepVal
* Author         : Cameron Fukes
* Date           : May 2, 2018
* Course/Section : CSC-264
*
* Program Description: Holds the stats for the weapon
*    level across different frames.
*
* Methods:
* incVal - Increases the weapon level
* getVal - Returns the weapon level
* reset  - resets the weapon level to 0
**********************************************************/
public class WepVal
{
	//class constants

	//class variable
	private static int wep; //The weapon level

	/**********************************************************
	* Program Name   : incVal
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Increases the weapon level.
	*
	* BEGIN incVal
	*    Increase the weapon level by 1
	* END incVal
	***********************************************************/
	public static void incVal()
	{
		//local constants

		//local variable

		/************************************/

		//Increase the weapon level by 1
		wep = wep + 1;

	}//END incVal

	/**********************************************************
	* Program Name   : getVal
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Returns the weapon level.
	*
	* BEGIN getVal
	*    Return weapon level
	* END getVal
	***********************************************************/
	public static int getVal()
	{
		//local constants

		//local variable

		/************************************/

		//Return weapon level
		return wep;

	}//END getVal

	/**********************************************************
	* Program Name   : reset
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Resets the weapon level.
	*
	* BEGIN reset
	*    Reset weapon level
	* END reset
	***********************************************************/
	public static void reset()
	{
		//local constants

		//local variable

		/************************************/

		//Reset weapon level
		wep = 0;

	}//END reset

}//END WepVal