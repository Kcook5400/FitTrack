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

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int minutesPerformed;
	private LocalDate dayPerformed ;
	@Autowired
	private ExerciseLocation location;
	
	public Exercise() {
		super();
	}
	
	public Exercise(String name) {
		super();
		this.name = name;
	}

	public Exercise(String name, int minutes, LocalDate day) {
		super();
		this.name = name;
		this.minutesPerformed=minutes;
		this.dayPerformed=day;
	}
	public Exercise(long id, String name, int minutes, LocalDate day) {
		super();
		this.id = id;
		this.name = name;
		this.minutesPerformed=minutes;
		this.dayPerformed=day;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinutesPerformed() {
		return minutesPerformed;
	}

	public void setMinutesPerformed(int minutesPerformed) {
		this.minutesPerformed = minutesPerformed;
	}

	public LocalDate getDayPerformed() {
		return dayPerformed;
	}

	public void setDayPerformed(LocalDate dayPerformed) {
		this.dayPerformed = dayPerformed;
	}

	public ExerciseLocation getLocation() {
		return location;
	}

	public void setLocation(ExerciseLocation location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", minutesPerformed=" + minutesPerformed + ", dayPerformed="
				+ dayPerformed + ", location=" + location + "]";
	}
	


	
}

