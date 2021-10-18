package shop.cofin.api.backend.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.cofin.api.backend.item.repository.ItemRepository;

@Service @RequiredArgsConstructor
public final class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;
}
