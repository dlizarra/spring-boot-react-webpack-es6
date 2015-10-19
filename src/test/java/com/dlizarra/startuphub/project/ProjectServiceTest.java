package com.dlizarra.startuphub.project;

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
public class ProjectServiceTest {

	@Mock
	private ProjectRepository projectRepository;

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
		final Project p2 = new Project();
		p2.setId(2);
		p2.setName("Project2");
		final List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);
		when(projectRepository.findAll()).thenReturn(projects);
		when(projectRepository.findOne(1)).thenReturn(Optional.of(p1));
		when(projectRepository.findOne(5)).thenReturn(Optional.empty());
	}

	@Test
	public void testfindAll_TwoProjectsInDb_ShouldReturnTwoProjects() {
		// act
		final List<ProjectDto> allProjects = projectService.findAll();
		// assert
		assertThat(allProjects.size()).isEqualTo(2);

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

}
