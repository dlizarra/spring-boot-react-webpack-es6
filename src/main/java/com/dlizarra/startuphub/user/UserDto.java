package com.dlizarra.startuphub.user;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Size;

import com.dlizarra.startuphub.role.Role;

public class UserDto {

	private Integer id;

	@Size(max = User.MAX_LENGTH_USERNAME)
	private String username;

	@Size(min = User.MIN_LENGTH_PASSWORD, max = User.MAX_LENGTH_PASSWORD)
	private String password;

	private boolean enabled;

	private LocalDateTime creationTime;

	private LocalDateTime modificationTime;

	private Set<Role> roles;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(final Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}
