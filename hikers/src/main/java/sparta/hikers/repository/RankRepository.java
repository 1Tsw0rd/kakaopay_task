package sparta.hikers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.hikers.entity.Ranks;

public interface RankRepository extends JpaRepository<Ranks, Integer> {
}
