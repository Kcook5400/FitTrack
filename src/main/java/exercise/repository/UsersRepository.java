package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exercise.beans.Users;


/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 15, 2021
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

}
