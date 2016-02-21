package com.dlizarra.startuphub.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;
import com.dlizarra.startuphub.user.User;
import com.dlizarra.startuphub.user.UserDto;
import com.dlizarra.startuphub.user.UserNotFoundException;
import com.dlizarra.startuphub.user.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private OrikaBeanMapper mapper;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public ProjectDto createProject(final ProjectDto dto, final Integer creatorId) {
		final Project project = mapper.map(dto, Project.class);
		final User creator = userRepository.findOne(creatorId)
				.orElseThrow(() -> new UserNotFoundException(creatorId));

		// we keep in sync both sides of the relationship project-user
		creator.getProjects().add(project);
		project.getMembers().add(creator);
		project.setCreator(creator);
		final Project saved = projectRepository.save(project);

		return mapper.map(saved, ProjectDto.class);
	}

	@Transactional
	@Override
	public void addMember(final Integer projectId, final Integer memberId) {
		final Project project = find(projectId);
		final User user = userRepository.findOne(memberId)
				.orElseThrow(() -> new UserNotFoundException(memberId));

		// we keep in sync both sides of the relationship project-user
		user.getProjects().add(project);
		mapper.map(user, UserDto.class);
		project.getMembers().add(user);
	}

	@Transactional
	@Override
	public void updateProject(final ProjectDto project) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteProject(final Integer id) {
		projectRepository.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProjectDto> getProjects() {
		final List<ProjectDto> projectsDto = new ArrayList<ProjectDto>();
		final List<Project> projects = projectRepository.findAll(new Sort("id"));
		projects.forEach(x -> projectsDto.add(mapper.map(x, ProjectDto.class)));

		return projectsDto;
	}

	@Transactional(readOnly = true)
	@Override
	public ProjectDto getProject(final Integer id) {
		return mapper.map(find(id), ProjectDto.class);
	}

	@Transactional(readOnly = true)
	private Project find(final Integer id) {
		final Optional<Project> projectOpt = projectRepository.findOne(id);
		return projectOpt.orElseThrow(() -> new ProjectNotFoundException(id));
	}
}
