package sparta.hikers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sparta.hikers.entity.Points;

public interface PointRepository extends JpaRepository<Points, Long> {
}
