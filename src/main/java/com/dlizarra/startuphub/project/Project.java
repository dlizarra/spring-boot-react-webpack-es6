package com.dlizarra.startuphub.project;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.dlizarra.startuphub.user.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// @formatter:off

@EqualsAndHashCode(of = { "name", "description" })
@ToString(of = { "id", "name" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Project {

	static final int MAX_LENGTH_NAME = 100;
	static final int MAX_LENGTH_DESCRIPTION = 1000;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = MAX_LENGTH_NAME)
	private String name;

	@Column(length = MAX_LENGTH_DESCRIPTION)
	private String description;

	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "project2users",
				joinColumns = {	@JoinColumn(name = "project_id", referencedColumnName = "id") }, inverseJoinColumns = {
								@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Set<User> members = new HashSet<User>();

	private LocalDateTime creationTime;
	private LocalDateTime modificationTime;

	@PrePersist
	public void prePersist() {
		creationTime = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		modificationTime = LocalDateTime.now();
	}
}
