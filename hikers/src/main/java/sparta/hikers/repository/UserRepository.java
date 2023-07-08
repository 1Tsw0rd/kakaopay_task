package sparta.hikers.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import sparta.hikers.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Users> findByUserId(Long userId);
}
