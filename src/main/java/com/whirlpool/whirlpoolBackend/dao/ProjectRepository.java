package com.whirlpool.whirlpoolBackend.dao;

import com.whirlpool.whirlpoolBackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
