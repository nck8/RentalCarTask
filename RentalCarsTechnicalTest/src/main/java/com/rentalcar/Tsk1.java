package com.rentalcar;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.rentalcar.domain.Car;

public class Tsk1 {

	public static JSONObject readFile(File path){
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser.parse(new FileReader(path));
			jsonObject = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject; 
	}
	public static List<Car> toCarlist(JSONObject fileObj){
		JSONArray vehList= (JSONArray) (((JSONObject) fileObj.get("Search"))).get("VehicleList");
		List<Car> cars = new ArrayList<>();
		for (Object object : vehList) {
			JSONObject obj = (JSONObject) object; 
			String sippLetters = (String) obj.get("sipp");
			Car car = new Car(obj.get("name").toString(),obj.get("sipp").toString(),Double.parseDouble(obj.get("price").toString()),obj.get("supplier").toString(),
					Double.parseDouble(obj.get("rating").toString()));

			for (int i = 0; i < sippLetters.length(); i++) {
				if(i==0){
					car.carType1=carTypeFirstLetter(sippLetters.charAt(i));
				}else if(i==1){
					car.carType2_doors=carTypeSecondLetter(sippLetters.charAt(i));
				}
				else if(i==2){
					car.transmission= transmissionType(sippLetters.charAt(i));
				}
				else if(i==3){
					String fuelOrAc= fuelOrAirCon(sippLetters.charAt(i));
					String[] fuelOrAcList = fuelOrAc.split(",");
					car.fuel= fuelOrAcList[0];
					car.airCon = fuelOrAcList[1];
				}
			}
			cars.add(car);
		}
		
		
		
		return cars;
	}
	@SuppressWarnings("unchecked")
	public static List<Car> nameOrder(List<Car> list){
		//JSONArray vehList= (JSONArray)((JSONObject) fileObj.get("Search")).get("VehicleList");
		Collections.sort(list, new Comparator<Car>() {
			@Override
			public int compare(Car object, Car object2) {
				return  Double.compare(object.getPrice(),object2.getPrice()); 
			}
		});
		for (Car object : list) {		
			JSONObject objSort = new JSONObject();
			objSort.put("price:", object.getPrice());	
			objSort.put("name:", object.getName());
			System.out.println(objSort);
		}
		return list; 
	}


	public static String carTypeFirstLetter(char w){
		switch(Character.toUpperCase(w)) {
		case 'M' :
			return  "Mini"; 		
		case 'E' :
			return  "Economy"; 		
		case 'C' :
			return "Compact"; 	
		case 'I' :
			return "Intermediate"; 
		case 'S' :
			return  "Standard"; 
		case 'F' :
			return  "Fullsize"; 	
		case 'P' :
			return  "Premium"; 	
		case 'L' :
			return "Luxury"; 	
		case 'X' :
			return  "Special"; 
		default :			
			//System.out.println("Invalid Letter");
			return null;
		}
	}

	public static String carTypeSecondLetter(char z){

		switch(Character.toUpperCase(z)) {
		case 'B' :
			return  "2 doors"; 			
		case 'C' :
			return "4 doors"; 			
		case 'D' :
			return "5 doors"; 			
		case 'W' :
			return  "Estate"; 		
		case 'T' :
			return  "Convertible"; 		
		case 'F' :
			return  "SUV"; 		
		case 'P' :
			return  "Pick up"; 		
		case 'V' :
			return  "Passenger Van"; 
		default :
			//System.out.println("Invalid Letter");
			return null;
		}
	}

	public static String transmissionType(char q){
		char qUpper = 0; 
		if(Character.isUpperCase(q))
		{
			qUpper = Character.toUpperCase(q);
		}else {
			qUpper = q; 
		}
		if (qUpper == 'M'){
			return "Manual";
		}else if  (qUpper == 'A'){
			return "Automatic";
		}else {
			return "";
		}
	}

	public static String fuelOrAirCon(char k){
		char kUpper = 0; 
		if(Character.isUpperCase(k))
		{
			kUpper = Character.toUpperCase(k);
		}else {
			kUpper = k; 
		}
		if (kUpper == 'R'){
			return "Petrol,no air conditioning";
		}else if  (kUpper == 'N'){
			 return "Petrol,air conditioning";
		}else {
			System.out.println("Invalid Letter");
			return "";
		}
	}


	public static List<Car> calulatespec(List<Car> cars){
		cars.forEach(x->{
			System.out.println(x.name + " - " + x.sipp + " - " + x.carType1 + " - " + x.carType2_doors + " - " +
		x.transmission + " - " + x.fuel + " - " + x.airCon);
		});
		return cars;

	}

	public static Map<String, Car> calulateHighestRatedSupplier(List<Car> list){
		Map<String, Car> map = new HashMap<>();
		for (Car car : list) {
			if(map.containsKey(car.carType1)){
				Car newCar = map.get(car.carType1);
				if(!(newCar.price > car.price)){
					map.replace(car.carType1, car);
				}
			}else{
				map.put(car.carType1, car);
			}
		}

		map.entrySet().forEach(x->{
			System.out.println(x.getValue().name+" - "+x.getKey()+" - "+x.getValue().supplier+" - "+x.getValue().rating);
		});
		return map;
	}


	public static int transmissionBreakdown(Car car){

		if(car.transmission == "Manual"){
			return 1;
		}else if (car.transmission == "Automatic"){
			return 5;
		}else {
			return 0; 
		}	

	}

	public static int air_Con_breakdown(Car car){

		if(car.airCon == "air conditioning"){
			return 2;
		}
			return 0; 
			
	}


	public static List<Car> calulateScore(List<Car> list){
		List<Car> cars = new ArrayList<>();
		for (Car car : list) {
			car.setScore(transmissionBreakdown(car)+air_Con_breakdown(car));
			car.setFinalScore(car.getScore() + car.getRating());
			cars.add(car);
		}	
		
		  Collections.sort(cars, new Comparator<Car>() {
			@Override
			public int compare(Car object, Car object2) {
				Car car1=object;
				Car car2=object2;
				return  Double.compare(car2.getFinalScore(), car1.getFinalScore()); 
			}
		});	
		for (Car car : cars) {
			System.out.println(car.getName() + "--" + car.getScore() + "--" + car.getRating() + "--" + car.getFinalScore());
		}
		return cars;
	}
	

	public static void main(String[] args) {
		//-----/s_home/nck8/Documents
		System.out.println("------------Name order------------");
		JSONObject obj =readFile(new File( "/Users/nnekakanu/Documents/vechicle.json"));
		List<Car> list = toCarlist(obj);
		nameOrder(list);
		System.out.println("------------Caluclate specification------------");
		calulatespec(list);
		System.out.println("------------Caluclate highest rated supplier------------");
		calulateHighestRatedSupplier(list);
		System.out.println("------------Caluclate score------------");
		calulateScore(list);
		//System.out.println("------------Caluclate highest rated supplier------------");
		//calulateHighestRatedSupplier(calulatespec(readFile(new File( "/Users/nnekakanu/Documents/vechicle.json"))));
		
	}

	
}



