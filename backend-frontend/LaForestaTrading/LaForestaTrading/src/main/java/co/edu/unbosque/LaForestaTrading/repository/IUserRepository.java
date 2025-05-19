package co.edu.unbosque.LaForestaTrading.repository;

import co.edu.unbosque.LaForestaTrading.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}
