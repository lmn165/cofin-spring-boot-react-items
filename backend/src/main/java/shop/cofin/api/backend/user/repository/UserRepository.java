package shop.cofin.api.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.cofin.api.backend.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
