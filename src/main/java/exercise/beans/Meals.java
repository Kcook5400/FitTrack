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

public class Meals {
	
	
	private String meal;
	private int mealTimeHours;
	private int mealTimeMInutes;
	private int calories;
	
	
	/**
	 * 
	 */
	public Meals() {
		// TODO Auto-generated constructor stub
	}

}
