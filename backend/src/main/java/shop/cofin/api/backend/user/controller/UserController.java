package shop.cofin.api.backend.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
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
    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        String returnUser = userService.login(user.getUsername(), user.getPassword());
        System.out.println("마리아DB에서 넘어 온 정보"+returnUser.toString());
        return new ResponseEntity<>(HttpStatus.OK);
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
