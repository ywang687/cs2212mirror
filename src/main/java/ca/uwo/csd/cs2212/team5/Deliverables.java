package ca.uwo.csd.cs2212.team5;

public class Deliverables {

	String name, type;
	Double weight;
	Grade mark;
	
	private String getName(){
		return name;
	}
	
	private double getWeight(){
		return weight;
	}
	
	private String getType(){
		return type;
	}
	
	private void setName(String x){
		name = x;
	}
	
	
	private void setWeight(double x){
		weight = x;
	}
	
	
	private void setType(String x){
		type = x;
	}
	
	
	private void delete(){
		this.name = null;
		this.type = null;
		this.weight = null;
	}
		
}
