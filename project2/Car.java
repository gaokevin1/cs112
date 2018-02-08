/*

Car.java
Author: Kevin Gao

This class is used to store the properties of a Car
*/

import java.lang.Comparable;

public class Car implements Comparable<Car>
{
	// Data Members
	private String model, vehicleClass;
	private int pollutionScore;

	/**
		* Default Constructor
	**/
	public Car()
	{
		this.model = "";
		this.vehicleClass = "";
		this.pollutionScore = 0;
	}

	/**
		* Constructor
	**/
	public Car(String model, String vehicleClass, int pollutionScore)
	{
		this.model = model;
		this.vehicleClass = vehicleClass;
		this.pollutionScore = pollutionScore;
	}

	public int compareTo(Car c1)
	{
		// If pollution scores are the same
		if (pollutionScore == c1.pollutionScore)
		{
			// Data Members
			boolean sortDone = true;
			String temp1 = model;
			String temp2 = c1.model;

			if (temp1.compareTo(temp2) > 0)
			{
				return -1;
			}
			else if (temp1.compareTo(temp2) < 0)
			{
				return 1;
			}
			else 
			{
				return 0;
			}

		}
		// If passed through car object has lower pollution score
		else if (pollutionScore > c1.pollutionScore)
		{
			return -1;
		}
		// If passed through car object has higher pollution score
		else
		{
			return 1;
		}
	}

	// Gets vehicle class
	public String getVehicleClass()
	{
		return vehicleClass;
	}

	// Gets model of car
	public String getModel()
	{
		return model;
	}

	public int getPollutionScore()
	{
		return pollutionScore;
	}
}