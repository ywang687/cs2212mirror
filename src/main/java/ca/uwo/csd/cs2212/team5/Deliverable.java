package ca.uwo.csd.cs2212.team5;

public class Deliverable implements java.io.Serializable, Comparable{

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

	/**
	 *returns a String representation of the Deliverable's data
	 */
	public String stringRepresentation(){
		return getName() + " - " + getType() + " - " + getWeight();
	}

	String getName(){
		return name;
	}

	Double getWeight(){
		return weight;
	}

	String getType(){
		return type;
	}

	void setName(String x){
		name = x;
	}


	void setWeight(Double x){
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

	@Override
	public int compareTo(Object arg0) {
		Deliverable tmp = (Deliverable)arg0;
		
		String compare1 = this.getName() + " - " + this.getType() + " - " + this.getWeight();
		String compare2 = tmp.getName() + " - " + tmp.getType() + " - " + tmp.getWeight();
		
		return compare1.compareTo(compare2);
	}

}
