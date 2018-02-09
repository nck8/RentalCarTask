package com.rentalcar.domain;

public class Car extends CarType{

	public String sipp;
		public String name;
	public double price;
	public String supplier;
	public Double rating;
	public int score;
	public Double finalScore;
	
	public Car (){
		
	}
	public Car( String name,String sipp, double price, String supplier, Double rating) {
	//	super();
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}

	@Override
	public String toString() {
		return "Car [sipp=" + sipp + ", name=" + name + ", price=" + price + ", supplier=" + supplier + ", rating="
				+ rating + ", score=" + score + ", finalScore=" + finalScore + "]";
	}

	
	
	/*public String toString(){
		return name +" - "+rating+" - "+sipp+" - "+" - "+supplier +" - "+price;
	}
	*/
}