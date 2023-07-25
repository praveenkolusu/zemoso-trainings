package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.UserDTO;
import com.zmslabs.minet.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class UserServiceImplTest {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private UserServiceImpl userService;

    @BeforeEach
      void setUp() {
        userRepository = mock(UserRepository.class);
        modelMapper = mock(ModelMapper.class);
        userService = new UserServiceImpl(userRepository, modelMapper);
    }

    @Test
      void testPostUser() {
        // Mock data
        UserDTO userDto = new UserDTO();
        User user = new User();

        // Mock repository and model mapper behavior
        when(modelMapper.map(userDto, User.class)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

        // Call the method under test
        UserDTO result = userService.postUser(userDto);

        // Verify the interactions and assertions
        assertEquals(userDto, result);
    }

    @Test
      void testGetUserDetails_UserFound() {
        // Mock data
        Long userId = 1L;
        User user = new User();

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Call the method under test
        User result = userService.getUserDetails(userId);

        // Verify the interactions and assertions
        assertEquals(user, result);
    }

    @Test
      void testGetUserDetails_UserNotFound() {
        // Mock data
        Long userId = 1L;

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Verify that DataNotFoundException is thrown for the user not found
        assertThrows(DataNotFoundException.class, () -> {
            userService.getUserDetails(userId);
        });
    }
}

