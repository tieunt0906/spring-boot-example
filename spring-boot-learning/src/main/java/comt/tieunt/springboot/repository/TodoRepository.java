package comt.tieunt.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comt.tieunt.springboot.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
