package co.edu.unbosque.LaForestaTrading.repository;

import co.edu.unbosque.LaForestaTrading.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByInvestorId(Long investorId);

}
