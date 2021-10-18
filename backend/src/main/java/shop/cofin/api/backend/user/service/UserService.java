package shop.cofin.api.backend.user.service;

import shop.cofin.api.backend.user.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(long userId);
}
