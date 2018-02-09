
Feature: RentalCars
Background
			Given I have this "/Users/nnekakanu/Documents/vechicle.json" file, 
			When I read the file,
			Then it should not be empty.
			
			Scenario: Print list of all the cars, in ascending price order. 
				Given I have a list of cars, 
				When I sort the list, 
				Then I should get the minimum price to be "120.16",
				And the maximum price to be "789.75". 
				
			Scenario: Calculate the specification of the vehicles based on their SIPP. 
				Given I have the SIPP of a car which is "ECMR", 
				When I check each of the word in the letter is not "null", 
				Then I should typeOne should be "Economy", 
				And typeTwo should be "4 doors",
				And the transmission should be "Manual",
				And the fuel should be "Petrol", 
				And the airCon should be "no air conditioning".
				
			
			Scenario: Print out the highest rated supplier per car type, in descending order. 
				Given I have a list of cars, 
				When I sort the list, 
				Then highest rated supplier should be "Hertz" with a rating of "8.9", 
				And the least rated supplier should be "Europcar" with a rating of "8.0".
				
					
			
			
			Scenario: Print out a list of vehicles, ordered by the sum of the scores in descending order. 
				Given I have a list of cars, 
				When I sort the list, 
				Then the maximum sum should be "13.9",
				And the minimum sum should be "8.8".
			
			
			
