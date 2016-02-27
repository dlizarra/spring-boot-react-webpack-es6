package com.dlizarra.startuphub.project;

import java.util.List;

public interface ProjectService {

	ProjectDto createProject(ProjectDto dto, Integer creatorId);

	void updateProject(ProjectDto project);

	void deleteProject(Integer id);

	ProjectDto getProject(Integer id);

	List<ProjectDto> getProjects();

	void addMember(Integer projectId, Integer userId);

}
