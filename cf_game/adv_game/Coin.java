/**********************************************************
* Program Name   : Coin
* Author         : Cameron Fukes
* Date           : May 2, 2018
* Course/Section : CSC-264
*
* Program Description: Holds the stats for the number
*    of coins across different frames.
*
* Methods:
* incVal - Increases the number of coins
* getVal - Returns the number of coins
* reset  - resets the number of coins to 0
**********************************************************/
public class Coin
{
	//class constants

	//class variable
	private static int coin; //The number of coins

	/**********************************************************
	* Program Name   : incVal
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Increases the number of coins.
	*
	* BEGIN incVal
	*    Increase the number of coins by 1
	* END incVal
	***********************************************************/
	public static void incVal()
	{
		//local constants

		//local variable

		/************************************/

		//Increase the number of coins by 1
		coin = coin + 1;

	}//END incVal

	/**********************************************************
	* Program Name   : getVal
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Returns the number of coins.
	*
	* BEGIN getVal
	*    Return number of coins
	* END getVal
	***********************************************************/
	public static int getVal()
	{
		//local constants

		//local variable

		/************************************/

		//Return number of coins
		return coin;

	}//END getVal

	/**********************************************************
	* Program Name   : reset
	* Author         : Cameron Fukes
	* Date           : May 2, 2018
	* Course/Section : CSC-264
	*
	* Program Description: Resets the number of coins.
	*
	* BEGIN reset
	*    Reset number of coins
	* END reset
	***********************************************************/
	public static void reset()
	{
		//local constants

		//local variable

		/************************************/

		//Reset number of coins
		coin = 0;

	}//END reset

}//END Coin