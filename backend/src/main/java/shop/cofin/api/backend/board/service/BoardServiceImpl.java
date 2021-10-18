package shop.cofin.api.backend.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.cofin.api.backend.board.repository.BoardRepository;

@Service @RequiredArgsConstructor
public final class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
}
