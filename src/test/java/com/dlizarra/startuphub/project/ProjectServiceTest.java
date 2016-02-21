package com.dlizarra.startuphub.project;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		p1.setDescription("Description for Project 1");
		final Project p2 = new Project();
		p2.setId(2);
		p2.setName("Project2");
		p2.setDescription("Description for Project 2");
		final List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);
		when(projectRepository.findAll(any(Sort.class))).thenReturn(projects);
		when(projectRepository.findOne(1)).thenReturn(Optional.of(p1));
		when(projectRepository.findOne(5)).thenReturn(Optional.empty());
		when(projectRepository.findOne(199)).thenReturn(Optional.of(p1));
		final Project savedProject = new Project();
		savedProject.setId(199);
		savedProject.setName("Project created");
		savedProject.setDescription("Description for Project created");
		savedProject.setCreationTime(LocalDateTime.now());
		when(projectRepository.save(any(Project.class))).thenReturn(savedProject);
		when(projectRepository.findOne(199)).thenReturn(Optional.of(savedProject));

	}

	@Test
	public void testgetProjects_TwoProjectsInDb_ShouldReturnTwoProjects() {
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
		// TODO mock userrepository for creatorId 1, otherwise it's throwing a nullpointer

		// arrange
		final ProjectDto savedDto = new ProjectDto();
		savedDto.setName("Project created");
		savedDto.setDescription("Description for Project created");
		// act
		final ProjectDto dto = projectService.createProject(savedDto, 1);
		// assert
		assertThat(dto.getId()).isEqualTo(199);
	}

	// @Test
	// public void testDeleteProject_ValidIdGiven_ShouldDeleteProject(){
	// // act
	// projectService.deleteProject(2);
	// // assert
	// assertThat()
	// }

}
