package com.rentalcar.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.Tsk1;
import com.rentalcar.domain.Car;
import com.rentalcar.service.Service;


@RestController
public class MainController extends Service {
	
	@RequestMapping(value="/calulateScore",method=RequestMethod.GET)
	public List<Car> calulateScore(){
		return Tsk1.calulateScore(readFile());
	}
	@RequestMapping(value="/calulateHighestRatedSupplier",method=RequestMethod.GET)
	public Map<String, Car> calulateHighestRatedSupplier(){
		return Tsk1.calulateHighestRatedSupplier(readFile());
	}
	@RequestMapping(value="/nameOrder",method=RequestMethod.GET)
	public List<Car> nameOrder(){
		return Tsk1.nameOrder(readFile());
	}
	//reads the file
	@RequestMapping(value="/file",method=RequestMethod.GET)
	public List<Car> file(){
		return readFile();
	}
	@RequestMapping(value="/spec",method=RequestMethod.GET)
	public List<Car> spec(){
		return Tsk1.calulatespec(readFile());
	}
}
