package exercise.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 29, 2021
 */

@Data
@Entity

public class Meals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
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
