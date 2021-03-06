package shop.cofin.api.backend.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.cofin.api.backend.common.CommonController;
import shop.cofin.api.backend.user.domain.User;
import shop.cofin.api.backend.user.domain.UserDto;
import shop.cofin.api.backend.user.repository.UserRepository;
import shop.cofin.api.backend.user.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public final class UserController implements CommonController<User, Long> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto user){
//        return new ResponseEntity<>(userService.login(user.getUsername(), user.getPassword()), HttpStatus.OK);
        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()).get());
    }

    @GetMapping
    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getById(@PathVariable Long id) {
//        System.out.println("id: " + id);
//        User u = userRepository.getById(id );
//        System.out.println(u.toString());
        return ResponseEntity.ok(userRepository.getById(id));
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<List<User>> getList(@PathVariable int page) {
//        System.out.println("::::::: PageNumber :::::::: "+page);
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/join")
    @Override
    public ResponseEntity<String> save(@RequestBody User user) {
        logger.info(String.format("???????????? ?????? %s", user.toString()));
        userRepository.save(user);
        return ResponseEntity.ok("Save SUCCESS");
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        logger.info(String.format("???????????? ??????: %s", user.toString()));
        userRepository.save(user);
        return ResponseEntity.ok(userRepository.getById(user.getUserId()));
    }

    @Override
    public ResponseEntity<Optional<User>> findById(Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @Override
    @GetMapping("/existsById/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        System.out.println(" id " + id);
        boolean b = userRepository.existsById(id);
        System.out.println(" Exist : "+b);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/exist/{username}")
    public ResponseEntity<Boolean> exist(@PathVariable String username) {
        return ResponseEntity.ok(userRepository.existsByUsername(username));
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(userRepository.count());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("SUCCESS");
    }

}
