package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exercise.beans.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}