package ca.uwo.csd.cs2212.team5;

/**
 * Deliverable class represents a deliverable in a grade book application
 *
 */
public class Deliverable implements java.io.Serializable, Comparable{

	private static final long serialVersionUID = -7944796098054250965L;
	private String name, type;
	private Double weight;
	private Grade mark;

	/**
	 * Constructor
	 */
	public Deliverable(String name, String type, Double weight){
		this.name=name;
		this.type=type;
		this.weight=weight;
	}

	/**
	 * returns a string representation of a deliverable
	 * @return the string representation of the deliverable
	 */
	public String stringRepresentation(){
		return getName() + " - " + getType() + " - " + getWeight();
	}

	/**
	 * Returns the name of a deliverable
	 * @return the name of the deliverable
	 */
	public String getName(){
		return name;
	}

	/**
	 * Returns the weight of a deliverable
	 * @return the weight of the deliverable
	 */
	public Double getWeight(){
		return weight;
	}

	/**
	 * Returns the type of a deliverable
	 * @return the type of the deliverable
	 */
	public String getType(){
		return type;
	}


	/**
	 * Sets the name of a deliverable
	 * @param x the name of the deliverable
	 */
	public void setName(String x){
		name = x;
	}

    /**
     * Sets the weight of a deliverable
     * @param x the weight of the deliverable
     */
	public void setWeight(Double x){
		weight = x;
	}

    /**
     * Sets the type of a deliverable
     * @param x the type of the deliverable
     */
	public void setType(String x){
		type = x;
	}
	
    /**
     * Deletes a deliverable
     */
	public void delete(){
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
