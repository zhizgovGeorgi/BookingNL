package com.example.bookingnl.bussines.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(userRepository).findByEmail((String) any());
    }


    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        User user = new User(123L, "jane.doe@example.org", "Jane", "Doe", "iloveyou", "User with email {} found",
                "User with email {} found");
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(userRepository).findByEmail((String) any());
    }


    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getEmail()).thenThrow(new UsernameNotFoundException("User with email {} found"));
        when(user.getPassword()).thenThrow(new UsernameNotFoundException("User with email {} found"));
        when(user.getRole()).thenReturn("Role");
        doNothing().when(user).setAdress((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((String) any());
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail((String) any());
        verify(user).getEmail();
        verify(user).getRole();
        verify(user).setAdress((String) any());
        verify(user).setEmail((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setId((Long) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((String) any());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at com.example.bookingnl.bussines.impl.UserServiceImpl.loadUserByUsername(UserServiceImpl.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getEmail()).thenReturn("");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn("Role");
        doNothing().when(user).setAdress((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((String) any());
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        userServiceImpl.loadUserByUsername("janedoe");
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername5() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: A granted authority textual representation is required
        //       at com.example.bookingnl.bussines.impl.UserServiceImpl.loadUserByUsername(UserServiceImpl.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn("");
        doNothing().when(user).setAdress((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((String) any());
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        userServiceImpl.loadUserByUsername("janedoe");
    }


    @Test
    void testLoadUserByUsername6() throws UsernameNotFoundException {
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn("Role");
        doNothing().when(user).setAdress((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((String) any());
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail((String) any());
        verify(user).setAdress((String) any());
        verify(user).setEmail((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setId((Long) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((String) any());
    }


    @Test
    void testFindByEmail() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertSame(user, userServiceImpl.findByEmail("jane.doe@example.org"));
        verify(userRepository).findUserByEmail((String) any());
    }

    @Test
    void testFindByEmail2() {
        when(userRepository.findUserByEmail((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findByEmail("jane.doe@example.org"));
        verify(userRepository).findUserByEmail((String) any());
    }


    @Test
    void testFindById() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.findUserById((Long) any())).thenReturn(user);
        assertSame(user, userServiceImpl.findById(123L));
        verify(userRepository).findUserById((Long) any());
    }


    @Test
    void testFindById2() {
        when(userRepository.findUserById((Long) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findById(123L));
        verify(userRepository).findUserById((Long) any());
    }


    @Test
    void testSave() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setAdress("Adress");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        assertNull(userServiceImpl.save(user1));
        verify(userRepository).existsByEmail((String) any());
    }


    @Test
    void testSave2() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.save((User) any())).thenReturn(user);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        User user1 = new User();
        user1.setAdress("Adress");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        assertSame(user, userServiceImpl.save(user1));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).save((User) any());
        verify(passwordEncoder).encode((CharSequence) any());
        assertEquals("secret", user1.getPassword());
    }


    @Test
    void testSave3() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.save((User) any())).thenReturn(user);
        when(passwordEncoder.encode((CharSequence) any()))
                .thenThrow(new UsernameNotFoundException("Saving new user {} ."));

        User user1 = new User();
        user1.setAdress("Adress");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.save(user1));
        verify(userRepository).existsByEmail((String) any());
        verify(passwordEncoder).encode((CharSequence) any());
    }
}

