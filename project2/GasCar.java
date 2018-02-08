/*

GasCar.java
Author: Kevin Gao

This class is used to store the properties of a GasCar
*/

public class GasCar extends Car
{	
	// Data Members
	private int numberCylinders, mpg;

	/**
		* Constructor
	**/
	public GasCar(String model, String vehicleClass, int pollutionScore, int numberCylinders, int mpg)
	{
		super(model, vehicleClass, pollutionScore);
		this.numberCylinders = numberCylinders;
		this.mpg = mpg;
	}

	// Get mpg
	public int getMpg()
	{
		return mpg;
	}

	// Get number of cylinders
	public int getNumberCylinders()
	{
		return numberCylinders;
	}
}