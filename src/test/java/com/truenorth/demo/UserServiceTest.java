package com.truenorth.demo;

import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.UserRepository;
import com.truenorth.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUsername_UsernameExists_ReturnsUser() {
        String username = "test@example.com";
        User user = new User();
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        User foundUser = userService.findByUsername(username);

        assertEquals(username, foundUser.getUsername());
    }

    @Test
    void testFindByUsername_UsernameNotExists_ThrowsException() {
        String username = "nonexistent@example.com";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        try {
            userService.findByUsername(username);
        } catch (UsernameNotFoundException ex) {
            assertEquals("User not found", ex.getMessage());
        }
    }
}
