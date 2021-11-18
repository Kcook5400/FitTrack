package exercise.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 10, 2021
 */

@Data
@Entity
public class ExercisesInSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private WorkoutSession workoutSession;
	@ManyToOne
	Exercise exercise;
	int minutes;

	/**
	 * 
	 */

	public ExercisesInSession() {
		// TODO Auto-generated constructor stub
	}

}

