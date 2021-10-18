package shop.cofin.api.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.cofin.api.backend.user.entity.User;
import shop.cofin.api.backend.user.repository.UserRepository;

import java.util.Optional;

@Service @RequiredArgsConstructor
public final class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(long userId) {
        return userRepository.findById(userId);
    }
}
