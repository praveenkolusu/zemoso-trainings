package com.zmslabs.minet.controller;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.model.UserDTO;
import com.zmslabs.minet.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
      void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
      void testPostUser() {
        // Mock data
        UserDTO userDto = new UserDTO();
        User user = new User();

        // Mock UserService behavior
        when(userService.postUser(userDto)).thenReturn(userDto);

        // Call the method under test
        ResponseEntity<UserDTO> responseEntity = userController.postUser(userDto);

        // Verify the interactions and assertions
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(userDto, responseEntity.getBody());
    }

    @Test
      void testGetUserDetails() {
        // Mock data
        Long userId = 1L;
        User user = new User();

        // Mock UserService behavior
        when(userService.getUserDetails(userId)).thenReturn(user);

        // Call the method under test
        ResponseEntity<User> responseEntity = userController.getUserDetails(userId);

        // Verify the interactions and assertions
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }
}
