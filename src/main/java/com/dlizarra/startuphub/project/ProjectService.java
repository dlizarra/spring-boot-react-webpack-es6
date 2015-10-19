package com.dlizarra.startuphub.project;

import java.util.List;

public interface ProjectService {

	List<ProjectDto> findAll();

	ProjectDto getProject(Integer id);
}
