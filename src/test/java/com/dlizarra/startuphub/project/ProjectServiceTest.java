package com.dlizarra.startuphub.project;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.dlizarra.startuphub.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.support.AbstractUnitTest;
import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;
import com.dlizarra.startuphub.user.UserRepository;

@Transactional
public class ProjectServiceTest extends AbstractUnitTest {

	@Mock
	private ProjectRepository projectRepository;
	@Mock
	private UserRepository userRepository;

	@Autowired
	@Spy
	private OrikaBeanMapper mapper;

	@InjectMocks
	private ProjectServiceImpl projectService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		final Project p1 = new Project();
		p1.setId(1);
		p1.setName("Project1");
		p1.setDescription("Description for Project1");
		final Project p2 = new Project();
		p2.setId(2);
		p2.setName("Project2");
		p2.setDescription("Description for Project2");
		final List<Project> projects = new ArrayList<>();
		projects.add(p1);
		projects.add(p2);
		User user1 = new User();
		user1.setId(1);

		when(projectRepository.findAll(any(Sort.class))).thenReturn(projects);
		when(projectRepository.findOne(1)).thenReturn(Optional.of(p1));
		when(projectRepository.findOne(5)).thenReturn(Optional.empty());
		when(projectRepository.findOne(199)).thenReturn(Optional.of(p1));
		when(projectRepository.save(any(Project.class))).thenReturn(p1);
		when(userRepository.findOne(1)).thenReturn(Optional.of(user1));
	}

	@Test
	public void testGetProjects_TwoProjectsInDb_ShouldReturnTwoProjects() {
		// act
		final List<ProjectDto> projects = projectService.getProjects();
		// assert
		assertThat(projects.size()).isEqualTo(2);

	}

	@Test
	public void testGetProject_ExistingIdGiven_ShouldReturnProject() {
		// act
		final ProjectDto p = projectService.getProject(1);
		// assert
		assertThat(p.getName()).isEqualTo("Project1");
	}

	@Test(expected = ProjectNotFoundException.class)
	public void testGetProject_NonExistingIdGiven_ShouldThrowProjectNotFoundException() {
		projectService.getProject(5);
	}

	@Test
	public void testCreateProject_ProjectGiven_ShouldSaveProject() {
		// arrange
		final ProjectDto savedDto = new ProjectDto();
		savedDto.setName("Project1");
		savedDto.setDescription("Description for Project1");
		// act
		final ProjectDto dto = projectService.createProject(savedDto, 1);
		// assert
		assertThat(dto.getId()).isEqualTo(1);
	}

	 @Test
	 public void testDeleteProject_ValidIdGiven_ShouldDeleteProject(){
	 	// act
	 	projectService.deleteProject(1);
	 	// assert
	 	verify(projectRepository).delete(1);
	 }

}
