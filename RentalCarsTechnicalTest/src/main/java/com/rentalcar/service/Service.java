package com.rentalcar.service;

import java.io.File;
import java.util.List;

import com.rentalcar.Tsk1;
import com.rentalcar.domain.Car;

public class Service {

	public static List<Car> readFile(){
		return Tsk1.toCarlist(Tsk1.readFile(new File("/Users/nnekakanu/Documents/vechicle.json")));
	}
}
