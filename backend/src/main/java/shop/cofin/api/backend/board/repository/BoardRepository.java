package shop.cofin.api.backend.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.cofin.api.backend.board.entity.Article;

@Repository
public interface BoardRepository extends JpaRepository<Article, Long> {
}
