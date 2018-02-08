/*

CarList.java
Author: Kevin Gao

This class is used to get information about different cars from a CSV file 
			in a list of Car objects
*/

import java.util.Arrays;
import java.lang.Comparable;

public class CarList
{
	// Data Members
	private Car[] cars;
	int count;

	/**
		* Constructor
	**/
	public CarList()
	{
		cars = new Car[10];
		count = 0;
	}

	public void addCar(Car c1)
	{
		int size = cars.length;
		count++;

		// If array is full, first resize array
		if (count >= size)
		{
			size++;
			
			Car[] newTempArray = new Car[size];
   			System.arraycopy(cars, 0, newTempArray, 0, cars.length);

   			cars = new Car[size];
   			System.arraycopy(newTempArray, 0, cars, 0, size);
		}

		cars[count - 1] = c1;
		
		sortArray();
	}

	public void sortArray()
	{
		// Bubble sorts the array after each element is added
		int size = cars.length;
		
		for (int i = (size - 1); i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if ((cars[j - 1] != null) && (cars[j] != null) && (cars[j - 1].compareTo(cars[j]) == -1))
				{
					Car temp = cars[j - 1];
					cars[j - 1] = cars[j];
					cars[j] = temp;
				}
			}
		}
	}

	public String toString()
	{
		// Data Members
		String output = "";

		for (int i = 0; i < count; i++)
		{
			boolean success = false;

			try
			{
				// Creates temporary GasCar reference of Car object from cars[i]
				GasCar temp = (GasCar) cars[i];
				
				// Adds to output string
				output += "Model: " + temp.getModel() + " Class: " + temp.getVehicleClass() 
				+ " Pollution Score: " + temp.getPollutionScore() + " MPG: " + temp.getMpg() 
					+ " Cylinders: " + temp.getNumberCylinders() + "\n";
				
				success = true;
			}
			catch (ClassCastException e)
			{

			}

			if (success == false)
			{
				try
				{
					// Creates temporary GreenCar reference of Car object from cars[i]
					GreenCar temp = (GreenCar) cars[i];
					
					// Adds to output string
					output += "Model: " + temp.getModel() + " Class: " + temp.getVehicleClass() 
						+ " Pollution Score: " + temp.getPollutionScore() 
							+ " Fuel Type: " + temp.getFuelType() + "\n";

					success = true;
				}
				catch (ClassCastException e)
				{

				}
			}
		}

		return output;
	}

	public String toStringGreenCars()
	{
		String output = "";

		for (int i = 0; i < count; i++)
		{
			try
			{
				GreenCar temp = (GreenCar) cars[i];
					
				output += "Model: " + temp.getModel() + " Fuel Type: " + temp.getFuelType() + "\n";
			}
			catch (ClassCastException e)
			{

			}
		}

		return output;
	}

	public double avgMpg()
	{
		double avgMpg = 0;
		int total = 0;

		// Calculate average
		for (int i = 0; i < count; i++)
		{
			try
			{
				GasCar temp = (GasCar) cars[i];
				total += temp.getMpg();
			}
			catch (ClassCastException e)
			{

			}
		}

		avgMpg = ((double) total) / count;

		// Return average mpg
		return avgMpg;
	}

	public double avgMpgByPartialModel(String model)
	{
		double avgMpg = 0;
		int total = 0, num = 0;
		
		// Calculate average
		for (int i = 0; i < count; i++)
		{
			if (cars[i].getModel().contains(model))
			{
				num++;

				try
				{
					GasCar temp = (GasCar) cars[i];
					total += temp.getMpg();
				}
				catch (ClassCastException e)
				{

				}
			}
		}

		avgMpg = ((double) total) / num;

		// Return average mpg
		return avgMpg;
	}

	public String[] findClassesByCylinders(int num)
	{
		// Data Members
		int size = 1, countClasses = 0;

		// Create new string array to store different classes
		String[] classes = new String[size];

		for (int i = 0; i < cars.length; i++)
		{
			try
			{
				// Avoid null-pointer exception
				if (cars[i] != null)
				{
					// Creates a temporary GasCar reference
					GasCar temp = (GasCar) cars[i];

					if (temp.getNumberCylinders() == num)
					{	
						// If array has space
						if (countClasses < classes.length)
						{
							classes[countClasses] = temp.getVehicleClass();
							countClasses++;
						}
						// If array is full, resize array and then add vehicle class string
						else
						{
							size++;
							String[] newTempArray = new String[size];
   							System.arraycopy(classes, 0, newTempArray, 0, classes.length);

   							classes = new String[size];
   							System.arraycopy(newTempArray, 0, classes, 0, size);
   							classes[size - 1] = temp.getVehicleClass();
						}
					}
				}
			}
			catch (ClassCastException e)
			{

			}
		}

		// Sort array
		Arrays.sort(classes);

		// Remove duplicate strings by finding where the last non-duplicate element is
		int i = 1;

		for (int j = 1; j < classes.length; j++)
		{
			if (!classes[j].equals(classes[j - 1]))
			{
				classes[i] = classes[j];
				i++;
			}
		}

		// Make everything after the last non-duplicate element "null"
		while (i < classes.length)
		{
			classes[i] = null;
			i++;
		}

		// Return array of classes
		return classes;
	}

	public String[] findModelsByClassAndMpg(String vehicleClass, int minMpg)
	{	
		// Data Members
		int size = 1, countModels = 0;

		// Create new string array to store different models
		String[] models = new String[size];

		for (int i = 0; i < cars.length; i++)
		{
			try
			{
				// Avoid null-pointer exception
				if (cars[i] != null)
				{
					// Creates a temporary GasCar reference
					GasCar temp = (GasCar) cars[i];

					if ((temp.getMpg() >= minMpg) && (temp.getVehicleClass().equals(vehicleClass)))
					{	
						// If array has space
						if (countModels < models.length)
						{
							models[countModels] = temp.getModel();
							countModels++;
						}
						// If array is full, resize array and then add vehicle class string
						else
						{
							size++;
							String[] newTempArray = new String[size];
   							System.arraycopy(models, 0, newTempArray, 0, models.length);

   							models = new String[size];
   							System.arraycopy(newTempArray, 0, models, 0, size);
   							models[size - 1] = temp.getModel();
   							countModels++;
						}
					}
				}
			}
			catch (ClassCastException e)
			{

			}
		}

		// Sort array
		Arrays.sort(models);

		// Return array of models
		return models;
	}
}