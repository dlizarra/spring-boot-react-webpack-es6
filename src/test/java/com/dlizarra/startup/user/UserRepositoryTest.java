package com.dlizarra.startup.user;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startup.support.AbstractWebIntegrationTest;
import com.dlizarra.startuphub.project.ProjectUserPosition;
import com.dlizarra.startuphub.user.User;
import com.dlizarra.startuphub.user.UserRepository;

@Sql({ "classpath:/sql/reset-db.sql", "classpath:/sql/user.sql" })
public class UserRepositoryTest extends AbstractWebIntegrationTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void save_EntityGiven_ShouldSaveEntity() {
		// arrange
		final User userStan = new User();
		userStan.setUsername("stan");
		// act
		userRepository.save(userStan);
		// assert
		assertThat(userStan.getId()).isNotNull();
	}

	@Test
	public void update_ExistingUserGiven_ShouldUpdateUser() {
		// arrange
		final User user = new User();
		user.setId(2);
		user.setUsername("albert");
		// act
		final User updatedUser = userRepository.save(user);
		// assert
		assertThat(updatedUser).isEqualTo(user);
	}

	@Test
	public void findOne_ExistingIdGiven_ShouldReturnEntity() {
		// act
		final Optional<User> userOpt = userRepository.findOne(1);
		assertThat(userOpt.isPresent()).isTrue();
		final User user = userOpt.get();
		// assert
		assertThat(user.getUsername()).isEqualTo("david");
	}

	@Transactional
	@Test
	public void getOne_ExistingIdGiven_ShouldReturnLazyEntity() {
		// act
		final User user1 = userRepository.getOne(1);
		// assert
		assertThat(user1).isNotNull();
		assertThat(user1.getId()).isEqualTo(1);
	}

	@Sql({ "classpath:/sql/reset-db.sql", "classpath:/sql/user.sql" })
	@Test
	public void findAll_TwoEntitiesinDb_ShouldReturnTwoEntities() {
		// act
		final List<User> allUsers = userRepository.findAll();
		// assert
		assertThat(allUsers.size()).isEqualTo(2);
	}

	@Test
	public void getProjectUserPositions_TwoEntitiesInDb_ShouldReturnTwoResults() {
		// arrange
		final User user = userRepository.findOne(1).get();
		// act
		final Set<ProjectUserPosition> projectUserPositions = user.getProjectUserPositions();
		// assert
		assertThat(projectUserPositions).isNotNull();
		assertThat(projectUserPositions.size()).isEqualTo(2);
	}

}
