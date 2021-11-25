package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exercise.beans.ExercisesInSession;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 19, 2021
 */

@Repository
public interface ExercisesInSessionRepository extends JpaRepository<ExercisesInSession, Long> {

}
