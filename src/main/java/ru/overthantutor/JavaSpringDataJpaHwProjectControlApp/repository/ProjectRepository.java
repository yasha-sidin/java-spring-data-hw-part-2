package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.Project;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
