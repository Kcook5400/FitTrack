package exercise.beans;

import java.time.LocalDate;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 8, 2021
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
public class WorkoutSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate dayPerformed ;
	@OneToOne
	private Users users;
	private String location;
	

	
	public WorkoutSession() {
		super();
	}
}

	/**
	 * @param id
	 * @param dayPerformed
	 * @param exercises
	 * @param location
	 */
