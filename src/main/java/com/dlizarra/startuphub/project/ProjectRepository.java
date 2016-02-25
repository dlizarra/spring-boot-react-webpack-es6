package com.dlizarra.startuphub.project;

import com.dlizarra.startuphub.support.jpa.CustomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CustomJpaRepository<Project, Integer> {

}
