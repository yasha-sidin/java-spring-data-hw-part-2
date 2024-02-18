package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.Project;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.repository.ProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProjectService {
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        Project createdProject = new Project(project.getName(), project.getDescription());
        return projectRepository.save(createdProject);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
