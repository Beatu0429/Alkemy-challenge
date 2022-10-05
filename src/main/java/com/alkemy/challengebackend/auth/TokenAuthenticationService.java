package com.alkemy.challengebackend.auth;

import com.alkemy.challengebackend.model.User;
import com.alkemy.challengebackend.model.dto.UserAuthDTO;
import com.alkemy.challengebackend.model.dto.UserDTO;
import com.alkemy.challengebackend.repository.IUserRepository;
import com.alkemy.challengebackend.service.IUserService;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenAuthenticationService implements UserAuthenticationService {

    @NonNull
    TokenService tokens;
    @Autowired
    IUserService userService;
    @Autowired
    IUserRepository userRepository;

    @Override
    public Optional<UserAuthDTO> login(UserDTO userDTO, boolean isNew) {
        if( !isNew) {
            userDTO = userService.verifyCredentials(userDTO);
        }
        String token = tokens.expiring(Map.of("email", userDTO.getEmail()));

        UserAuthDTO authTokenDto = UserAuthDTO.builder()
                .token(token)
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .userLastName(userDTO.getUserLastName())
                .email(userDTO.getEmail())
                .rol(userDTO.getRol())
                .build();
        return Optional.of(authTokenDto);
    }


    @Override
    public Optional<User> findByToken(final String token) {
        return Optional
                .of(tokens.verify(token))
                .map(map -> map.get("email"))
                .flatMap(userRepository::findByEmail);
    }

    @Override
    public Optional<String> refreshToken(final String token) {
        User user = findByToken(token).orElseThrow();
        return Optional.of(tokens.expiring(ImmutableMap.of("email", user.getEmail())));
    }
}
