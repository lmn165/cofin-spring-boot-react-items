package shop.cofin.api.backend.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.backend.common.CommonController;
import shop.cofin.api.backend.item.domain.Item;
import shop.cofin.api.backend.item.repository.ItemRepository;
import shop.cofin.api.backend.item.service.ItemServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public final class ItemController implements CommonController<Item, Long> {
    private final ItemServiceImpl itemService;
    private final ItemRepository itemRepository;

    @Override
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @Override
    public ResponseEntity<Item> getById(Long id) {
        return ResponseEntity.ok(itemRepository.getById(id));
    }

    @Override
    public ResponseEntity<String> save(Item entity) {
        itemRepository.save(entity);
        return ResponseEntity.ok("Save SUCCESS");
    }

    @Override
    public ResponseEntity<Optional<Item>> findById(Long id) {
        return ResponseEntity.ok(itemRepository.findById(id));
    }

    @Override
    public ResponseEntity<Boolean> existsById(Long id) {
        return ResponseEntity.ok(itemRepository.existsById(id));
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(itemRepository.count());
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.ok("Delete SUCCESS");
    }
}
