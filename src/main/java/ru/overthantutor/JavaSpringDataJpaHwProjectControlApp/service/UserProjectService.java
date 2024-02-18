package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.Project;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.User;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.repository.ProjectRepository;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserProjectService {
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    public Set<User> getUsersByProjectId(UUID projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.map(Project::getProjectUsers).orElse(null);
    }

    public Set<Project> getProjectsByUserId(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getUserProjects).orElse(null);
    }

    public boolean addUserToProject(UUID userId, UUID projectId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Project> project = projectRepository.findById(projectId);
        if (user.isEmpty() || project.isEmpty()) return false;
        project.get().getProjectUsers().add(user.get());
        projectRepository.save(project.get());
        return true;
    }

    public boolean deleteUserFromProject(UUID userId, UUID projectId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Project> project = projectRepository.findById(projectId);
        if (user.isEmpty() || project.isEmpty()) return false;
        project.get().getProjectUsers().remove(user.get());
        projectRepository.save(project.get());
        return true;
    }
}
