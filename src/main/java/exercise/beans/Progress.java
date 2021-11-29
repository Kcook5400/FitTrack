package exercise.beans;

import javax.persistence.Entity;

import lombok.Data;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 29, 2021
 */
@Data
@Entity

public class Progress {
	
	
	private int hoursSlept;
	private int minutesSlept;
	private int goalWeight;
	private int currentWeight;
	
	
	/**
	 * 
	 */
	public Progress() {
		// TODO Auto-generated constructor stub
	}

}
