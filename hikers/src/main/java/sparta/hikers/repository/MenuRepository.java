package sparta.hikers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sparta.hikers.entity.Menus;

public interface MenuRepository extends JpaRepository<Menus, Long> {
}
