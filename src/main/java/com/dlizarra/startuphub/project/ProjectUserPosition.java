package com.dlizarra.startuphub.project;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.user.User;

@Entity
@Table(name = "project2user2position")
@AssociationOverrides({ @AssociationOverride(name = "pk.project", joinColumns = @JoinColumn(name = "project_id") ),
		@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "user_id") ),
		@AssociationOverride(name = "pk.position", joinColumns = @JoinColumn(name = "position_id") ) })
public class ProjectUserPosition {

	@EmbeddedId
	private ProjectUserPositionId pk = new ProjectUserPositionId();

	@Transient
	public Project getProject() {
		return pk.getProject();
	}

	public void setProject(final Project project) {
		pk.setProject(project);
	}

	@Transient
	public User getUser() {
		return pk.getUser();
	}

	public void setUser(final User User) {
		pk.setUser(User);
	}

	@Transient
	public Position getPosition() {
		return pk.getPosition();
	}

	public void setPosition(final Position position) {
		pk.setPosition(position);
	}

}
