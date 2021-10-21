package  com.oliviermesseumeni.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliviermesseumeni.fleetapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
