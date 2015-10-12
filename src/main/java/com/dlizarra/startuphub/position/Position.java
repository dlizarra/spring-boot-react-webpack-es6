package com.dlizarra.startuphub.position;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dlizarra.startuphub.project.ProjectUserPosition;

@Entity
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "pk.position")
	private Set<ProjectUserPosition> projectUserPositions = new HashSet<ProjectUserPosition>();

	public enum Ids {
		CREATOR(1), DEVELOPER(2);

		private Integer id;

		private Ids(final Integer id) {
		}

		public Integer getId() {
			return id;
		}

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

	public Set<ProjectUserPosition> getProjectUserPositions() {
		return projectUserPositions;
	}

	public void setProjectUserPositions(final Set<ProjectUserPosition> projectUserPositions) {
		this.projectUserPositions = projectUserPositions;
	}

}
