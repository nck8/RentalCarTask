package com.rentalcar;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;

import com.rentalcar.domain.Car;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:build/cucumber-html-report"},
    features = "src/test/resources",
    glue = "com.rentalcar")

public class RentalCarsTechnicalTestApplicationTests {
	List<Car> carList;
	Car car = new Car();
	@Before
	public void before (){
		carList = Tsk1.toCarlist(Tsk1.readFile(new File("/Users/nnekakanu/Documents/vechicle.json")));
	}
	@Given("^I have a list of cars,$")
	public void i_have_a_list_of_cars() throws Throwable {
		 //carList = Tsk1.toCarlist(Tsk1.readFile(new File("/Users/nnekakanu/Documents/vechicle.json")));
		 Assert.assertNotNull(carList);
	}

	@When("^I sort the list,$")
	public void i_sort_the_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		carList = Tsk1.nameOrder(carList);
		Assert.assertTrue(true);
	}

	@Then("^I should get the minimum price to be \"([^\"]*)\",$")
	public void i_should_get_the_minimum_price_to_be(String arg1) throws Throwable {
		Car car = carList.get(0);
		Assert.assertEquals(Double.parseDouble(arg1), car.getPrice());
	   
	}

	@Then("^the maximum price to be \"([^\"]*)\"\\.$")
	public void the_maximum_price_to_be(String arg1) throws Throwable {
		Car car = carList.get(carList.size()-1);
		Assert.assertEquals(Double.parseDouble(arg1), car.getPrice());
	}@Given("^I have the SIPP of a car which is ECMN,$")
	public void i_have_the_SIPP_of_a_car_which_is_ECMN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	    throw new PendingException();
	}

	@When("^I check each of the word in the letter,$")
	public void i_check_each_of_the_word_in_the_letter() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should get the specification of the car\\.$")
	public void i_should_get_the_specification_of_the_car() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^highest rated supplier should be \"([^\"]*)\" with a rating of \"([^\"]*)\",$")
	public void highest_rated_supplier_should_be_with_a_rating_of(String arg1, String arg2) throws Throwable {
		Map<String, Car> carListMap =  Tsk1.calulateHighestRatedSupplier(carList);
		carListMap.entrySet().stream().limit(1).collect(Collectors.toList()).get(0).getKey();
		Assert.assertEquals(arg1, carListMap.entrySet().stream().limit(1).collect(Collectors.toList()).get(0).getValue().getSupplier());
		Assert.assertEquals(Double.parseDouble(arg2), carListMap.entrySet().stream().limit(1).collect(Collectors.toList()).get(0).getValue().getRating());
	}

	@Then("^the least rated supplier should be \"([^\"]*)\" with a rating of \"([^\"]*)\"\\.$")
	public void the_least_rated_supplier_should_be_with_a_rating_of(String arg1, String arg2) throws Throwable {
		Map<String, Car> carListMap =  Tsk1.calulateHighestRatedSupplier(carList);
		Assert.assertEquals(arg1, carListMap.entrySet().stream().collect(Collectors.toList()).get(carListMap.size()-1).getValue().getSupplier());
		Assert.assertEquals(Double.parseDouble(arg2), carListMap.entrySet().stream().collect(Collectors.toList()).get(carListMap.size()-1).getValue().getRating());
	}
	
	

	@Then("^the maximum sum should be \"([^\"]*)\",$")
	public void the_maximum_sum_should_be(String arg1) throws Throwable {
		carList = Tsk1.calulateScore(carList);
		Car car = carList.get(0);
		Assert.assertEquals(Double.parseDouble(arg1), car.getFinalScore());
	}

	
	
	@Then("^the minimum sum should be \"([^\"]*)\"\\.$")
	public void the_minimum_sum_should_be(String arg1) throws Throwable {
		carList = Tsk1.calulateScore(carList);
		Car car = carList.get(carList.size()-1);
		Assert.assertEquals(Double.parseDouble(arg1), car.getFinalScore());
	}

	@Given("^I have the SIPP of a car which is \"([^\"]*)\",$")
	public void i_have_the_SIPP_of_a_car_which_is(String arg1) throws Throwable {
		for(Car c:carList){
			if(c.getSipp().equals(arg1)){
				car=c;
				Assert.assertTrue(true);
			}
		}
		Assert.assertFalse(false);
	}
	@When("^I check each of the word in the letter is not \"([^\"]*)\",$")
	public void i_check_each_of_the_word_in_the_letter_is_not(String arg1) throws Throwable {
	    Assert.assertNotNull(car);
	}

	@Then("^I should typeOne should be \"([^\"]*)\",$")
	public void i_should_typeOne_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, car.carType1);
	}

	@Then("^typeTwo should be \"([^\"]*)\",$")
	public void typetwo_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, car.carType2_doors);
	}


	@Then("^the transmission should be \"([^\"]*)\",$")
	public void the_transmission_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, car.transmission);
	}

	@Then("^the fuel should be \"([^\"]*)\",$")
	public void the_fuel_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, car.fuel);
	}

	@Then("^the airCon should be \"([^\"]*)\"\\.$")
	public void the_airCon_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, car.airCon);
	}

	

	





}
