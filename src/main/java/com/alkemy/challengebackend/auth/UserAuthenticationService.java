package com.alkemy.challengebackend.auth;

import com.alkemy.challengebackend.model.User;
import com.alkemy.challengebackend.model.dto.UserAuthDTO;
import com.alkemy.challengebackend.model.dto.UserDTO;

import java.util.Optional;

public interface UserAuthenticationService {
    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<UserAuthDTO> login(UserDTO userDTO, boolean isNew);

    /**
     * Finds a user by its token.
     *
     * @param token user token
     * @return
     */
    Optional<User> findByToken(String token);

    /**
     * Returns a new token
     *
     * @param token the user to logout
     */
    Optional<String> refreshToken(String token);
}
