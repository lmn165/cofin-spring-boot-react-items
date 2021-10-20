package shop.cofin.api.backend.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.cofin.api.backend.user.domain.User;
import shop.cofin.api.backend.user.domain.UserDto;
import shop.cofin.api.backend.user.service.UserServiceImpl;

import java.util.Optional;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public final class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserServiceImpl userService;

    @PostMapping("/join")
    public ResponseEntity<Optional<User>> join(@RequestBody UserDto user){
        logger.info(String.format("User Join Info is %s", user.toString()));
        User u = new User();
        u.setUserId((long)3);
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setRegDate(user.getRegDate());
        userService.join(u);
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto user){
//        return new ResponseEntity<>(userService.login(user.getUsername(), user.getPassword()), HttpStatus.OK);
        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()).get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) throws JsonProcessingException {
        User user = userService.findById(id).get();
        UserDto userDto = UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .regDate(user.getRegDate())
                .build();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
