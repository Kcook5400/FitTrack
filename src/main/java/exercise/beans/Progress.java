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

public class Progress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int hoursSlept;
	private int minutesSlept;
	private double goalWeight;
	private double currentWeight;
	
	
	/**
	 * 
	 */
	public Progress() {
		// TODO Auto-generated constructor stub
	}

}
