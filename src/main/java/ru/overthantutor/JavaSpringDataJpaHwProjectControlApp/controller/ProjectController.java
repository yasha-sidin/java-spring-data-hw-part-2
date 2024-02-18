package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.Project;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.User;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.service.ProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.addProject(project), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProject(@RequestBody Project project) {
        projectService.deleteProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
