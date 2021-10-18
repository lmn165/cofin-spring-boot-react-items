package shop.cofin.api.backend.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.backend.item.service.ItemServiceImpl;

@RestController @RequiredArgsConstructor
public final class ItemController {
    private final ItemServiceImpl itemService;
}
