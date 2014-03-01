package ca.uwo.csd.cs2212.team5;

public class Deliverable implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7944796098054250965L;
	private String name, type;
	private Double weight;
	private Grade mark;

	public Deliverable(String name, String type, Double weight){
		this.name=name;
		this.type=type;
		this.weight=weight;
	}

	String getName(){
		return name;
	}

	double getWeight(){
		return weight;
	}

	String getType(){
		return type;
	}

	void setName(String x){
		name = x;
	}


	void setWeight(double x){
		weight = x;
	}


	void setType(String x){
		type = x;
	}


	void delete(){
		this.name = null;
		this.type = null;
		this.weight = null;
	}

}
