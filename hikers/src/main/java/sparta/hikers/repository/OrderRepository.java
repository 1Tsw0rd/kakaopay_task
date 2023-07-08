package sparta.hikers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sparta.hikers.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
