package exercise.beans;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class ExerciseLocation {
	private String name;
	private String city;
	private LocalDate day;
	
	public ExerciseLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param city
	 * @param day
	 */
	public ExerciseLocation(String name, String city, LocalDate day) {
		super();
		this.name = name;
		this.city = city;
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "ExerciseLocation [name=" + name + ", city=" + city + ", day=" + day + "]";
	}
	
}

	