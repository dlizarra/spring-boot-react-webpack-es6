package com.dlizarra.startuphub.project;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Size;

public class ProjectDto {

	private Integer id;

	@Size(max = Project.MAX_LENGTH_NAME)
	private String name;

	@Size(max = Project.MAX_LENGTH_DESCRIPTION)
	private String description;

	private LocalDateTime creationTime;

	private LocalDateTime modificationTime;

	private Set<ProjectUserPosition> projectUserPositions;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(final LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(final LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Set<ProjectUserPosition> getProjectUserPositions() {
		return projectUserPositions;
	}

	public void setProjectUserPositions(final Set<ProjectUserPosition> projectUserPositions) {
		this.projectUserPositions = projectUserPositions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
