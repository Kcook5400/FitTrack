package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exercise.beans.Meals;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Dec 3, 2021
 */

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {

}
