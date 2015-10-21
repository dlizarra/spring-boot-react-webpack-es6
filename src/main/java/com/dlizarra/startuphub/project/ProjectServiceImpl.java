package com.dlizarra.startuphub.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private OrikaBeanMapper mapper;
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<ProjectDto> findAll() {
		final List<ProjectDto> allProjectDtos = new ArrayList<ProjectDto>();
		final List<Project> allProjects = projectRepository.findAll();
		allProjects.forEach(x -> allProjectDtos.add(mapper.map(x, ProjectDto.class)));

		return allProjectDtos;
	}

	@Override
	public ProjectDto getProject(final Integer id) {
		return mapper.map(find(id), ProjectDto.class);
	}

	private Project find(final Integer id) {
		final Optional<Project> projectOpt = projectRepository.findOne(id);
		return projectOpt.orElseThrow(() -> new ProjectNotFoundException(id));
	}

}
