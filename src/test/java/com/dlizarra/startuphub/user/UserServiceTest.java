package com.dlizarra.startuphub.user;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlizarra.startuphub.AppConfig;
import com.dlizarra.startuphub.DatabaseConfig;
import com.dlizarra.startuphub.support.OrikaBeanMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class, DatabaseConfig.class })
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Autowired
	@Spy
	private OrikaBeanMapper mapper;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		final User u1 = new User();
		u1.setId(1);
		u1.setUsername("david");
		final User u2 = new User();
		u2.setId(2);
		u2.setUsername("mark");
		final List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		when(userRepository.findAll()).thenReturn(users);
		when(userRepository.findOne(1)).thenReturn(Optional.of(u1));
		when(userRepository.findOne(500)).thenReturn(Optional.empty());

	}

	@Test
	public void testFindAll_TwoUsersInDb_ShouldReturnTwoUsers() {
		// act
		final List<UserDto> users = userService.findAll();
		// assert
		assertThat(users.size()).isEqualTo(2);
	}

	@Test
	public void testGetUser_ExistingIdGiven_ShouldReturnUser() {
		// act
		final UserDto u = userService.getUser(1);
		// assert
		assertThat(u.getUsername()).isEqualTo("david");
	}

	@Test(expected = UserNotFoundException.class)
	public void testGetUser_NonExistingIdGiven_ShouldThrowUserNotFoundException() {
		userService.getUser(500);
	}

}