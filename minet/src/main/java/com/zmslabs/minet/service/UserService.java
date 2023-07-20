package com.zmslabs.minet.service;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.model.UserDTO;

public interface UserService {
    UserDTO postUser(UserDTO userDto);
      User getUserDetails(Long id);
}
