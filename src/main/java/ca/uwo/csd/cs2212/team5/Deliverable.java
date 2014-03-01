package ca.uwo.csd.cs2212.team5;

/**
 * Deliverable class represents a deliverable in a gradebook application
 *
 */
public class Deliverable {

	String name, type;
	Double weight;
	Grade mark;

	/**
	 * Constructs a new Deliverable object
	 * @param name the name of the deliverable
	 * @param type the type of deliverable
	 * @param weight the weight of the deliverable
	 */
	public Deliverable(String name, String type, Double weight){
		this.name=name;
		this.type=type;
		this.weight=weight;
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
	public double getWeight(){
		return weight;
	}

	/**
	 * Returns the type of deliverable
	 * @return the type of the deliverable
	 */
	public String getType(){
		return type;
	}

	/**
	 * Sets the name of a deliverable
	 * @param x the name for the deliverable
	 */
	private void setName(String x){
		name = x;
	}


	/**
	 * Sets the weight of a deliverable
	 * @param x the weight of the deliverable
	 */
	public void setWeight(double x){
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
	 * "Deletes" a deliverable object by setting its contents to null;
	 */
	public void delete(){
		this.name = null;
		this.type = null;
		this.weight = null;
	}

}
