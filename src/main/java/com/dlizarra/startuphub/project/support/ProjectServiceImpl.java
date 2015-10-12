package com.dlizarra.startuphub.project.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlizarra.startuphub.project.Project;
import com.dlizarra.startuphub.project.ProjectDto;
import com.dlizarra.startuphub.support.OrikaBeanMapper;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private OrikaBeanMapper mapper;
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProjectDto createProject(final ProjectDto projectDto) {
		final Project project = projectRepository.save(mapper.map(projectDto, Project.class));
		return mapper.map(project, ProjectDto.class);
	}

}
