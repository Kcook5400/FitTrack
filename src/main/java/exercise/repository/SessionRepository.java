package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exercise.beans.WorkoutSession;

public interface SessionRepository extends JpaRepository<WorkoutSession, Long>{

}
