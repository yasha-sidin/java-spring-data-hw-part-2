package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.Project;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.User;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.service.UserProjectService;

import java.util.Set;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user-project")
public class UserProjectController {
    private UserProjectService userProjectService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Set<User>> getUsersByProjectId(@PathVariable("id") UUID projectId) {
        return new ResponseEntity<>(userProjectService.getUsersByProjectId(projectId), HttpStatus.CREATED);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Set<Project>> getProjectsByUserId(@PathVariable("id") UUID userId) {
        return new ResponseEntity<>(userProjectService.getProjectsByUserId(userId), HttpStatus.CREATED);
    }

    @PostMapping("/project")
    public ResponseEntity<String> addUserToProject(@RequestBody ControlUserInProjectRequest request) {
        System.out.println(request.getUserId() + " " + request.getProjectId());
        if (userProjectService.addUserToProject(request.getUserId(), request.getProjectId()))
            return new ResponseEntity<>("OK", HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/project")
    public ResponseEntity<String> deleteUserFromProject(@RequestBody ControlUserInProjectRequest request) {
        if (userProjectService.deleteUserFromProject(request.getUserId(), request.getProjectId()))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
