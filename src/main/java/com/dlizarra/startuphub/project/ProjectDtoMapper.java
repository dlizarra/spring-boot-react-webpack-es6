package com.dlizarra.startuphub.project;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class ProjectDtoMapper extends CustomMapper<Project, ProjectDto> {

	@Override
	public void mapAtoB(final Project project, final ProjectDto projectDto, final MappingContext context) {
		// projectDto.getCreator().setProjects(new ArrayList<ProjectDto>());
		// projectDto.getMembers().forEach(member -> member.setProjects(new ArrayList<ProjectDto>()));
	}

}
