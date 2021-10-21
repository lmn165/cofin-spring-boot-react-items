package shop.cofin.api.backend.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.backend.board.domain.Article;
import shop.cofin.api.backend.board.repository.BoardRepository;
import shop.cofin.api.backend.board.service.BoardServiceImpl;
import shop.cofin.api.backend.common.CommonController;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public final class BoardController implements CommonController<Article, Long> {
    private final BoardServiceImpl boardService;
    private final BoardRepository boardRepository;


    @Override
    public ResponseEntity<List<Article>> findAll() {
        return ResponseEntity.ok(boardRepository.findAll());
    }

    @Override
    public ResponseEntity<Article> getById(Long id) {
        return ResponseEntity.ok(boardRepository.getById(id));
    }

    @Override
    public ResponseEntity<String> save(Article entity) {
        boardRepository.save(entity);
        return ResponseEntity.ok("Save SUCCESS");
    }

    @Override
    public ResponseEntity<Optional<Article>> findById(Long id) {
        return ResponseEntity.ok(boardRepository.findById(id));
    }

    @Override
    public ResponseEntity<Boolean> existsById(Long id) {
        return ResponseEntity.ok(boardRepository.existsById(id));
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(boardRepository.count());
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        boardRepository.deleteById(id);
        return ResponseEntity.ok("Delete SUCCESS");
    }
}
