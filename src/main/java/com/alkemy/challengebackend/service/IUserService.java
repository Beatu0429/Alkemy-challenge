package com.alkemy.challengebackend.service;

import com.alkemy.challengebackend.model.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    public UserDTO createUser(UserDTO userDTO) throws IOException;

    public UserDTO readUser(Long id);

    public UserDTO updateUser(UserDTO userDTO);

    public void deleteUser(Long id);

    public List<UserDTO> listUser();

    public UserDTO verifyCredentials(UserDTO userDTO);
}
