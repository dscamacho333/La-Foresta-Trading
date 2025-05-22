package co.edu.unbosque.LaForestaTrading.repository;

import co.edu.unbosque.LaForestaTrading.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order, Long> {
}
