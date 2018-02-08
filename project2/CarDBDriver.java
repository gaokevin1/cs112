/*

CarDBDriver.java
Author: Kevin Gao

This class is used to call methods and manipulate all of the instances of Car objects
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarDBDriver
{
	public static void main(String[] args)
	{
		// Data Members
		String[] tempArray;

		if (args.length != 1)
		{
			System.out.println("usage: java Driver <filename>");
			System.exit(0);
		}
		else
		{
			// Creates a new CarList object
			CarList l1 = new CarList();
			
			// Gets data from CSV file and puts it in the CarList
			l1 = buildCarList(l1, args[0]);

			// If CarList is empty...
			if (l1 == null)
			{
				System.out.println("This CarList is void and has no contents.");
				System.exit(0);
			}
			else
			{
				// Displays all Car objects in CarList
				System.out.println("All Cars: ");
				System.out.println(l1.toString());

				// Displays the fuel type of green cars in the CarList
				System.out.println("Green Cars - Fuel Type:");
				System.out.println(l1.toStringGreenCars());

				// Displays the average MPG for all vehicles in the CarList
				System.out.print("Average MPG All: ");
				System.out.printf("%.2f\n", l1.avgMpg());

				System.out.println();

				// Displays the average MPG for all Subaru vehicles in the CarList
				System.out.print("Average MPG Subaru: ");
				System.out.printf("%.2f\n", l1.avgMpgByPartialModel("SUBARU"));

				System.out.println();

				// Displays the average MPG for all Toyota vehicles in the CarList
				System.out.print("Average MPG Toyota: ");
				System.out.printf("%.2f\n", l1.avgMpgByPartialModel("TOYOTA"));

				System.out.println();

				// Displays the average MPG for all Ferrari vehicles in the CarList
				System.out.print("Average MPG Ferrari: ");
				System.out.printf("%.2f\n", l1.avgMpgByPartialModel("FERRARI"));

				System.out.println();

				// Displays the vehicle classes with 4-cylinders in the CarList
				System.out.println("Vehicle Classes with 4-Cylinder Cars: ");
				tempArray = l1.findClassesByCylinders(4);

				for (int i = 0; i < tempArray.length; i++)
				{
					if (tempArray[i] != null)
					{
						System.out.println("   " + tempArray[i]);
					}
				}

				// Displays the vehicle classes with 6-cylinders in the CarList
				System.out.println("Vehicle Classes with 6-Cylinder Cars: ");
				tempArray = l1.findClassesByCylinders(6);

				for (int i = 0; i < tempArray.length; i++)
				{
					if (tempArray[i] != null)
					{
						System.out.println("   " + tempArray[i]);
					}
				}

				// Displays the small SUVs that have an MPG rating of greater than 22 in the CarList
				System.out.println("Small SUVs with MPG > 22: ");
				tempArray = l1.findModelsByClassAndMpg("small SUV", 22);

				for (int i = 0; i < tempArray.length; i++)
				{
					System.out.println("   " + tempArray[i]);
				}

				// Displays the small cars that have an MPG rating of greater than 35 in the CarList
				System.out.println("Small SUVs with MPG > 35: ");
				tempArray = l1.findModelsByClassAndMpg("small car", 35);

				for (int i = 0; i < tempArray.length; i++)
				{
					System.out.println("   " + tempArray[i]);
				}
			}
		}
	}

	public static CarList buildCarList(CarList l1, String filename)
	{
		// Creates a new File object
		File file = new File(filename);

		// Try and catch for errors
		try (Scanner input = new Scanner(file))
		{
			input.useDelimiter(",|\n");

			// Skip first line
			input.nextLine();	

			while (input.hasNext())
			{
				// Data members
				String fuelType = "", vehicleClass = "", model = "";
				int mpg = 0, numberCylinders = 0, pollutionScore = 0;

				// Gets information from the CSV file and turns it into a string variable
				String inputModel = input.next();

				// Check to see if read line is an integer type
				if (inputModel.trim().isEmpty() == false)
				{
					model = inputModel;
				}
				else
				{
					model = "";
				}

				// Skip 1 lines
				input.next();

				// Gets information from the CSV file and turns it into a string variable
				String inputNumberCylinders = input.next();

				// Check to see if read line is an int type
				if (inputNumberCylinders.equals("N/A"))
				{
					numberCylinders = 0;
				}
				else if (inputNumberCylinders.trim().isEmpty() == false)
				{
					numberCylinders = Integer.parseInt(inputNumberCylinders);
				}

				// Skip 2 lines
				for (int i = 0; i < 2; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputFuelType = input.next();

				// Check to see if read line is a String type
				if (inputFuelType.trim().isEmpty() == false)
				{
					fuelType = inputFuelType;
				}
				else
				{
					fuelType = "";
				}

				// Skip 4 lines
				for (int i = 0; i < 4; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputVehicleClass = input.next();

				// Check to see if read line is a String type
				if (inputVehicleClass.trim().isEmpty() == false)
				{
					vehicleClass = inputVehicleClass;
				}
				else
				{
					vehicleClass = "";
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputPollutionScore = input.next();

				// Check to see if read line is a int type
				if (inputPollutionScore.trim().isEmpty() == false)
				{
					pollutionScore = Integer.parseInt(inputPollutionScore);
				}
				else
				{
					pollutionScore = 0;
				}

				// Skip 2 lines
				for (int i = 0; i < 2; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputMpg = input.next();

				// Check to see if read line is a int type
				if (inputPollutionScore.trim().isEmpty() == false)
				{
					// Find index of "/" mark
					int index = inputMpg.indexOf("/");

					// Use the lower combined MPG number
					if (index > 0)
					{		
						inputMpg = inputMpg.substring(0, index);
						mpg = Integer.parseInt(inputMpg);
					}
					else
					{
						mpg = Integer.parseInt(inputMpg);
					}
				}
				else
				{
					mpg = 0;
				}

				// Checks to make sure all file-read data is valid
				if ((!model.equals("")) && (!vehicleClass.equals("")) && (!fuelType.equals("")) 
					&& (mpg != 0) && (pollutionScore != 0))
				{
					// Creates a new Car object with information from CSV file
					if (fuelType.equals("Electricity") || fuelType.equals("Hydrogen"))
					{
						// Makes a new green car object
						Car greenCar = new GreenCar(model, vehicleClass, pollutionScore, fuelType);
						l1.addCar(greenCar);
					}
					else
					{
						// Makes a new gas car object
						Car gasCar = new GasCar(model, vehicleClass, pollutionScore, numberCylinders, mpg);
						l1.addCar(gasCar);
					}
				}

				// Skip 2 lines
				for (int i = 0; i < 2; i++)
				{
					input.next();
				}

				input.nextLine();
			}

			// Close scanner
			input.close();
		}
		catch (FileNotFoundException fnf)
		{
			return null;
		}

		return l1;
	}
}