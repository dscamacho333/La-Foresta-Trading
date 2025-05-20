package co.edu.unbosque.LaForestaTrading.repository;

import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepository extends CrudRepository<User, Long> {

    List<Investor> findByAlpacaStatus(String status);

    Investor findByTaxId(String taxId);


}
