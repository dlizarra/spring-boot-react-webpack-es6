package com.dlizarra.startup.user;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.dlizarra.startup.support.AbstractWebIntegrationTest;
import com.dlizarra.startuphub.user.User;
import com.dlizarra.startuphub.user.UserRepository;

@Sql({ "classpath:/sql/reset-db.sql", "classpath:/sql/user.sql" })
public class UserRepositoryTest extends AbstractWebIntegrationTest {

	@Autowired
	private UserRepository userRepository;
	private User user;

	@Before
	public void setup() {
		user = new User();
		user.setUsername("stan");
	}

	@Test
	public void save_EntityGiven_ShouldSaveEntity() {
		// act
		userRepository.save(user);
		// assert
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void findOne_ExistingIdGiven_ShouldReturnEntity() {
		// act
		final Optional<User> userOpt = userRepository.findOne(1);
		assertThat(userOpt.isPresent()).isTrue();
		final User user1 = userOpt.get();
		// assert
		assertThat(user1.getUsername()).isEqualTo("david");
	}

	@Test
	public void getProjectUserPositions_TwoEntitiesInDb_ShouldReturnTwoResults() {
		final User user = userRepository.findOne(1).get();
		assertThat(user.getProjectUserPositions()).isNotNull();
		assertThat(user.getProjectUserPositions().size()).isEqualTo(2);
	}

}
