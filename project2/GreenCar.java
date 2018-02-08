/*

GreenCar.java
Author: Kevin Gao

This class is used to store the properties of a GreenCar
*/

public class GreenCar extends Car
{
	// Data Members
	private String fuelType;

	/**
		* Constructor
	**/
	public GreenCar(String model, String vehicleClass, int pollutionScore, String fuelType)
	{
		super(model, vehicleClass, pollutionScore);
		this.fuelType = fuelType;
	}

	// Gets fuel type
	public String getFuelType()
	{
		return fuelType;
	}
}