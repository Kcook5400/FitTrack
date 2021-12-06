package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exercise.beans.Progress;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Dec 3, 2021
 */

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

}
