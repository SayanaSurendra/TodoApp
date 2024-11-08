package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {
    private AppUser appUser;

    @BeforeEach
    void setUp() {
        appUser=new AppUser("user1","welcome123!",AppRole.ROLE_APP_USER);
    }

    @Test
    void getUsername() {
        assertEquals("user1",appUser.getUsername());
    }

    @Test
    void setUsername() {
        appUser.setUsername("testUser");
        assertEquals("testUser",appUser.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("welcome123!",appUser.getPassword());
    }

    @Test
    void setPassword() {
        appUser.setPassword("Hello@123");
        assertEquals("Hello@123",appUser.getPassword());

    }

    @Test
    void getRole() {
        assertEquals(AppRole.ROLE_APP_USER,appUser.getRole());
    }

    @Test
    void setRole() {
        appUser.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN,appUser.getRole());
    }
}