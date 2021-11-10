package exercise.beans;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Nov 8, 2021
 */

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


import lombok.Data;
@Data
@Entity
public class Users{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private LocalDate dayJoined ;
	private String email;
	/**
	 * @param id
	 * @param userName
	 * @param dayJoined
	 * @param email
	 */
	/**
	 * 
	 */
	public Users() {
		super();
	}


}
