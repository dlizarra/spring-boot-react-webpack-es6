package com.dlizarra.startuphub.project;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends RuntimeException {

	public ProjectNotFoundException(final Integer id) {
		super("Could not find Project with id: " + id);
	}
}
