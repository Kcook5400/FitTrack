package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exercise.beans.Session;

public interface ExerciseRepository extends JpaRepository<Session, Long>{

}