package com.dlizarra.startuphub.project;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody final ProjectDto project) {
		projectService.createProject(project, 1);
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.PUT)
	public void addMember(@Valid @RequestBody final ProjectDto project) {
		projectService.addMember(project.getId(), 1);
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable final Integer id, @Valid @RequestBody final ProjectDto project) {
		projectService.updateProject(project);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<ProjectDto> findAll() {
		return projectService.getProjects();
	}
}
