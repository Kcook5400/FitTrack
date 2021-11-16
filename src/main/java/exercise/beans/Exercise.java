package exercise.beans;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 10, 2021
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String type;
	
	
	
	/**
	 * 
	 */
	public Exercise() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
