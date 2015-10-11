package com.dlizarra.startuphub.project;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.user.User;

@Embeddable
@SuppressWarnings("serial")
public class ProjectUserPositionId implements Serializable {

	@ManyToOne
	private Project project;
	@ManyToOne
	private User user;
	@ManyToOne
	private Position position;

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(final Position position) {
		this.position = position;
	}

}
