package com.dlizarra.startuphub.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;
import com.dlizarra.startuphub.user.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private OrikaBeanMapper mapper;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public List<ProjectDto> findAll() {
		final List<ProjectDto> allProjectDtos = new ArrayList<ProjectDto>();
		final List<Project> allProjects = projectRepository.findAll();
		allProjects.forEach(x -> allProjectDtos.add(mapper.map(x, ProjectDto.class)));

		return allProjectDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public ProjectDto getProject(final Integer id) {
		return mapper.map(find(id), ProjectDto.class);
	}

	@Transactional
	@Override
	public ProjectDto createProject(final ProjectDto dto, final Integer creatorId) {
		final Project toSave = mapper.map(dto, Project.class);
		Project saved = projectRepository.save(toSave);
		// addMember(saved.getId(), creatorId, Position.ID.CREATOR.getId());

		// refresh entity with the member relationship already persisted
		saved = find(saved.getId());

		return mapper.map(saved, ProjectDto.class);
	}

	private Project find(final Integer id) {
		final Optional<Project> projectOpt = projectRepository.findOne(id);
		return projectOpt.orElseThrow(() -> new ProjectNotFoundException(id));
	}

}
