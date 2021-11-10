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

import org.springframework.beans.factory.annotation.Autowired;

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
	public Users(long id, String userName, LocalDate dayJoined, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.dayJoined = dayJoined;
		this.email = email;
	}
	/**
	 * @param userName
	 * @param dayJoined
	 * @param email
	 */
	public Users(String userName, LocalDate dayJoined, String email) {
		super();
		this.userName = userName;
		this.dayJoined = dayJoined;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", dayJoined=" + dayJoined + ", email=" + email + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getDayJoined() {
		return dayJoined;
	}
	public void setDayJoined(LocalDate dayJoined) {
		this.dayJoined = dayJoined;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
