package com.dlizarra.startuphub.project;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.project.support.ProjectUserPositionRepository;
import com.dlizarra.startuphub.support.AbstractWebIntegrationTest;
import com.dlizarra.startuphub.user.User;
import com.dlizarra.startuphub.user.UserRepository;

public class ProjectUserPositionRepositoryTest extends AbstractWebIntegrationTest {

	@Autowired
	private ProjectUserPositionRepository pupRepository;
	@Autowired
	private UserRepository userRepository;
	private ProjectUserPosition newPup;
	private User existingUser;
	private Project existingProject;

	@Before
	public void setup() {
		// New entity
		existingUser = new User();
		existingUser.setId(2);
		existingProject = new Project();
		existingProject.setId(2);
		final Position posDev = new Position();
		posDev.setId(Position.ID.DEVELOPER.getId());
		newPup = new ProjectUserPosition();
		newPup.setUser(existingUser);
		newPup.setProject(existingProject);
		newPup.setPosition(posDev);
	}

	@Sql({ "classpath:/sql/cleanup.sql", "classpath:/sql/project-user-position.sql" })
	@Test
	public void save_EntityGiven_ShouldSaveEntity() {
		// act
		pupRepository.save(newPup);
		final User userFromDb = userRepository.findOne(2).get();
		// assert
		assertThat(userFromDb.getProjectUserPositions().size()).isEqualTo(2);
	}

	@Sql({ "classpath:/sql/cleanup.sql", "classpath:/sql/project-user-position.sql" })
	@Test
	public void delete_EntityGiven_ShouldDeleteEntity() {
		// arrange
		User user = userRepository.findOne(1).get();
		final List<ProjectUserPosition> list = new ArrayList<ProjectUserPosition>(user.getProjectUserPositions());
		pupRepository.delete(list.get(1));
		user = userRepository.findOne(1).get();
		// assert
		assertThat(user.getProjectUserPositions().size()).isEqualTo(1);
	}

}
