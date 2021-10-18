package shop.cofin.api.backend.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.backend.board.service.BoardServiceImpl;

@RestController @RequiredArgsConstructor
public final class BoardController {
    private final BoardServiceImpl boardService;
}
